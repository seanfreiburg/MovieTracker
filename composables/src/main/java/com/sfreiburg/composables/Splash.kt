package com.sfreiburg.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Splash(
) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
    ) {}

}

@Preview
@Composable
fun SplashPreview() {
    PreviewWrapper {
        Splash()
    }
}