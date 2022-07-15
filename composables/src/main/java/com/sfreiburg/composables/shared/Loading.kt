package com.sfreiburg.composables.shared

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.sfreiburg.composables.PreviewWrapper

@Composable
fun LoadingFullScreen(
    modifier: Modifier = Modifier,
) {
    Loading(modifier = Modifier.fillMaxSize())
}

@Preview
@Composable
fun LoadingFullScreenPreview() {
    PreviewWrapper { LoadingFullScreen() }
}

@Composable
fun Loading(
    modifier: Modifier = Modifier,
) {
    Box(modifier = modifier) {
        CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
    }
}

@Preview
@Composable
fun LoadingPreview() {
    PreviewWrapper { Loading() }
}
