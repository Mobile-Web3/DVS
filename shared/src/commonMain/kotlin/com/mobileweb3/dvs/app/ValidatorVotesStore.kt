package com.mobileweb3.dvs.app

import com.mobileweb3.dvs.core.entity.validator.ValidatorModel
import com.mobileweb3.dvs.core.entity.validator.ValidatorNetwork
import com.mobileweb3.dvs.interactor.MainInteractor
import io.github.aakira.napier.Napier
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

data class ValidatorVotesState(
    val validatorModel: ValidatorModel?,
    val network: ValidatorNetwork?
) : State

sealed class ValidatorVotesAction : Action {
    data class NetworkSelected(
        val validatorModel: ValidatorModel?,
        val network: ValidatorNetwork
    ) : ValidatorVotesAction()
}

sealed class ValidatorVotesSideEffect : Effect {
}

class ValidatorVotesStore(
    val interactor: MainInteractor
) : Store<ValidatorVotesState, ValidatorVotesAction, ValidatorVotesSideEffect>,
    CoroutineScope by CoroutineScope(Dispatchers.Main) {

    private val state = MutableStateFlow(ValidatorVotesState(null, null))
    private val sideEffect = MutableSharedFlow<ValidatorVotesSideEffect>()

    override fun observeState(): StateFlow<ValidatorVotesState> = state

    override fun observeSideEffect(): Flow<ValidatorVotesSideEffect> = sideEffect

    override fun dispatch(action: ValidatorVotesAction) {
        Napier.d(tag = "MainStore", message = "Action: $action")

        val oldState = state.value

        val newState = when (action) {
            is ValidatorVotesAction.NetworkSelected -> {
                ValidatorVotesState(action.validatorModel, action.network)
            }
        }

        if (newState != oldState) {
            Napier.d(tag = "MainStore", message = "NewState: $newState")
            state.value = newState
        }
    }

    private fun loadValidatorProposals() {

    }
}