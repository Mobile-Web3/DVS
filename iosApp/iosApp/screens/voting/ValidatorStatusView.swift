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
                    HStack() {
                        Text("Rank:")
                            .font(Font.subheadline.weight(.bold))
                            .foregroundColor(Color.white)
                        
                        let validatorInfoData = (validatorInfo as! RequestStatusData<ValidatorInfo>).dataOrNull

                        if (validatorInfoData == nil) {
                            ValidatorTextInfoView(text: "UNKNOWN")
                        } else {
                            ValidatorTextInfoView(text: "\(validatorInfoData!.rank)")
                        }
                    }

                    HStack() {
                        Text("Status:")
                            .font(Font.subheadline.weight(.bold))
                            .foregroundColor(Color.white)
                        
                        let validatorStatus = (validatorInfo as! RequestStatusData<ValidatorInfo>).dataOrNull?.getStatusString()
                        ValidatorTextInfoView(text: validatorStatus!)
                    }
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
