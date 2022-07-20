//
//  MainView.swift
//  iosApp
//
//  Created by Dmitrii Kuzmin on 03.07.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import shared

struct ValidatorListView: ConnectedView {
    
    @EnvironmentObject var store: ObservableValidatorListStore
    
    struct Props {
        let state: ValidatorListState
        
        let onClick: () -> Void
    }
    
    func map(state: ValidatorListState, dispatch: @escaping DispatchFunction) -> Props {
        return Props(
            state: state,
            onClick: {
                dispatch(ValidatorListAction.ValidatorCardSelect())
            }
        )
    }

    func body(props: Props) -> some View {
        VStack {
            Spacer()
            
            VStack(alignment: .center) {
                Text("Count: \(props.state.validatorViewStates.count)")
            }
            
            Spacer()

            HStack(alignment: .bottom) {
                Text("by Mobile Web 3")
            }
            .padding(16)
        }
    }
}
