package com.sfreiburg.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.sfreiburg.composables.theme.MovieTrackerTheme

@Composable
fun AppThemeFullScreenWrapper(content: @Composable () -> Unit) {
    MovieTrackerTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            content()
        }
    }
}
