package com.mobileweb3.dvs.android.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.mobileweb3.dvs.android.screens.main.MainScreen
import com.mobileweb3.dvs.app.MainStore
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class AppScreen : Screen, KoinComponent {

    @Composable
    override fun Content() {
        val context = LocalContext.current
        val navigator = LocalNavigator.currentOrThrow

        val store: MainStore by inject()
        val state = store.observeState().collectAsState()

        LaunchedEffect(Unit) {
            // store.dispatch some event when launched
        }
        //swipe refresh if needed
//        SwipeRefresh(
//            state = rememberSwipeRefreshState(state.value.progress),
//            indicatorPadding = rememberInsetsPaddingValues(LocalWindowInsets.current.systemBars),
//            clipIndicatorToPadding = false,
//            indicator = { indicatorState, refreshTriggerDistance ->
//                SwipeRefreshIndicator(
//                    state = indicatorState,
//                    refreshTriggerDistance = refreshTriggerDistance,
//                    scale = true //https://github.com/google/accompanist/issues/572
//                )
//            },
//            onRefresh = {
//                //store.dispatch(Action.Refresh(true))
//            }
//        ) {
        MainScreen(
            store = store
        )

        //to route to another screen use navigator.push(AnotherScreen() : Screen)
    }
}