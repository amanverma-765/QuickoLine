package org.quickoline.domain.usecase

import org.quickoline.domain.usecase.datastore.GetFromDataStore
import org.quickoline.domain.usecase.datastore.SaveToDataStore

data class DataStoreUseCases(
    val getFromDataStore: GetFromDataStore,
    val saveToDataStore: SaveToDataStore
)
