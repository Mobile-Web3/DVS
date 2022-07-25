import SwiftUI
import Foundation
import shared

@main
class iOSApp: App {
    let mainInteractor: MainInteractor
    let validatorListStore: ObservableValidatorListStore
    let validatorDetailsStore: ObservableValidatorDetailsStore
    let validatorVotesStore: ObservableValidatorVotesStore
    
    required init() {
        mainInteractor = MainInteractor.Companion().create(withLog: true)
        validatorListStore = ObservableValidatorListStore(validatorListStore: ValidatorListStore())
        validatorDetailsStore = ObservableValidatorDetailsStore(validatorDetailsStore: ValidatorDetailsStore())
        validatorVotesStore = ObservableValidatorVotesStore(validatorVotesStore: ValidatorVotesStore(interactor: mainInteractor))
    }
    
	var body: some Scene {
		WindowGroup {
            RootView(
                validatorDetailsStore: validatorDetailsStore,
                validatorVotesStore: validatorVotesStore
            )
            .environmentObject(validatorListStore)
            //.environmentObject(validatorDetailsStore)
		}
	}
}
