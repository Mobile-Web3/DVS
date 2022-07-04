package com.mobileweb3.dvs.app

import com.mobileweb3.dvs.core.wrap

fun MainStore.watchState() = observeState().wrap()
fun MainStore.watchSideEffect() = observeSideEffect().wrap()