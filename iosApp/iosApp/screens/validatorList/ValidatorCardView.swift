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
            endPoint: .center)
    )
    
    var body: some View {
        VStack {
            RemoteImageView(
                urlString: validatorModel.avatar,
                size: 120,
                onImageLoaded: { RetrieveImageResult in
                    defaultGradient.gradient = LinearGradient(
                        colors: [.orange, .red],
                        startPoint: .top,
                        endPoint: .center
                    )
                }
            )
            .padding(.top, 8)
            
            Spacer()
        }
        .frame(maxWidth: .infinity, minHeight: 300)
        .background(defaultGradient.gradient)
        .cornerRadius(20)
        .overlay(
            RoundedRectangle(cornerRadius: 20)
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
