package com.sfreiburg.screens

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.sfreiburg.composables.theme.MovieTrackerTheme

@Composable
fun AppThemeOverlayWrapper(content: @Composable () -> Unit) {
    MovieTrackerTheme {
        Surface(
            color = Color.Black.copy(alpha = 0.6f),
        ) {
            content()
        }
    }
}
