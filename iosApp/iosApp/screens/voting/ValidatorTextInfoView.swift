//
//  ValidatorTextInfoView.swift
//  DVS
//
//  Created by Dmitrii Kuzmin on 28.07.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI

struct ValidatorTextInfoView: View {
    
    var text: String
    
    var body: some View {
        Text(text)
            .foregroundColor(PurpleColor)
            .font(Font.subheadline.weight(.bold))
    }
}
