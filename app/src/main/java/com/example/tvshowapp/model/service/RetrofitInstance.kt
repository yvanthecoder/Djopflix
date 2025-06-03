package com.example.tvshowapp.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val api: TvShowApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://www.episodate.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TvShowApi::class.java)
    }
}
