//
//  MainView.swift
//  iosApp
//
//  Created by Dmitrii Kuzmin on 03.07.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import shared

struct MainView: ConnectedView {
    
    @EnvironmentObject var store: ObservableMainStore
    
    struct Props {
        let count: Int32
        
        let onClick: () -> Void
    }
    
    func map(state: MainState, dispatch: @escaping DispatchFunction) -> Props {
        return Props(
            count: state.count,
            onClick: {
                dispatch(MainAction.Click())
            }
        )
    }

    func body(props: Props) -> some View {
        VStack {
            Spacer()
            
            VStack(alignment: .center) {
                Text("Count: \(props.count)")
                    .onTapGesture {
                        props.onClick()
                    }
            }
            
            Spacer()

            HStack(alignment: .bottom) {
                Text("by Mobile Web 3")
            }
            .padding(16)
        }
    }
}

struct MainView_Previews: PreviewProvider {
    static var previews: some View {
        MainView()
    }
}
