//
//  SearchNetworkView.swift
//  DVS
//
//  Created by Dmitrii Kuzmin on 31.07.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import shared

struct SearchNetworkView: View {
    
    var searchNetworkStore: ObservableSearchNetworkStore
    var searchNetworkState: SearchNetworkState
    
    @SwiftUI.State private var networkName: String = ""
    @SwiftUI.State private var hideClear = true
    
    var threeColumnGrid = [GridItem(.flexible()), GridItem(.flexible()), GridItem(.flexible())]
    
    var body: some View {
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
        
        ScrollView(.vertical, showsIndicators: false) {
            LazyVGrid(columns: threeColumnGrid, spacing: 8) {
                ForEach(searchNetworkState.networks.map { network in
                    SearchNetworkItem(blockchainNetwork: network)
                }) { networkItem in
                    NetworkCardView(blockchainNetwork: networkItem.blockchainNetwork)
                        .onTapGesture {
                            searchNetworkStore.dispatch(SearchNetworkAction.NetworkSelected(network: networkItem.blockchainNetwork))
                        }
                }
            }
        }
    }
}

struct SearchNetworkItem: Identifiable {
    let id = UUID()
    let blockchainNetwork: BlockchainNetwork
}
