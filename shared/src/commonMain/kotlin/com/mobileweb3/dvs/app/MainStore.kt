package com.mobileweb3.dvs.app

import io.github.aakira.napier.Napier
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

data class MainState(
    val count: Int
) : State

sealed class MainAction : Action {
    object Click : MainAction()
}

sealed class MainSideEffect : Effect {
    data class Message(val text: String) : MainSideEffect()
}

class MainStore : Store<MainState, MainAction, MainSideEffect>, CoroutineScope by CoroutineScope(Dispatchers.Main) {

    private val state = MutableStateFlow(MainState(0))
    private val sideEffect = MutableSharedFlow<MainSideEffect>()

    override fun observeState(): StateFlow<MainState> = state

    override fun observeSideEffect(): Flow<MainSideEffect> = sideEffect

    override fun dispatch(action: MainAction) {
        Napier.d(tag = "MainStore", message = "Action: $action")

        val oldState = state.value

        val newState = when (action) {
            MainAction.Click -> {
                val newCount = oldState.count + 1
                if (newCount % 2 == 0) {
                    launch { sideEffect.emit(MainSideEffect.Message("value can be divided by 2: $newCount")) }
                }
                oldState.copy(count = newCount)
            }
        }

        if (newState != oldState) {
            Napier.d(tag = "MainStore", message = "NewState: $newState")
            state.value = newState
        }
    }
}