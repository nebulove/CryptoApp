package com.demo.cryptoappnew.data.network.model

import androidx.room.Entity


@Entity(tableName = "full_price_list")
data class CoinInfoDto(
    val fromSymbol: String,
    val toSymbol: String?,
    val price: String?,
    val lastUpdate: Long?,
    val highDay: String?,
    val lowDay: String?,
    val lastMarket: String?,
    val imageUrl: String?
)