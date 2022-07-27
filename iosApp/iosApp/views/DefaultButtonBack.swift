//
//  DefaultButtonBack.swift
//  DVS
//
//  Created by Dmitrii Kuzmin on 27.07.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI

struct DefaultButtonBack: View {
    
    var onButtonClick: () -> Void
    
    var body: some View {
        Button(action: {
            onButtonClick()
        }, label: {
            HStack(spacing: 4) {
                Image(systemName: "arrow.left")
            }
        })
        .padding(8)
        .accentColor(PurpleColor)
    }
}
