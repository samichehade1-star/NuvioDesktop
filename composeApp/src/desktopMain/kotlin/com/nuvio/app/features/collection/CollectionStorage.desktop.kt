package com.nuvio.app.features.collection

import com.nuvio.app.core.storage.DesktopStorage
import com.nuvio.app.core.storage.ProfileScopedKey

internal actual object CollectionStorage {
    private val store = DesktopStorage.store("nuvio_collections")

    actual fun loadPayload(): String? =
        store.getString(ProfileScopedKey.of("collections"))

    actual fun savePayload(payload: String) {
        store.putString(ProfileScopedKey.of("collections"), payload)
    }

    actual fun hasSeededDefaultNetworks(): Boolean =
        store.getBoolean(ProfileScopedKey.of("default_networks_seeded")) ?: false

    actual fun markDefaultNetworksSeeded() {
        store.putBoolean(ProfileScopedKey.of("default_networks_seeded"), true)
    }
}
