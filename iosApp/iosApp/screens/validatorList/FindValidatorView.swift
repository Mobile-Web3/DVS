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
    @SwiftUI.State var shouldTransitToSearch: Bool = false
    var searchNetworkStore: ObservableSearchNetworkStore
    
    var body: some View {
        HStack() {
            NavigationLink(destination: SearchValidatorView().environmentObject(searchNetworkStore), isActive: $shouldTransitToSearch) {
                Image(systemName: "magnifyingglass")
                    .foregroundColor(Color.white)
            }
            
            NavigationLink(destination: SearchValidatorView().environmentObject(searchNetworkStore), isActive: $shouldTransitToSearch) {
                Text("Search by network")
                    .foregroundColor(Color.white)
            }
            
            Spacer()
            
            NavigationLink(destination: DVSInfoView(), isActive: $shouldTransitToInfo) {
                Image(systemName: "info.circle.fill")
                    .foregroundColor(Color.white)
            }
        }
        .frame(height: 30, alignment: .leading)
    }
}
