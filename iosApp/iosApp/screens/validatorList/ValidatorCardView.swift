//
//  ValidatorCard.swift
//  DVS
//
//  Created by Dmitrii Kuzmin on 21.07.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import shared

struct ValidatorCardView: View {
    
    var validatorModel: ValidatorModel
    
    var body: some View {
        VStack {
            RemoteImageView(urlString: validatorModel.avatar, size: 120)
                .padding(.top, 8)
            
            Divider()
            
            Spacer()
        }
        .frame(maxWidth: .infinity, minHeight: 300)
        .cornerRadius(20)
        .overlay(
            RoundedRectangle(cornerRadius: 20)
                .stroke(.white, lineWidth: 2)
        )
    }
}
