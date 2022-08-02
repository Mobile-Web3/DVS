//
//  DVSInfoView.swift
//  DVS
//
//  Created by Dmitrii Kuzmin on 30.07.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI

struct DVSInfoView: View {

    @Environment(\.openURL) var openURL
    
    @State var appear = false
    
    var body: some View {
        VStack {
            DefaultHeaderView()
            
            Spacer()
            
            Image("DvsLogo")
                .resizable()
                .scaledToFit()
                .frame(width: 110, height: 110)
                //.rotationEffect(Angle(degrees: appear ? -360 : 0))
                //.offset(y: appear ? -10 : 0)
//                .animation(Animation.linear(duration: 3).repeatForever(autoreverses: false))
//                .onAppear {
//                    appear = true
//                }
            
            Image("DvsCredo")
                .resizable()
                .scaledToFit()
            
            Text("validators.network")
                .foregroundColor(Color.white)
                .underline()
                .onTapGesture {
                    openURL(URL(string: "https://validators.network/")!)
                }
            
            Spacer()
            
            Text("Made by Mobile Web3")
                .foregroundColor(PurpleColor)
        }
        .frame(maxWidth: .infinity, maxHeight: .infinity)
        .background(Color.black)
        .navigationBarTitle("Info")
        .navigationBarTitleDisplayMode(.inline)
    }
}

struct DVSInfoView_Previews: PreviewProvider {
    static var previews: some View {
        DVSInfoView()
    }
}
