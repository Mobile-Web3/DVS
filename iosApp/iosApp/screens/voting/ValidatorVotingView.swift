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
            HStack(alignment: .top) {
                Button(action: {
                    presentationMode.wrappedValue.dismiss()
                }, label: {
                    HStack(spacing: 4) {
                        Image(systemName: "arrow.left")
                    }
                })
                .padding(8)
                .accentColor(PurpleColor)
                
                Text("Note: click on proposal to see detailed information.\nClick on validator vote in top right to see the vote transaction")
                    .foregroundColor(Color.white)
                    .onTapGesture {
                        presentationMode.wrappedValue.dismiss()
                    }
            }
            
            
            
            Spacer()
        }
        .frame(maxWidth: .infinity, maxHeight: .infinity)
        .background(Color.black)
        .navigationBarTitle("")
        .navigationBarHidden(true)
    }
}
