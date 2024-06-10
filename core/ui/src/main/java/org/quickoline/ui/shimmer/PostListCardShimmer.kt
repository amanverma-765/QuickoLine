package org.quickoline.ui.shimmer

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.OutlinedCard
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.materialkolor.ktx.darken
import com.materialkolor.ktx.lighten
import com.valentinilk.shimmer.shimmer
import org.quickoline.ui.theme.smallPadding

@Composable
fun PostListCardShimmer(modifier: Modifier = Modifier) {

    val shimmerContentColor =
        if (isSystemInDarkTheme()) CardDefaults.cardColors().containerColor.lighten(1.3f)
        else CardDefaults.cardColors().containerColor.darken(1.3f)

    val shimmerContainerColor =
        if (isSystemInDarkTheme()) CardDefaults.cardColors().containerColor.lighten(1f)
        else CardDefaults.cardColors().containerColor.darken(1f)

    val cardShape = remember { RoundedCornerShape(6.dp) }

    OutlinedCard(
//        colors = CardDefaults.cardColors(containerColor = shimmerContainerColor),
        modifier = modifier
            .fillMaxWidth()
            .height(100.dp)
            .shimmer()
    ) {
        Row(modifier = Modifier.padding(smallPadding)) {
            Card(
                colors = CardDefaults.cardColors(containerColor = shimmerContentColor),
                modifier = Modifier
                    .fillMaxHeight()
                    .aspectRatio(1f)
            ) {}
            Spacer(modifier = Modifier.width(smallPadding))
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Card(
                    shape = cardShape,
                    colors = CardDefaults.cardColors(containerColor = shimmerContentColor),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(16.dp)
                ) {}
                Card(
                    shape = cardShape,
                    colors = CardDefaults.cardColors(containerColor = shimmerContentColor),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(32.dp)
                ) {}
                Row(horizontalArrangement = Arrangement.End, modifier = Modifier.fillMaxWidth()) {
                    Card(
                        shape = cardShape,
                        colors = CardDefaults.cardColors(containerColor = shimmerContentColor),
                        modifier = Modifier
                            .width(70.dp)
                            .height(16.dp)
                    ) {}
                }
            }
        }
    }
}