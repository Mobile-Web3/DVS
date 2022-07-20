//
//  AvatarShimmer.swift
//  DVS
//
//  Created by Dmitrii Kuzmin on 20.07.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI

struct AvatarShimmer: View {
    var body: some View {
        Circle()
            .fill(Color.white)
            .redacted(reason: .placeholder)
            .shimmering()
    }
}
