package com.demo.cryptoappnew.presentation

import androidx.lifecycle.ViewModel
import com.demo.cryptoappnew.domain.GetCoinInfoListUseCase
import com.demo.cryptoappnew.domain.GetCoinInfoUseCase
import com.demo.cryptoappnew.domain.LoadDateUseCase
import javax.inject.Inject

class CoinViewModel @Inject constructor(
    private val getCoinInfoListUseCase: GetCoinInfoListUseCase,
    private val getCoinInfoUseCase: GetCoinInfoUseCase,
    private val loadDateUseCase: LoadDateUseCase
) : ViewModel() {

    val coinInfoList = getCoinInfoListUseCase

    fun getDetailInfo(fSym: String) = getCoinInfoUseCase(fSym)

    init {
        loadDateUseCase()
    }
}