//
//  RemoteImageView.swift
//  DVS
//
//  Created by Dmitrii Kuzmin on 21.07.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import Kingfisher
import ColorKit

struct RemoteImageView: View {
    
    var urlString: String
    var size: CoreGraphics.CGFloat
    var onImageLoaded: (([UIColor]) -> Void)

    var body: some View {
        KFImage(URL(string: urlString)!)
            .resizable()
            .placeholder { Progress in
                AvatarShimmer()
            }
            .onSuccess({ RetrieveImageResult in
                onImageLoaded([UIColor(Color.black)])

                DispatchQueue.global(qos: .background).async {
                    do {
                        let dominantColorsFreq = try RetrieveImageResult.image.dominantColorFrequencies(with: .best)
                        let sortedColors = dominantColorsFreq
                            .sorted { color1, color2 in
                                color1.frequency > color2.frequency
                            }
                            .prefix(3)
                            .map { ColorFrequency in
                                ColorFrequency.color
                            }
                        
                        DispatchQueue.main.asyncAfter(deadline: .now(), execute: {
                            onImageLoaded(sortedColors)
                        })
                    } catch {
                        
                    }
                }
            })
            .fade(duration: 1)
            .background(Color.white)
            .frame(width: size, height: size)
            .cornerRadius(100)
            .overlay(
                RoundedRectangle(cornerRadius: 100)
                    .stroke(.white, lineWidth: 2)
            )
        
    }
}
