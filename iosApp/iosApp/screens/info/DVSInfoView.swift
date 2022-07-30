//
//  DVSInfoView.swift
//  DVS
//
//  Created by Dmitrii Kuzmin on 30.07.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI

struct DVSInfoView: View {
    
    @Environment(\.presentationMode) private var presentationMode: Binding<PresentationMode>
    @State var appear = false
    
    var body: some View {
        VStack {
            ZStack {
                HStack {
                    DefaultButtonBack {
                        presentationMode.wrappedValue.dismiss()
                    }
                    
                    Spacer()
                }
                
                HStack {
                    Text("Info")
                        .foregroundColor(Color.white)
                }
            }
            
            DefaultHeaderView()
            
            Spacer()
            
            Image("DvsLogo")
                .resizable()
                .scaledToFit()
                .frame(width: 110, height: 110)
                .rotationEffect(Angle(degrees: appear ? -360 : 0))
                .offset(y: appear ? -10 : 0)
                .animation(Animation.linear(duration: 3).repeatForever(autoreverses: false))
                .onAppear {
                    appear = true
                }
            
            Image("DvsCredo")
                .resizable()
                .scaledToFit()
            
            Spacer()
            
            Text("Made by Mobile Web3")
                .foregroundColor(PurpleColor)
        }
        .frame(maxWidth: .infinity, maxHeight: .infinity)
        .background(Color.black)
        .navigationBarTitle("")
        .navigationBarHidden(true)
    }
}

struct DVSInfoView_Previews: PreviewProvider {
    static var previews: some View {
        DVSInfoView()
    }
}
