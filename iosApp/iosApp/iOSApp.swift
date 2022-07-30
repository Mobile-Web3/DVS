import SwiftUI
import Foundation
import shared

@main
class iOSApp: App {
    let mainInteractor: MainInteractor
    let validatorListStore: ObservableValidatorListStore
    let validatorDetailsStore: ObservableValidatorDetailsStore
    let validatorVotesStore: ObservableValidatorVotesStore
    let searchNetworkStore: ObservableSearchNetworkStore
    
    required init() {
        mainInteractor = MainInteractor.Companion().create(withLog: true)
        validatorListStore = ObservableValidatorListStore(validatorListStore: ValidatorListStore())
        validatorDetailsStore = ObservableValidatorDetailsStore(validatorDetailsStore: ValidatorDetailsStore())
        validatorVotesStore = ObservableValidatorVotesStore(validatorVotesStore: ValidatorVotesStore(interactor: mainInteractor))
        searchNetworkStore = ObservableSearchNetworkStore(searchNetworkStore: SearchNetworkStore())
    }
    
	var body: some Scene {
		WindowGroup {
            RootView(
                validatorDetailsStore: validatorDetailsStore,
                validatorVotesStore: validatorVotesStore,
                searchNetworkStore: searchNetworkStore
            )
            .environmentObject(validatorListStore)
            //.environmentObject(validatorDetailsStore)
		}
	}
}
