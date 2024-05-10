package org.quickoline.features.tabs.activity.presentation.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.quickoline.components.QuickTopAppBar
import org.quickoline.components.WorkInProgress

@Composable
internal fun ActivityScreen(modifier: Modifier = Modifier) {

    Scaffold(
        topBar = { QuickTopAppBar() }
    ) { padding ->

        WorkInProgress(modifier = modifier.padding(padding))
    }

}