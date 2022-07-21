//
//  RemoteImageView.swift
//  DVS
//
//  Created by Dmitrii Kuzmin on 21.07.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import Kingfisher

struct RemoteImageView: View {
    
    var urlString: String
    var size: CoreGraphics.CGFloat
    var onImageLoaded: ((RetrieveImageResult) -> Void)

    var body: some View {
        KFImage(URL(string: urlString)!)
            .resizable()
            .placeholder { Progress in
                AvatarShimmer()
            }
            .onSuccess({ RetrieveImageResult in
                onImageLoaded(RetrieveImageResult)
            })
            .fade(duration: 1)
            .frame(width: size, height: size)
            .cornerRadius(100)
            .overlay(
                RoundedRectangle(cornerRadius: 100)
                    .stroke(.white, lineWidth: 2)
            )
        
    }
}
