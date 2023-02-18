package com.demo.cryptoappnew.domain

class GetCoinInfoListUseCase(private val repository: CoinRepository) {

    operator fun invoke() = repository.getCoinIfoList()

}