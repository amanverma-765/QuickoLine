package org.quickoline.home.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.quickoline.ui.theme.smallPadding

@Composable
internal fun CategoryCardGrid(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .wrapContentSize()
            .padding(horizontal = smallPadding)
    ) {
        LazyVerticalGrid(
            verticalArrangement = Arrangement.spacedBy(smallPadding),
            horizontalArrangement = Arrangement.spacedBy(smallPadding),
            columns = GridCells.Fixed(2),
            modifier = modifier
                .fillMaxWidth()
                .aspectRatio(1f)
        ) {
            items(4) {
                CategoryCard(
                    onClick = { onClick() }
                )
            }
        }
    }
}