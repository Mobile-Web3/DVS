//
//  ValidatorDetailsView.swift
//  DVS
//
//  Created by Dmitrii Kuzmin on 23.07.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import shared

struct ValidatorDetailsView: ValidatorDetailsConnectedView {
    
    @EnvironmentObject var validatorDetailsStore: ObservableValidatorDetailsStore
    @Environment(\.presentationMode) private var presentationMode: Binding<PresentationMode>
    
    @ObservedObject var defaultGradient: GradientWrapper = GradientWrapper(
        gradient: LinearGradient(
            colors: [.black],
            startPoint: .top,
            endPoint: .center
        )
    )
    
    struct Props {
        let state: ValidatorDetailsState
        
        let onClick: () -> Void
    }
    
    func map(state: ValidatorDetailsState, dispatch: @escaping ValidatorDetailsDispatchFunction) -> Props {
        return Props(
            state: state,
            onClick: {
                
            }
        )
    }

    func body(props: Props) -> some View {
        ZStack(alignment: .topLeading) {
            VStack {
                RemoteImageView(
                    urlString: props.state.validatorModel!.avatar,
                    size: 120,
                    onImageLoaded: { colors in
                        let newGradient = LinearGradient(
                            colors: colors.map({ it in Color(it)}),
                            startPoint: .topLeading,
                            endPoint: .bottomTrailing
                        )

                        defaultGradient.gradient = newGradient
                    }
                )
                
                Text(props.state.validatorModel!.title)
                    .padding(8)
                    .foregroundColor(Color.white)
                    .background(Color.purple)
                    .font(Font.headline.weight(.bold))
                    .cornerRadius(10)
            }
            .frame(maxWidth: .infinity, minHeight: 200, maxHeight: 200)
            .background(defaultGradient.gradient)
            
            Button(action: {
                presentationMode.wrappedValue.dismiss()
            }, label: {
                HStack(spacing: 4) {
                    Image(systemName: "arrow.left")
                }
            })
            .padding(8)
            .accentColor(PurpleColor)
        }
        .frame(maxWidth: .infinity, maxHeight: .infinity, alignment: .topLeading)
        .navigationBarTitle("")
        .navigationBarHidden(true)
    }
}
