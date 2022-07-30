//
//  ValidatorProposalsView.swift
//  DVS
//
//  Created by Dmitrii Kuzmin on 28.07.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import shared

struct ValidatorProposalsView: View {
    
    var state: ValidatorVotesState
    
    var body: some View {
        if (state.proposalsWrapper is RequestStatusLoading) {
            Text("loading")
                .foregroundColor(Color.white)
        } else if (state.proposalsWrapper is RequestStatusError) {
            Text(state.getErrorMessage())
                .font(Font.headline.weight(.bold))
                .foregroundColor(Color.red)
        } else {
            let proposalVotes = (state.proposalsWrapper as! RequestStatusData<ValidatorVotesWrapper>).dataOrNull!.proposals
            
            ScrollView(.vertical, showsIndicators: false) {
                LazyVGrid(columns: [GridItem(.flexible())], spacing: 8) {
                    ForEach(proposalVotes.map { proposalVote in
                        ValidatorProposalVoteItem(validatorVote: proposalVote)
                    }) { validatorVoteItem in
                        ProposalCardView(validatorVote: validatorVoteItem.validatorVote, blockchainNetwork: state.network!.blockchainNetwork)
                    }
                }
            }
        }
    }
}

struct ValidatorProposalVoteItem: Identifiable {
    let id = UUID()
    let validatorVote: ValidatorVote
}
