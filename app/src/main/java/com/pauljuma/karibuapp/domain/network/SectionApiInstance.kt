package com.pauljuma.karibuapp.domain.network

import com.pauljuma.karibuapp.utils.Constants.Companion.BASE_URL2
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SectionApiInstance {
    companion object {
        private val retrofit by lazy {
            val logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)

            val client = OkHttpClient.Builder().addInterceptor(logging).build()
            Retrofit.Builder().baseUrl(BASE_URL2).addConverterFactory(GsonConverterFactory.create())
                .client(client).build()
        }

        val api by lazy{
            retrofit.create(SectionApi::class.java)
        }
    }
}