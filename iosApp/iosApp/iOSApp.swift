import SwiftUI
import Foundation
import shared

@main
class iOSApp: App {
    let mainInteractor: MainInteractor
    let store: ObservableMainStore
    
    required init() {
        mainInteractor = MainInteractor.Companion().create(withLog: true)
        store = ObservableMainStore(store: MainStore())
    }
    
	var body: some Scene {
		WindowGroup {
            RootView().environmentObject(store)
		}
	}
}

class ObservableMainStore: ObservableObject {
    @Published public var state: MainState =  MainState(count: 0)
    @Published public var sideEffect: MainSideEffect?
    
    let store: MainStore
    
    var stateWatcher : Closeable?
    var sideEffectWatcher : Closeable?

    init(store: MainStore) {
        self.store = store
        stateWatcher = self.store.watchState().watch { [weak self] state in
            self?.state = state
        }
        sideEffectWatcher = self.store.watchSideEffect().watch { [weak self] state in
            self?.sideEffect = state
        }
    }
    
    public func dispatch(_ action: MainAction) {
        store.dispatch(action: action)
    }
    
    deinit {
        stateWatcher?.close()
        sideEffectWatcher?.close()
    }
}

public typealias DispatchFunction = (MainAction) -> ()

public protocol ConnectedView: View {
    associatedtype Props
    associatedtype V: View
    
    func map(state: MainState, dispatch: @escaping DispatchFunction) -> Props
    func body(props: Props) -> V
}

public extension ConnectedView {
    func render(state: MainState, dispatch: @escaping DispatchFunction) -> V {
        let props = map(state: state, dispatch: dispatch)
        return body(props: props)
    }
    
    var body: StoreConnector<V> {
        return StoreConnector(content: render)
    }
}

public struct StoreConnector<V: View>: View {
    @EnvironmentObject var store: ObservableMainStore
    let content: (MainState, @escaping DispatchFunction) -> V
    
    public var body: V {
        return content(store.state, store.dispatch)
    }
}
