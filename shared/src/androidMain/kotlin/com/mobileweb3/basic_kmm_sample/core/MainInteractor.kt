package com.mobileweb3.basic_kmm_sample.core

import android.content.Context
import com.mobileweb3.basic_kmm_sample.core.datasource.network.SomethingLoader
import com.mobileweb3.basic_kmm_sample.core.datasource.storage.SomethingStorage
import com.mobileweb3.basic_kmm_sample.interactor.MainInteractor
import com.russhwolf.settings.AndroidSettings
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import kotlinx.serialization.json.Json

fun MainInteractor.Companion.create(ctx: Context, withLog: Boolean) = MainInteractor(
    SomethingLoader(
        AndroidHttpClient(withLog)
    ),
    SomethingStorage(
        AndroidSettings(ctx.getSharedPreferences("preferences_title", Context.MODE_PRIVATE)),
        Json {
            ignoreUnknownKeys = true
            isLenient = true
            encodeDefaults = false
        }
    )
).also {
    if (withLog) Napier.base(DebugAntilog())
}