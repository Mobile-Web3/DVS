//
//  ObservableValidatorDetailsStore.swift
//  DVS
//
//  Created by Dmitrii Kuzmin on 22.07.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import Foundation
import shared

class ObservableValidatorDetailsStore: ObservableObject {
    @Published public var state: ValidatorDetailsState = ValidatorDetailsState(validatorModel: nil, selectedTopicIndex: 0)
//    @Published public var sideEffect: ValidatorDetailsSideEffect?
    
    let store: ValidatorDetailsStore
    
    var stateWatcher : Closeable?
//    var sideEffectWatcher : Closeable?

    init(validatorDetailsStore: ValidatorDetailsStore) {
        self.store = validatorDetailsStore
        stateWatcher = self.store.watchState().watch { [weak self] state in
            self?.state = state
        }
//        sideEffectWatcher = self.store.watchSideEffect().watch { [weak self] state in
//            self?.sideEffect = state
//        }
    }
    
    public func dispatch(_ action: ValidatorDetailsAction) {
        store.dispatch(action: action)
    }
    
    deinit {
        stateWatcher?.close()
//        sideEffectWatcher?.close()
    }
}

public typealias ValidatorDetailsDispatchFunction = (ValidatorDetailsAction) -> ()

public protocol ValidatorDetailsConnectedView: View {
    associatedtype Props
    associatedtype V: View
    
    func map(state: ValidatorDetailsState, dispatch: @escaping ValidatorDetailsDispatchFunction) -> Props
    func body(props: Props) -> V
}

public extension ValidatorDetailsConnectedView {
    func render(state: ValidatorDetailsState, dispatch: @escaping ValidatorDetailsDispatchFunction) -> V {
        let props = map(state: state, dispatch: dispatch)
        return body(props: props)
    }
    
    var body: ValidatorDetailsStoreConnector<V> {
        return ValidatorDetailsStoreConnector(content: render)
    }
}

public struct ValidatorDetailsStoreConnector<V: View>: View {
    @EnvironmentObject var store: ObservableValidatorDetailsStore
    let content: (ValidatorDetailsState, @escaping ValidatorDetailsDispatchFunction) -> V
    
    public var body: V {
        return content(store.state, store.dispatch)
    }
}
