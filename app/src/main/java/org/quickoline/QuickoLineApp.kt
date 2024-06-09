package org.quickoline

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.quickoline.dashboard.koin.dashboardModule
import org.quickoline.domain.koin.useCaseModule
import org.quickoline.remote.koin.supabaseModule
import org.quickoline.local.koin.localDataModule
import org.quickoline.onboarding.koin.onBoardingModule
import org.quickoline.repository.koin.repositoryModule

class QuickoLineApp: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@QuickoLineApp)
            androidLogger()
            modules(
                onBoardingModule,
                dashboardModule,
                localDataModule,
                repositoryModule,
                useCaseModule,
                supabaseModule
            )
        }
    }
}