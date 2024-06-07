package org.quickoline.dashboard.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.quickoline.ui.theme.smallPadding
import org.quickoline.ui.theme.verySmallPadding

@Composable
internal fun CategoryCard(
    modifier: Modifier = Modifier,
    categoryCard: CategoryItem,
    onClick: (Category) -> Unit
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = categoryCard.bgColor.copy(alpha = .5f)
        ),
        onClick = { onClick(categoryCard.category) },
        modifier = modifier.aspectRatio(1f)
    ) {
        Box(
            contentAlignment = Alignment.BottomCenter,
            modifier = Modifier.fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(verySmallPadding)
                    .fillMaxHeight(.5f)
                    .clip(CardDefaults.shape)
                    .background(categoryCard.bgColor.copy(alpha = .7f))
            )
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                Image(
                    painter = painterResource(id = categoryCard.icon),
                    contentDescription = stringResource(categoryCard.title),
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.height(100.dp)
                )

                Spacer(modifier = Modifier.height(smallPadding))

                Text(
                    text = stringResource(categoryCard.title),
                    style = MaterialTheme.typography.titleLarge,
                    color = Color(0x99050505),
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}