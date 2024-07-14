package org.quickoline.data.koin

import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import org.quickoline.data.local.datastore.DataStoreManager

val localDatabaseModule = module {
    single { params ->
        DataStoreManager(
            context = androidContext(),
            preferenceName = params.get()
        )
    }

}