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
                //onImageLoaded([UIColor(Color.black)])

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
                                colorWithHexString(hexString: colorHex)
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

func colorWithHexString(hexString: String, alpha:CGFloat = 1.0) -> UIColor {
    
    // Convert hex string to an integer
    let hexint = Int(intFromHexString(hexStr: hexString))
    let red = CGFloat((hexint & 0xff0000) >> 16) / 255.0
    let green = CGFloat((hexint & 0xff00) >> 8) / 255.0
    let blue = CGFloat((hexint & 0xff) >> 0) / 255.0
    
    // Create color object, specifying alpha as well
    let color = UIColor(red: red, green: green, blue: blue, alpha: alpha)
    return color
}

func intFromHexString(hexStr: String) -> UInt32 {
    var hexInt: UInt32 = 0
    // Create scanner
    let scanner: Scanner = Scanner(string: hexStr)
    // Tell scanner to skip the # character
    scanner.charactersToBeSkipped = CharacterSet(charactersIn: "#")
    // Scan hex value
    scanner.scanHexInt32(&hexInt)
    return hexInt
}
