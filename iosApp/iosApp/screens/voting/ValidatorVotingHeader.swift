//
//  ValidatorVotingHeader.swift
//  DVS
//
//  Created by Dmitrii Kuzmin on 27.07.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI

struct ValidatorVotingHeader: View {
    
    var onButtonClick: () -> Void
    
    var body: some View {
        HStack(alignment: .top) {
            DefaultButtonBack {
                onButtonClick()
            }
            
            Text("Note: click on proposal to see detailed information.\nClick on validator vote in top right to see the vote transaction")
                .foregroundColor(Color.white)
                .padding(.top, 8)
            
            Spacer()
        }
    }
}
