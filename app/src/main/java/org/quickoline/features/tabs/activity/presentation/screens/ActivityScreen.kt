package org.quickoline.features.tabs.activity.presentation.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
internal fun ActivityScreen(modifier: Modifier = Modifier) {

    Scaffold { padding ->

        LazyColumn(
            modifier = modifier,
            contentPadding = padding
        ) {

            item {
                Text(text = "Activity Screen")
            }

        }
    }

}