package com.example.tvshowapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.tvshowapp.ui.theme.TvShowAppTheme
import com.example.tvshowapp.view.TvShowListScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TvShowAppTheme {
                TvShowListScreen()
            }
        }
    }
}
