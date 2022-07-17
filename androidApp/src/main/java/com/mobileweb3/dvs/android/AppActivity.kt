package com.mobileweb3.dvs.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarHost
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.view.WindowCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.insets.LocalWindowInsets
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.rememberInsetsPaddingValues
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.mobileweb3.dvs.android.screens.detail.ValidatorDetailsContent
import com.mobileweb3.dvs.android.screens.main.ValidatorsListContent
import com.mobileweb3.dvs.android.screens.search.SearchValidatorContent
import com.mobileweb3.dvs.android.screens.voting.ValidatorVotesContent
import com.mobileweb3.dvs.android.ui.AppTheme
import com.mobileweb3.dvs.app.SearchNetworkStore
import com.mobileweb3.dvs.app.ValidatorDetailsStore
import com.mobileweb3.dvs.app.ValidatorListSideEffect
import com.mobileweb3.dvs.app.ValidatorListStore
import com.mobileweb3.dvs.app.ValidatorVotesStore
import kotlinx.coroutines.flow.filterIsInstance
import org.koin.android.ext.android.inject

class AppActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        actionBar?.hide()

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            val systemUiController = rememberSystemUiController()
            val useDarkIcons = !MaterialTheme.colors.isLight
            SideEffect {
                systemUiController.setSystemBarsColor(Color.Transparent, darkIcons = useDarkIcons)
            }

            AppTheme {
                ProvideWindowInsets {
                    val scaffoldState = rememberScaffoldState()

                    val validatorListStore: ValidatorListStore by inject()
                    val validatorDetailsStore: ValidatorDetailsStore by inject()
                    val validatorVotesStore: ValidatorVotesStore by inject()
                    val searchNetworkStore: SearchNetworkStore by inject()

                    val message = validatorListStore.observeSideEffect()
                        .filterIsInstance<ValidatorListSideEffect.Message>()
                        .collectAsState(null)

                    LaunchedEffect(message.value) {
                        message.value?.let {
                            scaffoldState.snackbarHostState.showSnackbar(
                                it.text
                            )
                        }
                    }

                    Box(
                        Modifier.padding(
                            rememberInsetsPaddingValues(
                                insets = LocalWindowInsets.current.systemBars,
                                applyStart = true,
                                applyTop = false,
                                applyEnd = true,
                                applyBottom = false
                            )
                        )
                    ) {
                        Scaffold(
                            scaffoldState = scaffoldState,
                            snackbarHost = { hostState ->
                                SnackbarHost(
                                    hostState = hostState,
                                    modifier = Modifier.padding(
                                        rememberInsetsPaddingValues(
                                            insets = LocalWindowInsets.current.systemBars,
                                            applyBottom = true
                                        )
                                    )
                                )
                            }
                        ) {
                            val navController = rememberNavController()

                            NavHost(navController = navController, startDestination = "list") {
                                composable("list") {
                                    ValidatorsListContent(
                                        validatorListStore,
                                        validatorDetailsStore,
                                        navController
                                    )
                                }
                                composable("details") {
                                    ValidatorDetailsContent(
                                        validatorDetailsStore,
                                        validatorVotesStore,
                                        navController
                                    )
                                }
                                composable("voting") {
                                    ValidatorVotesContent(
                                        validatorVotesStore,
                                        navController
                                    )
                                }
                                composable("search") {
                                    SearchValidatorContent(
                                        searchNetworkStore,
                                        validatorDetailsStore,
                                        navController
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
