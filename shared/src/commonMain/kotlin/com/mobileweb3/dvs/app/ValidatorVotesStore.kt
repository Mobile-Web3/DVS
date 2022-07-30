package com.mobileweb3.dvs.app

import com.mobileweb3.dvs.core.entity.RequestStatus
import com.mobileweb3.dvs.core.entity.validator.ValidatorInfo
import com.mobileweb3.dvs.core.entity.validator.ValidatorModel
import com.mobileweb3.dvs.core.entity.validator.ValidatorNetwork
import com.mobileweb3.dvs.core.entity.validator.ValidatorVote
import com.mobileweb3.dvs.interactor.MainInteractor
import io.github.aakira.napier.Napier
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

data class ValidatorVotesState(
    val validatorModel: ValidatorModel?,
    val network: ValidatorNetwork?,
    val proposalsWrapper: RequestStatus<ValidatorVotesWrapper>,
    val validatorInfo: RequestStatus<ValidatorInfo>
) : State {

    fun getErrorMessage(): String {
        return "Loading proposals error.\nMaybe there are no proposals in ${network!!.blockchainNetwork.title}.\n" +
                "Report to developers or try later."
    }
}

data class ValidatorVotesWrapper(
    val proposals: List<ValidatorVote>,
)

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

    private val state = MutableStateFlow(
        ValidatorVotesState(
            validatorModel = null,
            network = null,
            proposalsWrapper = RequestStatus.Loading(),
            validatorInfo = RequestStatus.Loading()
        )
    )
    private val sideEffect = MutableSharedFlow<ValidatorVotesSideEffect>()

    override fun observeState(): StateFlow<ValidatorVotesState> = state

    override fun observeSideEffect(): Flow<ValidatorVotesSideEffect> = sideEffect

    override fun dispatch(action: ValidatorVotesAction) {
        Napier.d(tag = "ValidatorVotesStore", message = "Action: $action")

        val oldState = state.value

        val newState = when (action) {
            is ValidatorVotesAction.NetworkSelected -> {
                loadValidatorProfile(action.network)

                loadValidatorProposals(action.network)

                oldState.copy(
                    validatorModel = action.validatorModel,
                    network = action.network,
                    proposalsWrapper = RequestStatus.Loading(),
                    validatorInfo = RequestStatus.Loading()
                )
            }
        }

        if (newState != oldState) {
            Napier.d(tag = "MainStore", message = "NewState: $newState")
            state.value = newState
        }
    }

    private fun loadValidatorProfile(network: ValidatorNetwork) {
        launch(Dispatchers.Default) {
            try {
                val validatorInfo = interactor.getValidatorInfo(network)

                state.value = state.value.copy(
                    validatorInfo = RequestStatus.Data(validatorInfo)
                )
            } catch (ex: Exception) {
                state.value = state.value.copy(
                    validatorInfo = RequestStatus.Error(ex)
                )
            }
        }
    }

    private fun loadValidatorProposals(network: ValidatorNetwork) {
        launch(Dispatchers.Default) {
            try {
                val proposalList = interactor.getValidatorVotes(network, this)

                state.value = state.value.copy(
                    proposalsWrapper = RequestStatus.Data(ValidatorVotesWrapper(proposalList))
                )
            } catch (ex: Exception) {
                state.value = state.value.copy(
                    proposalsWrapper = RequestStatus.Error(ex)
                )
            }
        }
    }
}