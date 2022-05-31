package com.example.ExchangeRate.repository

import retrofit2.http.GET

interface QiwiService {
    @GET
    fun getValue(): List<Any>
}