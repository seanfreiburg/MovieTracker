package com.sfreiburg.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.airbnb.mvrx.Async
import com.airbnb.mvrx.Fail
import com.airbnb.mvrx.Loading
import com.airbnb.mvrx.Success
import com.airbnb.mvrx.Uninitialized
import com.sfreiburg.composables.shared.ErrorMessage
import com.sfreiburg.composables.shared.LoadingFullScreen
import com.sfreiburg.models.Movie

@Composable
fun Movies(
    movies: Async<List<Movie>>,
    query: String,
    onQueryChanged: (String) -> Unit,
    onMovieClicked: (Int) -> Unit,
) {

    Column {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = query,
                singleLine = true,
                trailingIcon = {
                    IconButton(onClick = { onQueryChanged("") }) {
                        Icon(
                            imageVector = Icons.Filled.Clear,
                            contentDescription = stringResource(R.string.contentDescription_clear)
                        )
                    }
                },
                placeholder = { Text(stringResource(R.string.placeholder_search)) },
                onValueChange = {
                    onQueryChanged(it)
                }
            )
        }

        when (movies) {
            is Loading, Uninitialized -> LoadingFullScreen()
            is Success -> LazyVerticalGrid(
                modifier = Modifier.fillMaxHeight(), columns = GridCells.Fixed(3)
            ) {
                items(items = movies.invoke(), itemContent = { item ->
                    AsyncImage(
                        modifier = Modifier.clickable { onMovieClicked(item.id) },
                        model = ImageRequest.Builder(LocalContext.current).data(item.poster_url)
                            .crossfade(true).build(),
                        contentDescription = null
                    )
                })
            }
            is Fail -> ErrorMessage(
                message = movies.error.message.toString(),
                stackTrace = movies.error.stackTraceToString()
            )
        }
    }
}
