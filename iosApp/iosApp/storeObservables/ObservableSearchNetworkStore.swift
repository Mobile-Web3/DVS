//
//  ObservableSearchNetworkStore.swift
//  DVS
//
//  Created by Dmitrii Kuzmin on 22.07.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import Foundation
import shared

class ObservableSearchNetworkStore: ObservableObject {
    @Published public var state: SearchNetworkState = SearchNetworkState(
        networks: [BlockchainNetwork](), selectedNetwork: nil, validatorsByNetwork: [ValidatorModel]()
    )
//    @Published public var sideEffect: ValidatorVotesSideEffect?
    
    let store: SearchNetworkStore
    
    var stateWatcher : Closeable?
//    var sideEffectWatcher : Closeable?

    init(searchNetworkStore: SearchNetworkStore) {
        self.store = searchNetworkStore
        stateWatcher = self.store.watchState().watch { [weak self] state in
            self?.state = state
        }
//        sideEffectWatcher = self.store.watchSideEffect().watch { [weak self] state in
//            self?.sideEffect = state
//        }
    }
    
    public func dispatch(_ action: SearchNetworkAction) {
        store.dispatch(action: action)
    }
    
    deinit {
        stateWatcher?.close()
//        sideEffectWatcher?.close()
    }
}

public typealias SearchNetworkDispatchFunction = (SearchNetworkAction) -> ()

public protocol SearchNetworkConnectedView: View {
    associatedtype Props
    associatedtype V: View
    
    func map(state: SearchNetworkState, dispatch: @escaping SearchNetworkDispatchFunction) -> Props
    func body(props: Props) -> V
}

public extension SearchNetworkConnectedView {
    func render(state: SearchNetworkState, dispatch: @escaping SearchNetworkDispatchFunction) -> V {
        let props = map(state: state, dispatch: dispatch)
        return body(props: props)
    }
    
    var body: SearchNetworkStoreConnector<V> {
        return SearchNetworkStoreConnector(content: render)
    }
}

public struct SearchNetworkStoreConnector<V: View>: View {
    @EnvironmentObject var store: ObservableSearchNetworkStore
    let content: (SearchNetworkState, @escaping SearchNetworkDispatchFunction) -> V
    
    public var body: V {
        return content(store.state, store.dispatch)
    }
}
