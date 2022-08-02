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
import Foundation

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
                DispatchQueue.global(qos: .background).async {
                    do {
                        let savedColors = Configuration.value(defaultValue: "no color", forKey: urlString)
                        if (savedColors == "no color") {
                            let dominantColorsFreq = try RetrieveImageResult.image.dominantColorFrequencies(with: .best)
                            let sortedColors = dominantColorsFreq
                                .sorted { color1, color2 in
                                    color1.frequency > color2.frequency
                                }
                                .prefix(3)
                                .map { ColorFrequency in
                                    ColorFrequency.color
                                }
                            
                            let isFirstIndexValid = sortedColors.indices.contains(0)
                            let isSecondIndexValid = sortedColors.indices.contains(1)
                            let isThirdIndexValid = sortedColors.indices.contains(2)
                            if (isThirdIndexValid) {
                                Configuration.value(value: "\(sortedColors[0].hex) \(sortedColors[1].hex) \(sortedColors[2].hex)", forKey: urlString)
                            } else if (isSecondIndexValid) {
                                Configuration.value(value: "\(sortedColors[0].hex) \(sortedColors[1].hex)", forKey: urlString)
                            } else if (isFirstIndexValid) {
                                Configuration.value(value: "\(sortedColors[0].hex)", forKey: urlString)
                            }
                            
                            DispatchQueue.main.asyncAfter(deadline: .now(), execute: {
                                onImageLoaded(sortedColors)
                            })
                        } else {
                            let stringColorHexs = savedColors.components(separatedBy: " ")
                            let colors = stringColorHexs.map { colorHex in
                                hexStringToUIColor(hex: colorHex)
                            }
                            
                            DispatchQueue.main.asyncAfter(deadline: .now(), execute: {
                                onImageLoaded(colors)
                            })
                        }
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
