package com.example.ExchangeRate.repository

import com.example.ExchangeRate.model.Qiwi

object Common {
    private val BASE_URL = "https://edge.qiwi.com/sinap/crossRates"
    val retrofitInstance: Qiwi
        get() = RetrofitInstance.getBase(BASE_URL).create(Qiwi::class.java)
}