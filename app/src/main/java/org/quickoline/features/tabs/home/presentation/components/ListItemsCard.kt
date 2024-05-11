package org.quickoline.features.tabs.home.presentation.components

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.quickoline.theme.standardPadding

@Composable
fun ListItemsCard(modifier: Modifier = Modifier) {
    ElevatedCard(
        onClick = { /*TODO*/ },
        modifier =
            modifier.padding(horizontal = standardPadding)
            .fillMaxWidth()
            .aspectRatio(3f / 1f)
    ) {

    }
}