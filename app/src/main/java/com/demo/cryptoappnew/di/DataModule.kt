package com.demo.cryptoappnew.di

import android.app.Application
import com.demo.cryptoappnew.data.database.AppDatabase
import com.demo.cryptoappnew.data.database.CoinInfoDao
import com.demo.cryptoappnew.data.network.ApiFactory
import com.demo.cryptoappnew.data.network.ApiService
import com.demo.cryptoappnew.data.repository.CoinRepositoryImpl
import com.demo.cryptoappnew.domain.CoinRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @Binds
    @ApplicationScope
    fun bindCoinRepository(impl: CoinRepositoryImpl): CoinRepository

    companion object {

        @Provides
        @ApplicationScope
        fun provideCoinInfoDao(
            application: Application
        ): CoinInfoDao {
            return AppDatabase.getInstance(application).coinPriceInfoDao()
        }

        @Provides
        @ApplicationScope
        fun provideApiService(): ApiService{
            return ApiFactory.apiService
        }

    }
}