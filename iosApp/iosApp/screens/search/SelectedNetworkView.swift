//
//  SelectedNetworkView.swift
//  DVS
//
//  Created by Dmitrii Kuzmin on 31.07.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import shared

struct SelectedNetworkView: View {
    
    var searchNetworkStore: ObservableSearchNetworkStore
    var selectedNetwork: BlockchainNetwork
    
    @ObservedObject var defaultGradient: GradientWrapper = GradientWrapper(
        gradient: LinearGradient(
            colors: [.black],
            startPoint: .top,
            endPoint: .center
        )
    )
    
    var body: some View {
        ZStack {
            HStack {
                RemoteImageView(
                    urlString: selectedNetwork.imageRef,
                    size: 40,
                    onImageLoaded: { colors in
                        let newGradient = LinearGradient(
                            colors: colors.map({ it in Color(it)}),
                            startPoint: .topLeading,
                            endPoint: .bottomTrailing
                        )

                        defaultGradient.gradient = newGradient
                    }
                )
                .padding(16)
                
                Spacer()
                
                Image(systemName: "xmark")
                    .foregroundColor(PurpleColor)
                    .padding(.trailing, 8)
                    .onTapGesture {
                        searchNetworkStore.dispatch(SearchNetworkAction.NetworkSelectCanceled())
                    }
            }
            
            HStack {
                Text(selectedNetwork.title)
                    .padding(4)
                    .foregroundColor(Color.white)
                    .background(PurpleColor)
                    .font(Font.title2.weight(.bold))
                    .cornerRadius(4)
            }
        }
        .frame(maxWidth: .infinity)
        .background(defaultGradient.gradient)
        .cornerRadius(10)
        .overlay(
            RoundedRectangle(cornerRadius: 10)
                .stroke(.white, lineWidth: 2)
        )
    }
}
