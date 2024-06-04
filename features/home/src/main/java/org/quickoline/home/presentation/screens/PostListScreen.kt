package org.quickoline.home.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.quickoline.ui.components.SecondaryTopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun PostListScreen(
    modifier: Modifier = Modifier,
    navigateBack: () -> Unit
) {

    Scaffold(
        topBar = {
            SecondaryTopAppBar(title = "Post List Screen") { navigateBack() }
        }
    ) { internalPadding ->
        Box(
            modifier = modifier
                .fillMaxSize()
                .padding(internalPadding)
        ) {

        }
    }

}