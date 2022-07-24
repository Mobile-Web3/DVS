//
//  ValidatorDetailsView.swift
//  DVS
//
//  Created by Dmitrii Kuzmin on 23.07.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import shared

struct ValidatorDetailsView: ValidatorDetailsConnectedView {
    
    @EnvironmentObject var validatorDetailsStore: ObservableValidatorDetailsStore
    @Environment(\.presentationMode) private var presentationMode: Binding<PresentationMode>
    
    @ObservedObject var defaultGradient: GradientWrapper = GradientWrapper(
        gradient: LinearGradient(
            colors: [.black],
            startPoint: .top,
            endPoint: .center
        )
    )
    
    struct Props {
        let state: ValidatorDetailsState
        
        let onClick: () -> Void
    }
    
    func map(state: ValidatorDetailsState, dispatch: @escaping ValidatorDetailsDispatchFunction) -> Props {
        return Props(
            state: state,
            onClick: {
                
            }
        )
    }

    func body(props: Props) -> some View {
        VStack() {
            ZStack(alignment: .topLeading) {
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
                        .background(Color.purple)
                        .font(Font.headline.weight(.bold))
                        .cornerRadius(10)
                }
                .frame(maxWidth: .infinity, minHeight: 200, maxHeight: 200)
                .background(defaultGradient.gradient)
                
                Button(action: {
                    presentationMode.wrappedValue.dismiss()
                }, label: {
                    HStack(spacing: 4) {
                        Image(systemName: "arrow.left")
                    }
                })
                .padding(8)
                .accentColor(PurpleColor)
            }
            .frame(maxWidth: .infinity, alignment: .topLeading)
            
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
                                    .foregroundColor(Color.white)
                            }
                        )
                        .padding(8)
                        .background(Color.purple)
                        .font(Font.subheadline.weight(.bold))
                        .cornerRadius(10)
                    }
                }
            }
            
            Text("\(props.state.selectedTopicIndex)")
                .foregroundColor(Color.white)
            
            Spacer()
        }
        .frame(maxWidth: .infinity, maxHeight: .infinity)
        .background(Color.black)
        .navigationBarTitle("")
        .navigationBarHidden(true)
    }
}


struct ValidatorTopicItem: Identifiable {
    let id = UUID()
    let topic: ValidatorTopic
}
