//
//  ValidatorCardLoading.swift
//  DVS
//
//  Created by Dmitrii Kuzmin on 20.07.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import Shimmer

struct ValidatorCardLoading: View {
    var body: some View {
        VStack {
            AvatarShimmer()
                .padding(.top, 8)
                .frame(width: 120, height: 120, alignment: Alignment.top)
            
            Text("")
                .padding(8)
                .frame(maxWidth: .infinity)
                .foregroundColor(Color.white)
                .background(PurpleColor)
                .font(Font.headline.weight(.bold))
                .cornerRadius(4)
                .redacted(reason: .placeholder)
                .shimmering()
            
            Spacer()
        }
        .frame(maxWidth: .infinity, minHeight: 300)
        .overlay(
            RoundedRectangle(cornerRadius: 10)
                .stroke(.white, lineWidth: 2)
        )
    }
}

struct ValidatorCardLoading_Previews: PreviewProvider {
    static var previews: some View {
        ValidatorCardLoading()
    }
}
