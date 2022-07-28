//
//  ProposalVotesView.swift
//  DVS
//
//  Created by Dmitrii Kuzmin on 28.07.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import shared

struct ProposalVotesView: View {
    
    var proposalPercentages: ProposalPercentages
    
    var body: some View {
        HStack(spacing: 0) {
            Text("  ")
                .frame(width: proposalPercentages.yes, height: 45)
                .background(Color(UIColor.init(rgb: Int(Vote.yes.color))))
            
            Text("")
                .frame(width: proposalPercentages.no, height: 45)
                .background(Color(UIColor.init(rgb: Int(Vote.no.color))))
            
            Text("")
                .frame(width: proposalPercentages.noWithVeto, height: 45)
                .background(Color(UIColor.init(rgb: Int(Vote.noWithVeto.color))))
            
            Text("")
                .frame(width: proposalPercentages.abstain, height: 45)
                .background(Color(UIColor.init(rgb: Int(Vote.abstain.color))))
        }
        .cornerRadius(100)
    }
}
