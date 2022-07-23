import SwiftUI
import Foundation
import shared

@main
class iOSApp: App {
    let mainInteractor: MainInteractor
    let validatorListStore: ObservableValidatorListStore
    let validatorDetailsStore: ObservableValidatorDetailsStore
    
    required init() {
        mainInteractor = MainInteractor.Companion().create(withLog: true)
        validatorListStore = ObservableValidatorListStore(validatorListStore: ValidatorListStore())
        validatorDetailsStore = ObservableValidatorDetailsStore(validatorDetailsStore: ValidatorDetailsStore())
    }
    
	var body: some Scene {
		WindowGroup {
            RootView()
                .environmentObject(validatorListStore)
                .environmentObject(validatorDetailsStore)
		}
	}
}
