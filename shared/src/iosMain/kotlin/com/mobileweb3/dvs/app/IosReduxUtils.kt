package com.mobileweb3.dvs.app

import com.mobileweb3.dvs.core.wrap

fun ValidatorListStore.watchState() = observeState().wrap()
fun ValidatorListStore.watchSideEffect() = observeSideEffect().wrap()

fun ValidatorDetailsStore.watchState() = observeState().wrap()
fun ValidatorDetailsStore.watchSideEffect() = observeSideEffect().wrap()

fun ValidatorVotesStore.watchState() = observeState().wrap()
fun ValidatorVotesStore.watchSideEffect() = observeSideEffect().wrap()

fun SearchNetworkStore.watchState() = observeState().wrap()
fun SearchNetworkStore.watchSideEffect() = observeSideEffect().wrap()