package org.quickoline.domain.koin

import org.koin.dsl.module
import org.quickoline.domain.usecase.DataStoreUseCases
import org.quickoline.domain.usecase.datastore.GetFromDataStore
import org.quickoline.domain.usecase.datastore.SaveToDataStore

val useCaseModule = module {

    factory { params ->
        DataStoreUseCases(
            saveToDataStore = SaveToDataStore(
                dataStoreRepository = get(
                    parameters = { params }
                )
            ),
            getFromDataStore = GetFromDataStore(
                dataStoreRepository = get(
                    parameters = { params }
                )
            )
        )
    }
}