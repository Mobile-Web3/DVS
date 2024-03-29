//
//  ShimmerProposalView.swift
//  DVS
//
//  Created by Dmitrii Kuzmin on 30.07.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import Shimmer

struct ShimmerProposalView: View {
    var body: some View {
        ZStack(alignment: .top) {
            HStack {
                Spacer()
                
                Text("                ")
                    .padding(12)
                    .background(PurpleColor)
                    .cornerRadius(8)
                    .shimmering()
            }
            
            VStack {
                HStack {
                    Text("               ")
                        .padding(12)
                        .background(Color.white)
                        .cornerRadius(4)
                        .padding(12)
                        .redacted(reason: .placeholder)
                        .shimmering()
                    
                    Spacer()
                }
                
                HStack {
                    Text("                           ")
                        .padding(4)
                        .background(Color.white)
                        .cornerRadius(4)
                        .padding(.horizontal, 12)
                        .redacted(reason: .placeholder)
                        .shimmering()
                    
                    Spacer()
                }
                
                HStack {
                    ProposalStatusShimmerView()
                    
                    Spacer()
                    
                    ProposalVotesShimmerView()
                }
                .padding(12)
            }
        }
        .frame(maxWidth: .infinity, alignment: .top)
        .cornerRadius(8)
        .overlay(
            RoundedRectangle(cornerRadius: 8)
                .stroke(PurpleColor, lineWidth: 2)
        )
    }
}

struct ShimmerProposalView_Previews: PreviewProvider {
    static var previews: some View {
        ShimmerProposalView()
    }
}
