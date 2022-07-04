package com.mobileweb3.dvs.core.datasource.storage

import com.mobileweb3.dvs.core.entity.Something
import com.russhwolf.settings.Settings
import com.russhwolf.settings.set
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.json.Json

class SomethingStorage(
    private val settings: Settings,
    private val json: Json
) {

    private var diskCache: Map<String, Something>
        get() {
            return settings.getStringOrNull(KEY_SOMETHING_CACHE)?.let { str ->
                json.decodeFromString(ListSerializer(Something.serializer()), str)
                    .associate { it.id to it }
            } ?: mutableMapOf()
        }
        set(value) {
            val list = value.map { it.value }
            settings[KEY_SOMETHING_CACHE] =
                json.encodeToString(ListSerializer(Something.serializer()), list)
        }

    private val memCache: MutableMap<String, Something> by lazy { diskCache.toMutableMap() }

    suspend fun getSomething(id: String): Something? = memCache[id]

    suspend fun saveSomething(something: Something) {
        memCache[something.id] = something
        diskCache = memCache
    }

    suspend fun saveSomething(somethings: List<Something>) {
        somethings.forEach {
            memCache[it.id] = it
        }

        diskCache = memCache
    }

    suspend fun deleteSomething(id: String) {
        memCache.remove(id)
        diskCache = memCache
    }

    suspend fun getAllSomething(): List<Something> = memCache.values.toList()

    private companion object {
        private const val KEY_SOMETHING_CACHE = "key_something_cache"
    }
}