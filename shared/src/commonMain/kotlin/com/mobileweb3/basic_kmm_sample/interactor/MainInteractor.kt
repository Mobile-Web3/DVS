package com.mobileweb3.basic_kmm_sample.interactor

import com.mobileweb3.basic_kmm_sample.core.datasource.network.SomethingLoader
import com.mobileweb3.basic_kmm_sample.core.datasource.storage.SomethingStorage
import com.mobileweb3.basic_kmm_sample.core.entity.Something
import com.russhwolf.settings.Settings

class MainInteractor internal constructor(
    private val somethingLoader: SomethingLoader,
    private val somethingStorage: SomethingStorage,
){

    @Throws(Exception::class)
    suspend fun getAllSomething(
        forceUpdate: Boolean = false
    ): List<Something> {
        var somethings = somethingStorage.getAllSomething()

        if (forceUpdate || somethings.isEmpty()) {
            val new = somethingLoader.getSomething("url").data
            somethingStorage.saveSomething(new)
            somethings = new
        }

        return somethings
    }

    @Throws(Exception::class)
    suspend fun addSomething(url: String) {
        val something = somethingLoader.getSomething(url).data.firstOrNull()
        something?.let { somethingStorage.saveSomething(it) }
    }

    @Throws(Exception::class)
    suspend fun deleteSomething(id: String) {
        somethingStorage.deleteSomething(id)
    }

    companion object
}