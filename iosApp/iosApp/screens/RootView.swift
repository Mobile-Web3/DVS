import SwiftUI
import shared

struct RootView: View {
    @EnvironmentObject var validatorListStore: ObservableValidatorListStore
    @EnvironmentObject var validatorDetailsStore: ObservableValidatorDetailsStore
    @SwiftUI.State var message: String?

	var body: some View {
        ZStack {
            NavigationView {
                ValidatorListView()
                    .environmentObject(validatorListStore)
                    .environmentObject(validatorDetailsStore)
                    .navigationBarTitle("")
                    .navigationBarHidden(true)
            }
            .zIndex(0)
        
            if let message = self.message {
                VStack {
                    Spacer()
                    Text(message)
                        .foregroundColor(.white)
                        .padding(10.0)
                        .background(Color.black)
                        .cornerRadius(3.0)
                }
                .padding(.bottom, 10)
                .zIndex(1)
                .transition(.asymmetric(insertion: .move(edge: .bottom), removal: .opacity) )
            }
        }
        .navigationViewStyle(StackNavigationViewStyle())
        .onReceive(validatorListStore.$sideEffect) { value in
            if let message = (value as? ValidatorListSideEffect.Message)?.text {
                withAnimation { self.message = message }
                DispatchQueue.main.asyncAfter(deadline: .now() + 2.0) {
                    withAnimation { self.message = nil }
                }
            }
        }
	}
}

struct RootView_Previews: PreviewProvider {
	static var previews: some View {
		RootView()
	}
}
