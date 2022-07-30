//
//  SearchValidatorView.swift
//  DVS
//
//  Created by Dmitrii Kuzmin on 30.07.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import shared

struct SearchValidatorView: SearchNetworkConnectedView {
    
    @Environment(\.presentationMode) private var presentationMode: Binding<PresentationMode>
    @SwiftUI.State private var networkName: String = ""
    @SwiftUI.State private var hideClear = true
    
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

            ZStack {
                TextField("Network title", text: $networkName)
                    .placeholder(when: networkName.isEmpty) {
                        Text("Network title").foregroundColor(PurpleColor)
                    }
                    .foregroundColor(PurpleColor)
                    .accentColor(PurpleColor)
                    .padding()
                    .background(RoundedRectangle(cornerRadius: 10).fill(Color.black))
                    .overlay(RoundedRectangle(cornerRadius: 10.0).strokeBorder(PurpleColor, style: StrokeStyle(lineWidth: 1.0)))
                    .onChange(of: networkName) {
                        hideClear = networkName.isEmpty
                        searchNetworkStore.dispatch(SearchNetworkAction.SearchStringChanged(searchString: networkName))
                        print($0)
                    }
                
                HStack {
                    Spacer()
                    
                    Image(systemName: "xmark")
                        .foregroundColor(PurpleColor)
                        .padding(.trailing, 8)
                        .hidden(hideClear)
                        .onTapGesture {
                            networkName = ""
                        }
                }
            }
            
            Text("\(props.state.networks.count)")
                .foregroundColor(Color.white)
            
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
