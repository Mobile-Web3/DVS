package com.mobileweb3.dvs.app

import com.mobileweb3.dvs.core.entity.ValidatorModel
import io.github.aakira.napier.Napier
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

data class ValidatorDetailsState(
    val validatorModel: ValidatorModel?
) : State

sealed class ValidatorDetailsAction : Action {

}

sealed class ValidatorDetailsSideEffect : Effect {
    data class Message(val text: String) : ValidatorDetailsSideEffect()
}

class ValidatorDetailsStore : Store<ValidatorDetailsState, ValidatorDetailsAction, ValidatorDetailsSideEffect>,
    CoroutineScope by CoroutineScope(Dispatchers.Main) {

    private val state =
        MutableStateFlow(
            ValidatorDetailsState(
                null
            )
        )
    private val sideEffect = MutableSharedFlow<ValidatorDetailsSideEffect>()

    override fun observeState(): StateFlow<ValidatorDetailsState> = state

    override fun observeSideEffect(): Flow<ValidatorDetailsSideEffect> = sideEffect

    override fun dispatch(action: ValidatorDetailsAction) {
        Napier.d(tag = "MainStore", message = "Action: $action")

        val oldState = state.value

        val newState = oldState

        if (newState != oldState) {
            Napier.d(tag = "MainStore", message = "NewState: $newState")
            state.value = newState
        }
    }
}