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
                    TextShimmer()
                }
                else if (validatorInfo is RequestStatusError) {
                    HStack() {
                        Text("Rank:")
                            .font(Font.subheadline.weight(.bold))
                            .foregroundColor(Color.white)
                        
                        ValidatorTextInfoView(text: "UNKNOWN")
                    }

                    HStack() {
                        Text("Status:")
                            .font(Font.subheadline.weight(.bold))
                            .foregroundColor(Color.white)
                        
                        ValidatorTextInfoView(text: "UNKNOWN")
                    }
                } else {
                    HStack() {
                        Text("Rank:")
                            .font(Font.subheadline.weight(.bold))
                            .foregroundColor(Color.white)
                        
                        let validatorRank = (validatorInfo as! RequestStatusData<ValidatorInfo>).dataOrNull?.getRankString()
                        ValidatorTextInfoView(text: validatorRank!)
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
