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
        Text("               ")
            .padding(12)
            .background(Color.white)
            .cornerRadius(100)
            .redacted(reason: .placeholder)
            .shimmering()
    }
}

struct ProposalStatusShimmerView_Previews: PreviewProvider {
    static var previews: some View {
        ProposalStatusShimmerView()
    }
}
