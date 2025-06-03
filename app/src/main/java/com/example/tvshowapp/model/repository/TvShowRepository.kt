package com.example.tvshowapp.repository

import com.example.tvshowapp.model.data.TvShow
import com.example.tvshowapp.service.TvShowApi

class TvShowRepository(private val api: TvShowApi) {
    suspend fun getTvShows(page: Int = 1): List<TvShow> {
        return api.getPopularShows(page).tvShows
    }
}
