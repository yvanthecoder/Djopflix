package com.example.tvshowapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tvshowapp.model.data.TvShow
import com.example.tvshowapp.repository.TvShowRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TvShowViewModel : ViewModel() {

    private val repository = TvShowRepository(com.example.tvshowapp.service.RetrofitInstance.api)

    private val _tvShows = MutableStateFlow<List<TvShow>>(emptyList())
    val tvShows: StateFlow<List<TvShow>> = _tvShows

    fun loadTvShows() {
        viewModelScope.launch {
            val result = repository.getTvShows()
            _tvShows.value = result
        }
    }
}
