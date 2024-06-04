package org.quickoline.home.presentation.components

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
internal fun CategoryCard(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    ElevatedCard(
        onClick = { onClick() },
        modifier = modifier.aspectRatio(1f)
    ) {

    }
}