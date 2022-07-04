package com.mobileweb3.basic_kmm_sample.app

import com.mobileweb3.basic_kmm_sample.core.wrap

fun MainStore.watchState() = observeState().wrap()
fun MainStore.watchSideEffect() = observeSideEffect().wrap()