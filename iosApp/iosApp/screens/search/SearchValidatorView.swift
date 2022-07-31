//
//  SearchValidatorView.swift
//  DVS
//
//  Created by Dmitrii Kuzmin on 30.07.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import shared
import AVFAudio

struct SearchValidatorView: SearchNetworkConnectedView {
    
    @Environment(\.presentationMode) private var presentationMode: Binding<PresentationMode>
    
    @EnvironmentObject var searchNetworkStore: ObservableSearchNetworkStore
    
    struct Props {
        let state: SearchNetworkState
        
        let onClick: () -> Void
    }
    
    func map(state: SearchNetworkState, dispatch: @escaping SearchNetworkDispatchFunction) -> Props {
        return Props(
            state: state,
            onClick: {
                
            }
        )
    }

    func body(props: Props) -> some View {
        VStack {
            HStack {
                DefaultButtonBack {
                    presentationMode.wrappedValue.dismiss()
                }
                
                Spacer()
            }
            
            DefaultHeaderView()
            
            if (props.state.selectedNetwork == nil) {
                SearchNetworkView(searchNetworkStore: searchNetworkStore, searchNetworkState: props.state)
            } else {
                
            }

            Spacer()
        }
        .frame(maxWidth: .infinity, maxHeight: .infinity)
        .background(Color.black)
        .navigationBarTitle("")
        .navigationBarHidden(true)
    }
}

extension View {
    func placeholder<Content: View>(
        when shouldShow: Bool,
        alignment: Alignment = .leading,
        @ViewBuilder placeholder: () -> Content) -> some View {

        ZStack(alignment: alignment) {
            placeholder().opacity(shouldShow ? 1 : 0)
            self
        }
    }
    
    func hidden(_ shouldHide: Bool) -> some View {
        opacity(shouldHide ? 0 : 1)
    }
}
