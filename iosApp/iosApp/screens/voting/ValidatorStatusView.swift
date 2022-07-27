//
//  ValidatorStatusView.swift
//  DVS
//
//  Created by Dmitrii Kuzmin on 27.07.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import shared

struct ValidatorStatusView: View {
    
    var validatorAvatar: String
    var networkAvatar: String
    var validatorInfo: RequestStatus<ValidatorInfo>
    
    var body: some View {
        HStack() {
            VStack(alignment: .leading) {
                if (validatorInfo is RequestStatusLoading) {
                    Text("Loading:")
                        .font(Font.subheadline.weight(.bold))
                        .foregroundColor(Color.white)
                }
                else if (validatorInfo is RequestStatusError) {
                    Text("Error:")
                        .font(Font.subheadline.weight(.bold))
                        .foregroundColor(Color.white)
                } else {
                    Text("Rank:")
                        .font(Font.subheadline.weight(.bold))
                        .foregroundColor(Color.white)

                    Text("Status:")
                        .font(Font.subheadline.weight(.bold))
                        .foregroundColor(Color.white)
                }
            }
            
            Spacer()
            
            RemoteImageView(urlString: validatorAvatar, size: 50) { colors in
                
            }
            
            RemoteImageView(urlString: networkAvatar, size: 50) { colors in
                
            }
        }
    }
}
