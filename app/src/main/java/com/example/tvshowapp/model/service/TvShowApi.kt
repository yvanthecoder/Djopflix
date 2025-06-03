package com.example.tvshowapp.service

import com.example.tvshowapp.model.data.TvShowResponseItem
import retrofit2.http.GET
import retrofit2.http.Query

interface TvShowApi {
    @GET("most-popular")
    suspend fun getPopularShows(@Query("page") page: Int = 1): TvShowResponseItem
}
