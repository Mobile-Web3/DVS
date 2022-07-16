package com.mobileweb3.dvs.app

import com.mobileweb3.dvs.core.entity.validator.BlockchainNetwork
import io.github.aakira.napier.Napier
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

data class SearchNetworkState(
    val networks: List<BlockchainNetwork>,
    val selectedNetwork: BlockchainNetwork?
) : State

sealed class SearchNetworkAction : Action {
    data class SearchStringChanged(val searchString: String) : SearchNetworkAction()

    data class NetworkSelected(val network: BlockchainNetwork) : SearchNetworkAction()

    object NetworkSelectCanceled : SearchNetworkAction()
}

sealed class SearchNetworkSideEffect : Effect {
}

class SearchNetworkStore : Store<SearchNetworkState, SearchNetworkAction, SearchNetworkSideEffect>,
    CoroutineScope by CoroutineScope(Dispatchers.Main) {

    private val allNetworks = BlockchainNetwork.values().sortedBy { it.title }.toList()

    private val state = MutableStateFlow(SearchNetworkState(allNetworks, selectedNetwork = null))
    private val sideEffect = MutableSharedFlow<SearchNetworkSideEffect>()

    override fun observeState(): StateFlow<SearchNetworkState> = state

    override fun observeSideEffect(): Flow<SearchNetworkSideEffect> = sideEffect

    override fun dispatch(action: SearchNetworkAction) {
        Napier.d(tag = "SearchNetworkStore", message = "Action: $action")

        val oldState = state.value

        val newState = when (action) {
            is SearchNetworkAction.NetworkSelected -> {
                oldState.copy(
                    selectedNetwork = action.network
                )
            }
            is SearchNetworkAction.SearchStringChanged -> {
                oldState.copy(
                    networks = allNetworks.filter {
                        it.title.startsWith(action.searchString, true)
                    }
                )
            }
            is SearchNetworkAction.NetworkSelectCanceled -> {
                oldState.copy(
                    selectedNetwork = null
                )
            }
        }

        if (newState != oldState) {
            Napier.d(tag = "SearchNetworkStore", message = "NewState: $newState")
            state.value = newState
        }
    }
}