//
//  FindValidatorView.swift
//  DVS
//
//  Created by Dmitrii Kuzmin on 30.07.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI

struct FindValidatorView: View {
    
    @SwiftUI.State var shouldTransitToInfo: Bool = false
    
    var body: some View {
        HStack() {
            Image(systemName: "magnifyingglass")
                .foregroundColor(Color.white)
            
            Text("Search by network")
                .foregroundColor(Color.white)
            
            Spacer()
            
            NavigationLink(destination: DVSInfoView(), isActive: $shouldTransitToInfo) {
                Image(systemName: "info.circle.fill")
                    .foregroundColor(Color.white)
            }
        }
        .frame(height: 30, alignment: .leading)
    }
}
