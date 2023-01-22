package com.fatih.eskael.retrofitClient

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClientInstance {
    companion object {

        private lateinit var retrofit: Retrofit
        private val baseUrl = "https://themealdb.com/api/json/v1/1/"
        val retrofitInstance: Retrofit
            get() {
                if (retrofit == null) {
                    retrofit = Retrofit.Builder()
                        .baseUrl(baseUrl)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                }
                return retrofit
            }
    }
}