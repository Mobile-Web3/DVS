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
        TextShimmer()
            .frame(width: 100, height: 45)
            .cornerRadius(100)
    }
}

struct ProposalVotesShimmerView_Previews: PreviewProvider {
    static var previews: some View {
        ProposalVotesShimmerView()
    }
}
