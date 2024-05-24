package org.quickoline.home.presentation.components

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp

@Composable
internal fun CategoryCard(modifier: Modifier = Modifier) {

    val width = LocalConfiguration.current.screenWidthDp / 2

    ElevatedCard(
        onClick = { /*TODO*/ },
        modifier = modifier.width((width / 1.1).dp).aspectRatio(1f)
    ) {

    }
}