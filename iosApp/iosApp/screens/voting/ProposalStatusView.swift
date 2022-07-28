//
//  ProposalStatusView.swift
//  DVS
//
//  Created by Dmitrii Kuzmin on 28.07.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import shared

struct ProposalStatusView: View {
    
    var proposalStatus: ProposalStatus
    
    var body: some View {
        Text(proposalStatus.title)
            .font(Font.subheadline.weight(.bold))
            .padding(12)
            .foregroundColor(Color(UIColor.init(rgb: Int(proposalStatus.textColor))))
            .background(Color(UIColor.init(rgb: Int(proposalStatus.backgroundColor))))
            .cornerRadius(100)
    }
}
