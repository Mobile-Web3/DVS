//
//  MainView.swift
//  iosApp
//
//  Created by Dmitrii Kuzmin on 03.07.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import shared

struct ValidatorListView: ValidatorListConnectedView {
    
    @EnvironmentObject var validatorListStore: ObservableValidatorListStore
    var validatorDetailsStore: ObservableValidatorDetailsStore
    var validatorVotesStore: ObservableValidatorVotesStore
    var searchNetworkStore: ObservableSearchNetworkStore
    
    @SwiftUI.State var shouldTransit: Bool = false
    
    var twoColumnGrid = [GridItem(.flexible()), GridItem(.flexible())]
    
    struct Props {
        let state: ValidatorListState
        
        let onClick: (ValidatorModel) -> Void
    }
    
    func map(state: ValidatorListState, dispatch: @escaping ValidatorListDispatchFunction) -> Props {
        return Props(
            state: state,
            onClick: { validatorModel in
                validatorDetailsStore.dispatch(ValidatorDetailsAction.ValidatorSelected(validatorModel: validatorModel))
            }
        )
    }

    func body(props: Props) -> some View {
        VStack() {
            DefaultHeaderView()
            
            FindValidatorView(
                searchNetworkStore: searchNetworkStore,
                validatorDetailsStore: validatorDetailsStore,
                validatorVotesStore: validatorVotesStore
            )

            let validatorViewItems = props.state.validatorViewStates.map { ValidatorViewState in
                ValidatorViewItem(isLoading: ValidatorViewState.isLoading, validatorModel: ValidatorViewState.validatorModel)
            }
            
            ScrollView(.vertical, showsIndicators: false) {
                LazyVGrid(columns: twoColumnGrid) {
                    ForEach(validatorViewItems) { item in
                        if (item.isLoading) {
                            ValidatorCardLoading()
                        } else {
                            ValidatorCardView(validatorModel: item.validatorModel!)
                                .onTapGesture {
                                    props.onClick(item.validatorModel!)
                                    self.shouldTransit.toggle()
                                }
                        }
                    }
                }
            }
            
            NavigationLink(
                destination: ValidatorDetailsView(validatorVotesStore: validatorVotesStore)
                    .environmentObject(validatorDetailsStore),
                isActive: $shouldTransit
            ) { EmptyView() }
        }
        .background(Color.black)
    }
}

struct ValidatorViewItem: Identifiable {
    let id = UUID()
    let isLoading: Bool
    let validatorModel: ValidatorModel?
}
