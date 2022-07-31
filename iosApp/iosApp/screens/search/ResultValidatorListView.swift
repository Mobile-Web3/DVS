//
//  ResultValidatorListView.swift
//  DVS
//
//  Created by Dmitrii Kuzmin on 31.07.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import shared

struct ResultValidatorListView: View {
    
    var searchNetworkStore: ObservableSearchNetworkStore
    var validatorDetailsStore: ObservableValidatorDetailsStore
    var validatorVotesStore: ObservableValidatorVotesStore
    var searchNetworkState: SearchNetworkState
    
    var twoColumnGrid = [GridItem(.flexible()), GridItem(.flexible())]
    
    @SwiftUI.State var shouldTransit: Bool = false
    
    var body: some View {
        let validatorViewItems = searchNetworkState.validatorsByNetwork.map { validator in
            ValidatorViewItem(isLoading: false, validatorModel: validator)
        }
        
        ScrollView(.vertical, showsIndicators: false) {
            LazyVGrid(columns: twoColumnGrid) {
                ForEach(validatorViewItems) { item in
                    NavigationLink(
                        destination: ValidatorDetailsView(validatorVotesStore: validatorVotesStore)
                            .environmentObject(validatorDetailsStore), isActive: $shouldTransit
                    ) {
                        ValidatorCardView(validatorModel: item.validatorModel!)
                            .onTapGesture {
                                validatorDetailsStore.dispatch(ValidatorDetailsAction.ValidatorSelected(validatorModel: item.validatorModel!))
                                self.shouldTransit.toggle()
                            }
                    }
                }
            }
        }
    }
}
