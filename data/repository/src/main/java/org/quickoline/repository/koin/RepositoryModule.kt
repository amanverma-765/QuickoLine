package org.quickoline.repository.koin

import org.koin.dsl.module
import org.quickoline.domain.repository.DataStoreRepository
import org.quickoline.repository.datastore.DataStoreRepositoryImpl

val repositoryModule = module {

    single<DataStoreRepository> { params ->
        DataStoreRepositoryImpl(
            booleanDatastoreManager = get( parameters = { params } )
        )
    }
}