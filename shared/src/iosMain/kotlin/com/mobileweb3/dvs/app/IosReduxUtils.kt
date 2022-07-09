package com.mobileweb3.dvs.app

import com.mobileweb3.dvs.core.wrap

fun ValidatorListStore.watchState() = observeState().wrap()
fun ValidatorListStore.watchSideEffect() = observeSideEffect().wrap()