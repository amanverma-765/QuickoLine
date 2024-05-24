package org.quickoline.home.presentation.components

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.quickoline.ui.theme.standardPadding

@Composable
internal fun ListItemsCard(modifier: Modifier = Modifier) {
    ElevatedCard(
        onClick = {  },
        modifier =
            modifier.padding(horizontal = standardPadding)
            .fillMaxWidth()
            .aspectRatio(3f / 1f)
    ) {

    }
}