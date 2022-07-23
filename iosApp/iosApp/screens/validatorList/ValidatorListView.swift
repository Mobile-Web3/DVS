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
    @EnvironmentObject var validatorDetailsStore: ObservableValidatorDetailsStore
    
    @SwiftUI.State var shouldTransit: Bool = false
    
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
            
            let twoColumnGrid = [GridItem(.flexible()), GridItem(.flexible())]
            let validatorViewItems = props.state.validatorViewStates.map { ValidatorViewState in
                ValidatorViewItem(isLoading: ValidatorViewState.isLoading, validatorModel: ValidatorViewState.validatorModel)
            }
            
            ScrollView(.vertical, showsIndicators: false) {
                LazyVGrid(columns: twoColumnGrid) {
                    ForEach(validatorViewItems) { item in
                        if (item.isLoading) {
                            ValidatorCardLoading()
                        } else {
                            NavigationLink(
                                destination: ValidatorDetailsView()
                                    .environmentObject(validatorDetailsStore), isActive: $shouldTransit
                            ) {
                                ValidatorCardView(validatorModel: item.validatorModel!)
                                    .onTapGesture {
                                        props.onClick(item.validatorModel!)
                                        self.shouldTransit.toggle()
                                    }
                            }
                        }
                    }
                }
            }
        }
        .background(Color.black)
    }
}

struct ValidatorViewItem: Identifiable {
    let id = UUID()
    let isLoading: Bool
    let validatorModel: ValidatorModel?
}
