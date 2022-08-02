//
//  ValidatorCard.swift
//  DVS
//
//  Created by Dmitrii Kuzmin on 21.07.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import shared
import ColorKit

struct ValidatorCardView: View {
    
    var validatorModel: ValidatorModel

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
                urlString: validatorModel.avatar,
                size: 120,
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
            
            Text(validatorModel.title)
                .padding(8)
                .frame(maxWidth: .infinity)
                .foregroundColor(Color.white)
                .background(PurpleColor)
                .font(Font.headline.weight(.bold))
                .cornerRadius(4)
            
            Text(validatorModel.getSmallDescription())
                .padding(6)
                .multilineTextAlignment(.leading)
                .foregroundColor(Color.white)
                .background(PurpleColor)
                .font(Font.subheadline.weight(.bold))
                .cornerRadius(4)
                .padding(.top, 8)
            
            
            Spacer()
        }
        .frame(maxWidth: .infinity, minHeight: 300, maxHeight: 300)
        .background(defaultGradient.gradient)
        .cornerRadius(10)
        .overlay(
            RoundedRectangle(cornerRadius: 10)
                .stroke(.white, lineWidth: 2)
        )
    }
}

class GradientWrapper : ObservableObject {
    
    @Published var gradient: LinearGradient
    
    init(gradient: LinearGradient) {
        self.gradient = gradient
    }
}
