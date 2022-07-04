package com.mobileweb3.basic_kmm_sample.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarHost
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.Navigator
import com.google.accompanist.insets.LocalWindowInsets
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.rememberInsetsPaddingValues
import com.mobileweb3.basic_kmm_sample.android.screens.AppScreen
import com.mobileweb3.basic_kmm_sample.android.ui.AppTheme
import com.mobileweb3.basic_kmm_sample.app.MainSideEffect
import com.mobileweb3.basic_kmm_sample.app.MainStore
import kotlinx.coroutines.flow.filterIsInstance
import org.koin.android.ext.android.inject

class AppActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AppTheme {
                ProvideWindowInsets {
                    val scaffoldState = rememberScaffoldState()

                    val store: MainStore by inject()
                    val message = store.observeSideEffect()
                        .filterIsInstance<MainSideEffect.Message>()
                        .collectAsState(MainSideEffect.Message("start message"))

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
                            Navigator(AppScreen())
                        }
                    }
                }
            }
        }
    }
}
