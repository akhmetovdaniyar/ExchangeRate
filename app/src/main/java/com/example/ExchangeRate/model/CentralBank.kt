package com.example.ExchangeRate.model

data class CentralBank(
    val base: String,
    val date: String,
    val disclaimer: String,
    val rates: Rates,
    val timestamp: Int
)