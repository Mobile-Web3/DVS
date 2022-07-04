package com.mobileweb3.dvs.core

import android.content.Context
import com.mobileweb3.dvs.core.datasource.network.SomethingLoader
import com.mobileweb3.dvs.core.datasource.storage.SomethingStorage
import com.mobileweb3.dvs.interactor.MainInteractor
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