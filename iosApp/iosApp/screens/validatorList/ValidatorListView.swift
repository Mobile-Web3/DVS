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
    
    struct Props {
        let state: ValidatorListState
        
        let onClick: () -> Void
    }
    
    func map(state: ValidatorListState, dispatch: @escaping ValidatorListDispatchFunction) -> Props {
        return Props(
            state: state,
            onClick: {
                dispatch(ValidatorListAction.ValidatorCardSelect())
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
                            ValidatorCardView(validatorModel: item.validatorModel!)
                                .onTapGesture {
                                    
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
