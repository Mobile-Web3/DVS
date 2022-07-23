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
            Text(props.state.validatorModel!.title)
        }
        .background(Color.white)
    }
}
