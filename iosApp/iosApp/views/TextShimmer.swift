//
//  TextShimmer.swift
//  DVS
//
//  Created by Dmitrii Kuzmin on 20.07.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import Shimmer

struct TextShimmer: View {
    var body: some View {
        Text("loading card")
            .foregroundColor(Color.white)
            .background(Color.white)
            .redacted(reason: .placeholder)
            .shimmering()
    }
}

struct TextShimmer_Previews: PreviewProvider {
    static var previews: some View {
        TextShimmer()
    }
}
