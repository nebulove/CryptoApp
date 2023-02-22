package com.demo.cryptoappnew.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.demo.cryptoappnew.data.repository.CoinRepositoryImpl
import com.demo.cryptoappnew.domain.GetCoinInfoListUseCase
import com.demo.cryptoappnew.domain.GetCoinInfoUseCase
import com.demo.cryptoappnew.domain.LoadDateUseCase

class CoinViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = CoinRepositoryImpl(application)

    private val getCoinInfoListUseCase = GetCoinInfoListUseCase(repository)
    private val getCoinInfoUseCase = GetCoinInfoUseCase(repository)
    private val loadDateUseCase = LoadDateUseCase(repository)

    val coinInfoList = getCoinInfoListUseCase

    fun getDetailInfo(fSym: String) = getCoinInfoUseCase(fSym)

    init {
        loadDateUseCase()
    }
}