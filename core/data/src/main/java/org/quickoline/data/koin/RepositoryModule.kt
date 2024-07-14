package org.quickoline.data.koin

import org.koin.dsl.module
import org.quickoline.data.repository.DataStoreRepositoryImpl
import org.quickoline.domain.repository.PreferencesDatabaseRepository
import org.quickoline.domain.repository.PostDataRepository
import org.quickoline.data.repository.PostDataRepositoryImpl

val repositoryModule = module {

    single<PreferencesDatabaseRepository> { params ->
        DataStoreRepositoryImpl(
            datastoreManager = get( parameters = { params } )
        )
    }

    single<PostDataRepository> { PostDataRepositoryImpl(supabasePublicDataSource = get()) }
}