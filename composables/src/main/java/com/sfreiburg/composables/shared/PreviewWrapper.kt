package com.sfreiburg.composables

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import com.sfreiburg.composables.theme.MovieTrackerTheme

@Composable
fun PreviewWrapper(
    content: @Composable () -> Unit
) {
    MovieTrackerTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            content()
        }
    }
}
