package com.demo.cryptoappnew.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.demo.cryptoappnew.data.repository.CoinRepositoryImpl
import com.demo.cryptoappnew.domain.GetCoinInfoListUseCase
import com.demo.cryptoappnew.domain.GetCoinInfoUseCase
import com.demo.cryptoappnew.domain.LoadDateUseCase
import kotlinx.coroutines.launch

class CoinViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = CoinRepositoryImpl(application)

    private val getCoinInfoListUseCase = GetCoinInfoListUseCase(repository)
    private val getCoinInfoUseCase = GetCoinInfoUseCase(repository)
    private val loadDateUseCase = LoadDateUseCase(repository)

    val coinInfoList = getCoinInfoListUseCase

    fun getDetailInfo(fSym: String) = getCoinInfoUseCase(fSym)

    init {
        viewModelScope.launch {
            loadDateUseCase()
        }
    }
}