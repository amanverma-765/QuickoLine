package org.quickoline

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.quickoline.onboarding.koin.onBoardingModule

class QuickoLineApp: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@QuickoLineApp)
            androidLogger()
            modules(
                onBoardingModule,
            )
        }
    }
}