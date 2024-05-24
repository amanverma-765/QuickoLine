package org.quickoline.activity.presentation.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.quickoline.ui.components.QuickTopAppBar
import org.quickoline.ui.components.WorkInProgress


@Composable
internal fun ActivityScreen(
    modifier: Modifier = Modifier,
) {

    Scaffold(
        topBar = { QuickTopAppBar() },
    ) { padding ->

        WorkInProgress(modifier = modifier.padding(padding))
    }

}