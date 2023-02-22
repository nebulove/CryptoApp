package com.demo.cryptoappnew.domain

class LoadDateUseCase(
    private val repository: CoinRepository
) {

    operator fun invoke() = repository.loadData()
}