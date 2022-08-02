//
//  ValidatorDetailsView.swift
//  DVS
//
//  Created by Dmitrii Kuzmin on 23.07.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import shared
import WebKit
import SwiftUIFlowLayout
import MarkdownKit

struct ValidatorDetailsView: ValidatorDetailsConnectedView {
    
    @EnvironmentObject var validatorDetailsStore: ObservableValidatorDetailsStore
    var validatorVotesStore: ObservableValidatorVotesStore

    @SwiftUI.State var shouldTransitToVotes: Bool = false
    
    var markdownParser = MarkdownParser()
    var threeColumnGrid = [GridItem(.flexible()), GridItem(.flexible()), GridItem(.flexible())]
    
    @ObservedObject var defaultGradient: GradientWrapper = GradientWrapper(
        gradient: LinearGradient(
            colors: [.black],
            startPoint: .top,
            endPoint: .center
        )
    )
    
    struct Props {
        let state: ValidatorDetailsState
        
        let onClick: (ValidatorModel, ValidatorNetwork) -> Void
    }
    
    func map(state: ValidatorDetailsState, dispatch: @escaping ValidatorDetailsDispatchFunction) -> Props {
        return Props(
            state: state,
            onClick: { ValidatorModel, ValidatorNetwork in
                validatorVotesStore.dispatch(ValidatorVotesAction.NetworkSelected(validatorModel: ValidatorModel, network: ValidatorNetwork))
            }
        )
    }

    func body(props: Props) -> some View {
        VStack() {
            VStack {
                RemoteImageView(
                    urlString: props.state.validatorModel!.avatar,
                    size: 120,
                    onImageLoaded: { colors in
                        let newGradient = LinearGradient(
                            colors: colors.map({ it in Color(it)}),
                            startPoint: .topLeading,
                            endPoint: .bottomTrailing
                        )

                        defaultGradient.gradient = newGradient
                    }
                )
                
                Text(props.state.validatorModel!.title)
                    .padding(8)
                    .foregroundColor(Color.white)
                    .background(PurpleColor)
                    .font(Font.headline.weight(.bold))
                    .cornerRadius(4)
            }
            .frame(maxWidth: .infinity, minHeight: 200, maxHeight: 200)
            .background(defaultGradient.gradient)
            
            let validatorTopicItems = props.state.validatorModel!.getTopics().map { validatorTopic in
                ValidatorTopicItem(topic: validatorTopic)
            }
            
            ScrollView(.horizontal, showsIndicators: false) {
                HStack(spacing: 8) {
                    ForEach(validatorTopicItems) { topicViewItem in
                        Button(
                            action: {
                                validatorDetailsStore.dispatch(ValidatorDetailsAction.TopicSelected(index: topicViewItem.topic.topicIndex))
                            },
                            label: {
                                Text(topicViewItem.topic.title)
                                    .font(Font.subheadline.weight(.bold))
                                    .foregroundColor(Color.white)
                            }
                        )
                        .padding(12)
                        .background(PurpleColor)
                        .font(Font.headline.weight(.bold))
                        .cornerRadius(4)
                    }
                }
            }
            
            if (!validatorTopicItems.isEmpty) {
                let topicContent = validatorTopicItems[Int(props.state.selectedTopicIndex)].topic.topicContent.map { topicContent in
                    ValidatorTopicContentItem(content: topicContent)
                }
                
                ForEach(topicContent) { content in
                    switch content.content {
                    case is ValidatorTopicContent.SimpleText:
                        ScrollView(.vertical, showsIndicators: false) {
                            Text(
                                .init("\(props.state.validatorModel!.transformTextWithLinksForIos(text: (content.content as! ValidatorTopicContent.SimpleText).text))")
                            )
                            .foregroundColor(Color.white)
                        }
                        .padding(.horizontal, 16)
                    
                    case is ValidatorTopicContent.ButtonsWithRefFlow:
                        FlowLayout(
                            mode: .scrollable,
                            items: (content.content as! ValidatorTopicContent.ButtonsWithRefFlow).buttons,
                            viewMapping: { button in
                                Button(
                                    action: {
                                        if (button.reference != nil) {
                                            UIApplication.shared.open(URL(string: button.reference!)!)
                                        }
                                    },
                                    label: {
                                        Text(button.text)
                                            .foregroundColor(Color.white)
                                    }
                                )
                                .padding(8)
                                .background(PurpleColor)
                                .font(Font.subheadline.weight(.bold))
                                .cornerRadius(100)
                            }
                        )
                        .padding(.horizontal, 16)
                        
                    case is ValidatorTopicContent.MainNetworks:
                        ScrollView(.vertical, showsIndicators: false) {
                            LazyVGrid(columns: threeColumnGrid, spacing: 8) {
                                ForEach((content.content as! ValidatorTopicContent.MainNetworks).networks.map { network in
                                    ValidatorMainNetworkItem(validatorNetwork: network)
                                }) { networkItem in
                                    NetworkCardView(blockchainNetwork: networkItem.validatorNetwork.blockchainNetwork)
                                        .onTapGesture {
                                            UIApplication.shared.open(URL(string: networkItem.validatorNetwork.getValidatorPageLink())!)
                                        }
                                }
                            }
                        }
                        .padding(.horizontal, 16)
                        
                    case is ValidatorTopicContent.VotingNetworks:
                        ScrollView(.vertical, showsIndicators: false) {
                            LazyVGrid(columns: threeColumnGrid, spacing: 8) {
                                ForEach((content.content as! ValidatorTopicContent.VotingNetworks).networks.map { network in
                                    ValidatorVotingNetworkItem(validatorNetwork: network)
                                }) { networkItem in
                                    NetworkCardView(blockchainNetwork: networkItem.validatorNetwork.blockchainNetwork)
                                        .onTapGesture {
                                            props.onClick(props.state.validatorModel!, networkItem.validatorNetwork)
                                            self.shouldTransitToVotes.toggle()
                                        }
                                }
                            }
                        }
                        .padding(.horizontal, 16)
                        
                    case is ValidatorTopicContent.Contacts:
                        ValidatorContactsRow(
                            topicContacts: (content.content as! ValidatorTopicContent.Contacts).contacts
                        )
                        .padding(.horizontal, 16)
                        
                    default:
                        Text("default")
                            .foregroundColor(Color.white)
                    }
                }
            }

            NavigationLink(
                destination: ValidatorVotingView().environmentObject(validatorVotesStore),
                isActive: $shouldTransitToVotes
            ) {
                EmptyView()
            }
            
            Spacer()
        }
        .frame(maxWidth: .infinity, maxHeight: .infinity)
        .background(Color.black)
        .navigationBarTitleDisplayMode(.inline)
        .navigationBarTitle("Validator details")
    }
}


struct ValidatorTopicItem: Identifiable {
    let id = UUID()
    let topic: ValidatorTopic
}

struct ValidatorTopicContentItem: Identifiable {
    let id = UUID()
    let content: ValidatorTopicContent
}

struct ValidatorMainNetworkItem: Identifiable {
    let id = UUID()
    let validatorNetwork: ValidatorNetwork
}

struct ValidatorVotingNetworkItem: Identifiable {
    let id = UUID()
    let validatorNetwork: ValidatorNetwork
}
