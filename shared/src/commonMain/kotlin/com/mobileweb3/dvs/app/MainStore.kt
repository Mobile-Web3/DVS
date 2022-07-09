package com.mobileweb3.dvs.app

import com.mobileweb3.dvs.core.datasource.validators.validators
import com.mobileweb3.dvs.core.entity.ValidatorModel
import io.github.aakira.napier.Napier
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

data class MainState(
    val validatorViewStates: List<ValidatorViewState>
) : State

sealed class MainAction : Action {
    object Click : MainAction()
}

sealed class MainSideEffect : Effect {
    data class Message(val text: String) : MainSideEffect()
}

class MainStore : Store<MainState, MainAction, MainSideEffect>, CoroutineScope by CoroutineScope(Dispatchers.Main) {

    private val state =
        MutableStateFlow(
            MainState(
                listOf(
                    ValidatorViewState(isLoading = true),
                    ValidatorViewState(isLoading = true),
                    ValidatorViewState(isLoading = true),
                    ValidatorViewState(isLoading = true),
                )
            )
        )
    private val sideEffect = MutableSharedFlow<MainSideEffect>()

    init {
        loadValidators()
    }

    override fun observeState(): StateFlow<MainState> = state

    override fun observeSideEffect(): Flow<MainSideEffect> = sideEffect

    override fun dispatch(action: MainAction) {
        Napier.d(tag = "MainStore", message = "Action: $action")

        val oldState = state.value

        val newState = oldState

        if (newState != oldState) {
            Napier.d(tag = "MainStore", message = "NewState: $newState")
            state.value = newState
        }
    }

    private fun loadValidators() {
        launch {
            delay(1000)

            state.value = MainState(
                validators.map { ValidatorViewState(isLoading = false, validatorModel = it) }
            )
        }
    }
}

data class ValidatorViewState(
    val isLoading: Boolean,
    val validatorModel: ValidatorModel? = null
)