package org.quickoline.features.tabs.home.presentation.components

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp

@Composable
fun CategoryCard(modifier: Modifier = Modifier) {

    val width = LocalConfiguration.current.screenWidthDp / 2

    ElevatedCard(
        onClick = { /*TODO*/ },
        modifier = modifier.width((width / 1.13).dp).aspectRatio(1f)
    ) {

    }
}