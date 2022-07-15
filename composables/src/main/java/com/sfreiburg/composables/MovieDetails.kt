package com.sfreiburg.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.sfreiburg.models.Movie

@Composable
fun MovieDetails(
    movie: Movie?,
) {
    if (movie == null) {
        Text(stringResource(R.string.header_loading))
    } else {
        Column {
            AsyncImage(
                modifier = Modifier.fillMaxWidth(),
                model = ImageRequest.Builder(LocalContext.current).data(movie.backdrop_url)
                    .crossfade(true).build(),
                contentDescription = null,
                contentScale = ContentScale.Inside
            )

            Column(modifier = Modifier.padding(16.dp)) {
                Text(movie.title, fontSize = 24.sp)
                Spacer(modifier = Modifier.height(8.dp))
                Text(movie.overview, fontSize = 16.sp)
            }
        }
    }
}
