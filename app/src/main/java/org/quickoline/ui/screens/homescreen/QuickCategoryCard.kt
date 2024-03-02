package org.quickoline.ui.screens.homescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun QuickCategoryCard(
    cardColor: Color,
    image: Int,
    title: String
) {

    val screenWidth = (LocalConfiguration.current.screenWidthDp / 2)

    Card(
        onClick = {},
        colors = CardDefaults.cardColors(containerColor = cardColor.copy(alpha = .30f)),
        modifier = Modifier
            .width(screenWidth.dp)
            .height(screenWidth.dp + 16.dp)
            .padding(10.dp)
    ) {

        Box(
            contentAlignment = Alignment.BottomCenter,
            modifier = Modifier.fillMaxSize()
        ) {
            Card(
                colors = CardDefaults.cardColors(containerColor = cardColor),
                modifier = Modifier
                    .fillMaxWidth()
                    .height((screenWidth / 2).dp)
                    .padding(6.dp)
            ) {}

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = image),
                    contentDescription = "services",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.height(100.dp)
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = title,
                    color = Color.Black.copy(alpha = 0.7f),
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(bottom = 15.dp)
                )
            }
        }
    }
}