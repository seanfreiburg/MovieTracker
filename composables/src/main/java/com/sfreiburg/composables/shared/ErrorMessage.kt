package com.sfreiburg.composables.shared

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sfreiburg.composables.PreviewWrapper
import com.sfreiburg.composables.R

@Composable
fun ErrorMessage(
    modifier: Modifier = Modifier,
    message: String,
    stackTrace: String,
) {
    Box(
        modifier = modifier.fillMaxSize(),
    ) {
        Surface(
            modifier = modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.error
        ) {
            Column(
                modifier = Modifier
                    .padding(24.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                Text(stringResource(R.string.error_message_title), fontSize = 30.sp)
                Spacer(modifier = Modifier.height(24.dp))
                Text(message)

                Text(stringResource(R.string.error_stacktrace_title))
                Text(stackTrace)
            }
        }
    }
}

@Preview
@Composable
fun ErrorPreview() {
    PreviewWrapper {
        ErrorMessage(message = "Error", stackTrace = "Stack trace")
    }
}
