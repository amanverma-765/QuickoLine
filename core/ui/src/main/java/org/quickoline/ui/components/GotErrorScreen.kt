package org.quickoline.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Warning
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.quickoline.ui.R

@Composable
fun GotErrorScreen(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {

        val tintColor = MaterialTheme.colorScheme.error

        Icon(
            imageVector = Icons.Rounded.Warning,
            contentDescription = "warning",
            tint = tintColor,
            modifier = Modifier.size(100.dp)
        )

        Text(
            text = stringResource(R.string.something_went_wrong),
            style = MaterialTheme.typography
                .headlineSmall.copy(
                    fontWeight = FontWeight.Bold,
                    color = tintColor,
                )
        )
    }
}