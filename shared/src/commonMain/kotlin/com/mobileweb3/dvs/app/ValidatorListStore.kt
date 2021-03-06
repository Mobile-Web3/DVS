package com.mobileweb3.dvs.app

import com.mobileweb3.dvs.core.datasource.validators.validators
import com.mobileweb3.dvs.core.entity.validator.ValidatorModel
import com.mobileweb3.dvs.interactor.MainInteractor
import io.github.aakira.napier.Napier
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

data class ValidatorListState(
    val validatorViewStates: List<ValidatorViewState>
) : State

sealed class ValidatorListAction : Action {
    object ValidatorCardSelect : ValidatorListAction()
}

sealed class ValidatorListSideEffect : Effect {
    data class Message(val text: String) : ValidatorListSideEffect()
}

class ValidatorListStore : Store<ValidatorListState, ValidatorListAction, ValidatorListSideEffect>,
    CoroutineScope by CoroutineScope(Dispatchers.Main) {

    private val state =
        MutableStateFlow(
            ValidatorListState(
                listOf(
                    ValidatorViewState(isLoading = true),
                    ValidatorViewState(isLoading = true),
                )
            )
        )
    private val sideEffect = MutableSharedFlow<ValidatorListSideEffect>()

    init {
        loadValidators()
    }

    override fun observeState(): StateFlow<ValidatorListState> = state

    override fun observeSideEffect(): Flow<ValidatorListSideEffect> = sideEffect

    override fun dispatch(action: ValidatorListAction) {
        Napier.d(tag = "ValidatorListStore", message = "Action: $action")

        val oldState = state.value

        when (action) {
            ValidatorListAction.ValidatorCardSelect -> {

            }
        }

        val newState = oldState

        if (newState != oldState) {
            Napier.d(tag = "ValidatorListStore", message = "NewState: $newState")
            state.value = newState
        }
    }

    private fun loadValidators() {
        launch {
            delay(1000)

            state.value = ValidatorListState(
                validators.map { ValidatorViewState(isLoading = false, validatorModel = it) }
            )
        }
    }
}

data class ValidatorViewState(
    val isLoading: Boolean,
    val validatorModel: ValidatorModel? = null
)