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
    var validatorDetailsStore: ObservableValidatorDetailsStore
    var validatorVotesStore: ObservableValidatorVotesStore
    
    var body: some View {
        HStack() {
            Image(systemName: "magnifyingglass")
                .foregroundColor(Color.white)
                .onTapGesture {
                    self.shouldTransitToSearch.toggle()
                }
            
            Text("Search by network")
                .foregroundColor(Color.white)
                .onTapGesture {
                    self.shouldTransitToSearch.toggle()
                }
            
            Spacer()
            
            Image(systemName: "info.circle.fill")
                .foregroundColor(Color.white)
                .onTapGesture {
                    self.shouldTransitToInfo.toggle()
                }
            
            NavigationLink(
                destination: SearchValidatorView(
                    validatorDetailsStore: validatorDetailsStore,
                    validatorVotesStore: validatorVotesStore
                )
                .environmentObject(searchNetworkStore),
                isActive: $shouldTransitToSearch
            ) {
                EmptyView()
            }
            
            NavigationLink(destination: DVSInfoView(), isActive: $shouldTransitToInfo) {
                EmptyView()
            }
        }
        .frame(height: 30, alignment: .leading)
    }
}
