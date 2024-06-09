package org.quickoline.repository.koin

import org.koin.dsl.module
import org.quickoline.domain.repository.DataStoreRepository
import org.quickoline.domain.repository.PublicPostRepository
import org.quickoline.repository.datastore.DataStoreRepositoryImpl
import org.quickoline.repository.supabase.PublicPostRepositoryImpl

val repositoryModule = module {

    single<DataStoreRepository> { params ->
        DataStoreRepositoryImpl(
            booleanDatastoreManager = get( parameters = { params } )
        )
    }

    single<PublicPostRepository> { PublicPostRepositoryImpl(supabasePublicDataSource = get()) }
}