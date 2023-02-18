package com.demo.cryptoappnew.domain

import androidx.lifecycle.LiveData

interface CoinRepository {

    fun getCoinIfoList(): LiveData<List<CoinInfo>>

    fun getCoinInfo(fromSymbol: String): LiveData<CoinInfo>
}