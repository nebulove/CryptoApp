package com.demo.cryptoappnew.di

import android.app.Application
import com.demo.cryptoappnew.presentation.CoinApp
import com.demo.cryptoappnew.presentation.CoinDetailFragment
import com.demo.cryptoappnew.presentation.CoinPriceLIstActivity
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(
    modules = [
        DataModule::class,
        ViewModelModule::class
    ]
)
interface ApplicationComponent {

    fun inject(activity: CoinPriceLIstActivity)

    fun inject(fragment: CoinDetailFragment)

    fun inject(application: CoinApp)

    @dagger.Component.Factory
    interface Factory {

        fun create(
            @BindsInstance application: Application
        ): ApplicationComponent
    }
}