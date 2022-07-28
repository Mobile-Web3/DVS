//
//  ValidatorVotingView.swift
//  DVS
//
//  Created by Dmitrii Kuzmin on 25.07.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import shared

struct ValidatorVotingView: ValidatorVotesConnectedView {
    
    @EnvironmentObject var validatorVotesStore: ObservableValidatorVotesStore
    
    @Environment(\.presentationMode) private var presentationMode: Binding<PresentationMode>
    
    struct Props {
        let state: ValidatorVotesState
        
        let onClick: () -> Void
    }
    
    func map(state: ValidatorVotesState, dispatch: @escaping ValidatorVotesDispatchFunction) -> Props {
        return Props(
            state: state,
            onClick: {
                
            }
        )
    }

    func body(props: Props) -> some View {
        VStack() {
            ValidatorVotingHeader {
                presentationMode.wrappedValue.dismiss()
            }
            
            ValidatorStatusView(
                validatorAvatar: props.state.validatorModel!.avatar,
                networkAvatar: props.state.network!.blockchainNetwork.imageRef,
                validatorInfo: props.state.validatorInfo
            )
            
            
            
            Spacer()
        }
        .frame(maxWidth: .infinity, maxHeight: .infinity)
        .background(Color.black)
        .navigationBarTitle("")
        .navigationBarHidden(true)
    }
}
