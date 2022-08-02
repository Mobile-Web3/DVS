//
//  ProposalVotesShimmerView.swift
//  DVS
//
//  Created by Dmitrii Kuzmin on 30.07.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import Shimmer

struct ProposalVotesShimmerView: View {
    var body: some View {
        Text("  ")
            .frame(width: 100, height: 45)
            .background(Color.white)
            .cornerRadius(100)
            .redacted(reason: .placeholder)
            .shimmering()
    }
}

struct ProposalVotesShimmerView_Previews: PreviewProvider {
    static var previews: some View {
        ProposalVotesShimmerView()
    }
}
