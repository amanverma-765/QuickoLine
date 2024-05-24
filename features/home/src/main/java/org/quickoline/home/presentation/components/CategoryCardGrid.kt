package org.quickoline.home.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.quickoline.ui.theme.standardPadding

@OptIn(ExperimentalLayoutApi::class)
@Composable
internal fun CategoryCardGrid(modifier: Modifier = Modifier) {

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        FlowRow(
            verticalArrangement = Arrangement.spacedBy(standardPadding),
            horizontalArrangement = Arrangement.spacedBy(standardPadding),
            maxItemsInEachRow = 2,
            modifier = Modifier
        ) {
            (1..4).forEach {
                CategoryCard()
            }
        }
    }
}