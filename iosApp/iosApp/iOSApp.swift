import SwiftUI
import Foundation
import shared

@main
class iOSApp: App {
    let mainInteractor: MainInteractor
    let validatorListStore: ObservableValidatorListStore
    
    required init() {
        mainInteractor = MainInteractor.Companion().create(withLog: true)
        validatorListStore = ObservableValidatorListStore(validatorListStore: ValidatorListStore())
    }
    
	var body: some Scene {
		WindowGroup {
            RootView().environmentObject(validatorListStore)
		}
	}
}

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

public typealias DispatchFunction = (ValidatorListAction) -> ()

public protocol ConnectedView: View {
    associatedtype Props
    associatedtype V: View
    
    func map(state: ValidatorListState, dispatch: @escaping DispatchFunction) -> Props
    func body(props: Props) -> V
}

public extension ConnectedView {
    func render(state: ValidatorListState, dispatch: @escaping DispatchFunction) -> V {
        let props = map(state: state, dispatch: dispatch)
        return body(props: props)
    }
    
    var body: StoreConnector<V> {
        return StoreConnector(content: render)
    }
}

public struct StoreConnector<V: View>: View {
    @EnvironmentObject var store: ObservableValidatorListStore
    let content: (ValidatorListState, @escaping DispatchFunction) -> V
    
    public var body: V {
        return content(store.state, store.dispatch)
    }
}
