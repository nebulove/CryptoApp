package com.demo.cryptoappnew.presentation

import android.app.Application
import androidx.work.Configuration
import com.demo.cryptoappnew.data.workers.RefreshDataWorkerFactory
import com.demo.cryptoappnew.di.DaggerApplicationComponent
import javax.inject.Inject

class CoinApp : Application(), Configuration.Provider {

    @Inject
    lateinit var workerFactory: RefreshDataWorkerFactory

    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }

    override fun onCreate() {
        component.inject(this)
        super.onCreate()
    }

    override fun getWorkManagerConfiguration(): Configuration {
        return Configuration.Builder()
            .setWorkerFactory(workerFactory)
            .build()
    }
}