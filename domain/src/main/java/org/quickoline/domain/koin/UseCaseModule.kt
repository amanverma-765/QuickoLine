package org.quickoline.domain.koin

import org.koin.dsl.module
import org.quickoline.domain.usecase.DataStoreUseCases
import org.quickoline.domain.usecase.PublicPostDataUseCases
import org.quickoline.domain.usecase.datastore.GetFromDataStore
import org.quickoline.domain.usecase.datastore.SaveToDataStore
import org.quickoline.domain.usecase.post.GetFormFillingData
import org.quickoline.domain.usecase.post.GetLastMinuteData
import org.quickoline.domain.usecase.post.GetLegalServiceData
import org.quickoline.domain.usecase.post.GetTrendingData

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

    factory {
        PublicPostDataUseCases(
            getFormFillingData = GetFormFillingData(publicPostRepository = get()),
            getLegalServiceData = GetLegalServiceData(publicPostRepository = get()),
            getLastMinuteData = GetLastMinuteData(publicPostRepository = get()),
            getTrendingData = GetTrendingData(publicPostRepository = get())
        )
    }

}