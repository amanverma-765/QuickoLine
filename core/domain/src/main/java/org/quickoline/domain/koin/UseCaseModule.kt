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
                preferencesDatabaseRepository = get(
                    parameters = { params }
                )
            ),
            getFromDataStore = GetFromDataStore(
                preferencesDatabaseRepository = get(
                    parameters = { params }
                )
            )
        )
    }

    factory {
        PublicPostDataUseCases(
            getFormFillingData = GetFormFillingData(postDataRepository = get()),
            getLegalServiceData = GetLegalServiceData(publicPostRepository = get()),
            getLastMinuteData = GetLastMinuteData(postDataRepository = get()),
            getTrendingData = GetTrendingData(postDataRepository = get())
        )
    }

}