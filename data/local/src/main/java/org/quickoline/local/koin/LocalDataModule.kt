package org.quickoline.local.koin

import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import org.quickoline.local.datastore.BooleanDataStoreManager

val localDataModule = module {

    single { params ->
        BooleanDataStoreManager(
            context = androidContext(),
            preferenceName = params.get()
        )
    }

}