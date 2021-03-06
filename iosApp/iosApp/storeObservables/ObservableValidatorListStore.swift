//
//  ObservableValidatorListStore.swift
//  DVS
//
//  Created by Dmitrii Kuzmin on 22.07.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import Foundation
import shared

class ObservableValidatorListStore: ObservableObject {
    @Published public var state: ValidatorListState = ValidatorListState(validatorViewStates: [ValidatorViewState]())
    @Published public var sideEffect: ValidatorListSideEffect?
    
    let store: ValidatorListStore
    
    var stateWatcher : Closeable?
    var sideEffectWatcher : Closeable?

    init(validatorListStore: ValidatorListStore) {
        self.store = validatorListStore
        stateWatcher = self.store.watchState().watch { [weak self] state in
            self?.state = state
        }
        sideEffectWatcher = self.store.watchSideEffect().watch { [weak self] state in
            self?.sideEffect = state
        }
    }
    
    public func dispatch(_ action: ValidatorListAction) {
        store.dispatch(action: action)
    }
    
    deinit {
        stateWatcher?.close()
        sideEffectWatcher?.close()
    }
}

public typealias ValidatorListDispatchFunction = (ValidatorListAction) -> ()

public protocol ValidatorListConnectedView: View {
    associatedtype Props
    associatedtype V: View
    
    func map(state: ValidatorListState, dispatch: @escaping ValidatorListDispatchFunction) -> Props
    func body(props: Props) -> V
}

public extension ValidatorListConnectedView {
    func render(state: ValidatorListState, dispatch: @escaping ValidatorListDispatchFunction) -> V {
        let props = map(state: state, dispatch: dispatch)
        return body(props: props)
    }
    
    var body: ValidatorListStoreConnector<V> {
        return ValidatorListStoreConnector(content: render)
    }
}

public struct ValidatorListStoreConnector<V: View>: View {
    @EnvironmentObject var store: ObservableValidatorListStore
    let content: (ValidatorListState, @escaping ValidatorListDispatchFunction) -> V
    
    public var body: V {
        return content(store.state, store.dispatch)
    }
}
