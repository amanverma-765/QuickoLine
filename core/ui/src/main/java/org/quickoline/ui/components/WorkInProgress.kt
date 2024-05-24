package org.quickoline.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.quickoline.ui.R


@Composable
fun WorkInProgress(modifier: Modifier = Modifier) {

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {

        val tintColor = MaterialTheme.colorScheme.surfaceTint.copy(alpha = 0.7f)

        Image(
            modifier = Modifier.padding(24.dp),
            painter = painterResource(id = R.drawable.work_in_progress),
            contentDescription = stringResource(R.string.work_in_progress),
            colorFilter = ColorFilter.tint(tintColor)
        )

        Text(
            modifier = Modifier.offset(y = (-45).dp),
            text = stringResource(R.string.work_in_progress),
            style = MaterialTheme.typography
                .headlineMedium.copy(
                    fontWeight = FontWeight.Bold,
                    color = tintColor,
                )
        )
    }
}