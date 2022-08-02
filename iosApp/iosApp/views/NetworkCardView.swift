//
//  NetworkCardView.swift
//  DVS
//
//  Created by Dmitrii Kuzmin on 24.07.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import shared

struct NetworkCardView: View {
    
    var blockchainNetwork: BlockchainNetwork
    
    @ObservedObject var defaultGradient: GradientWrapper = GradientWrapper(
        gradient: LinearGradient(
            colors: [.black],
            startPoint: .top,
            endPoint: .center
        )
    )
    
    var body: some View {
        VStack {
            RemoteImageView(
                urlString: blockchainNetwork.imageRef,
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
            .padding(.top, 8)
            
            Text(blockchainNetwork.title)
                .padding(4)
                .frame(maxWidth: .infinity)
                .foregroundColor(Color.white)
                .background(PurpleColor)
                .font(Font.subheadline.weight(.bold))
                .cornerRadius(4)
            
            Spacer()
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
