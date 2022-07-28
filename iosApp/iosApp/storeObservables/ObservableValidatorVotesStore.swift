//
//  ObservableValidatorVotesStore.swift
//  DVS
//
//  Created by Dmitrii Kuzmin on 22.07.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import Foundation
import shared

class ObservableValidatorVotesStore: ObservableObject {
    @Published public var state: ValidatorVotesState = ValidatorVotesState(
        validatorModel: nil, network: nil, proposalsWrapper: RequestStatusLoading(), validatorInfo: RequestStatusLoading()
    )
//    @Published public var sideEffect: ValidatorVotesSideEffect?
    
    let store: ValidatorVotesStore
    
    var stateWatcher : Closeable?
//    var sideEffectWatcher : Closeable?

    init(validatorVotesStore: ValidatorVotesStore) {
        self.store = validatorVotesStore
        stateWatcher = self.store.watchState().watch { [weak self] state in
            self?.state = state
        }
//        sideEffectWatcher = self.store.watchSideEffect().watch { [weak self] state in
//            self?.sideEffect = state
//        }
    }
    
    public func dispatch(_ action: ValidatorVotesAction) {
        store.dispatch(action: action)
    }
    
    deinit {
        stateWatcher?.close()
//        sideEffectWatcher?.close()
    }
}

public typealias ValidatorVotesDispatchFunction = (ValidatorVotesAction) -> ()

public protocol ValidatorVotesConnectedView: View {
    associatedtype Props
    associatedtype V: View
    
    func map(state: ValidatorVotesState, dispatch: @escaping ValidatorVotesDispatchFunction) -> Props
    func body(props: Props) -> V
}

public extension ValidatorVotesConnectedView {
    func render(state: ValidatorVotesState, dispatch: @escaping ValidatorVotesDispatchFunction) -> V {
        let props = map(state: state, dispatch: dispatch)
        return body(props: props)
    }
    
    var body: ValidatorVotesStoreConnector<V> {
        return ValidatorVotesStoreConnector(content: render)
    }
}

public struct ValidatorVotesStoreConnector<V: View>: View {
    @EnvironmentObject var store: ObservableValidatorVotesStore
    let content: (ValidatorVotesState, @escaping ValidatorVotesDispatchFunction) -> V
    
    public var body: V {
        return content(store.state, store.dispatch)
    }
}
