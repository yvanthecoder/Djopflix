package com.example.tvshowapp.view
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.example.tvshowapp.viewmodel.TvShowViewModel

import kotlinx.coroutines.flow.collectLatest

@Composable
fun TvShowListScreen(viewModel: TvShowViewModel = viewModel()) {

    val tvShows = viewModel.tvShows.collectAsState()

    // Charger les données une seule fois
    LaunchedEffect(Unit) {
        viewModel.loadTvShows()
    }

    if (tvShows.value.isEmpty()) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    } else {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.padding(8.dp),
            contentPadding = PaddingValues(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(tvShows.value) { show ->
                Card(modifier = Modifier.fillMaxWidth()) {
                    Column(modifier = Modifier.padding(8.dp)) {
                        Image(
                            painter = rememberAsyncImagePainter(show.imageThumbnailPath),
                            contentDescription = show.name,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(160.dp)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(show.name, style = MaterialTheme.typography.titleMedium)
                    }
                }
            }
        }
    }
}
