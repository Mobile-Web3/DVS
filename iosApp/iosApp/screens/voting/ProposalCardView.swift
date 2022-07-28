//
//  ProposalCardView.swift
//  DVS
//
//  Created by Dmitrii Kuzmin on 28.07.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import shared
import WebKit

struct ProposalCardView: View {
    
    let validatorVote: ValidatorVote
    let blockchainNetwork: BlockchainNetwork
    
    @Environment(\.openURL) var openURL
    
    var body: some View {
        ZStack(alignment: .top) {
            HStack {
                Spacer()
                
                Text(validatorVote.vote.string)
                    .font(Font.title)
                    .padding(12)
                    .background(PurpleColor)
                    .foregroundColor(Color(UIColor.init(rgb: Int(validatorVote.vote.color))))
                    .cornerRadius(8)
                    .onTapGesture {
                        if (validatorVote.txhash != nil) {
                            openURL(URL(string: validatorVote.exploreVoteRef(blockchainNetwork: blockchainNetwork))!)
                        }
                    }
            }
            
            VStack {
                HStack {
                    Text("Proposal \(validatorVote.proposal.id)")
                        .font(Font.title)
                        .padding(12)
                        .foregroundColor(Color.white)
                    
                    Spacer()
                }
                
                HStack {
                    Text(validatorVote.proposal.title!)
                        .padding(.horizontal, 12)
                        .foregroundColor(Color.white)
                    
                    Spacer()
                }
                
                HStack {
                    let proposalStatus = ProposalStatus.companion.from(stringStatus: validatorVote.proposal.proposal_status)
                    ProposalStatusView(proposalStatus: proposalStatus)
                    
                    Spacer()
                    
                    ProposalVotesView(proposalPercentages: validatorVote.proposal.getPercentages())
                }
                .padding(.horizontal, 12)
                .padding(.bottom, 12)
            }
        }
        .onTapGesture {
            openURL(URL(string: validatorVote.exploreProposalRef(blockchainNetwork: blockchainNetwork))!)
        }
        .frame(maxWidth: .infinity, alignment: .top)
        .cornerRadius(8)
        .overlay(
            RoundedRectangle(cornerRadius: 8)
                .stroke(PurpleColor, lineWidth: 2)
        )
    }
}

extension UIColor {
    convenience init(rgb: Int) {
        let iBlue = rgb & 0xFF
        let iGreen =  (rgb >> 8) & 0xFF
        let iRed =  (rgb >> 16) & 0xFF
        let iAlpha =  (rgb >> 24) & 0xFF
        self.init(red: CGFloat(iRed)/255, green: CGFloat(iGreen)/255,
                  blue: CGFloat(iBlue)/255, alpha: CGFloat(iAlpha)/255)
    }
}
