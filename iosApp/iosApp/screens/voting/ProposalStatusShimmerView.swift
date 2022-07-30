//
//  ProposalStatusShimmerView.swift
//  DVS
//
//  Created by Dmitrii Kuzmin on 30.07.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import Shimmer

struct ProposalStatusShimmerView: View {
    var body: some View {
        TextShimmer()
            .padding(12)
            .cornerRadius(100)
            .shimmering()
    }
}

struct ProposalStatusShimmerView_Previews: PreviewProvider {
    static var previews: some View {
        ProposalStatusShimmerView()
    }
}
