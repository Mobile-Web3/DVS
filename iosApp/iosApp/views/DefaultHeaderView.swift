//
//  DefaultHeaderView.swift
//  DVS
//
//  Created by Dmitrii Kuzmin on 20.07.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI

struct DefaultHeaderView: View {
    var body: some View {
        Image("DefaultHeader")
                    .resizable()
                    .scaledToFit()
    }
}

struct DefaultHeaderView_Previews: PreviewProvider {
    static var previews: some View {
        DefaultHeaderView()
    }
}
