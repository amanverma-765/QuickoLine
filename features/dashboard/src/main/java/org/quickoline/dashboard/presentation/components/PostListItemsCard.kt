package org.quickoline.dashboard.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import org.quickoline.domain.model.post.PublicPostData
import org.quickoline.ui.theme.smallPadding
import org.quickoline.ui.theme.verySmallPadding

@Composable
internal fun PostListItemsCard(
    modifier: Modifier = Modifier,
    postData: PublicPostData
) {
    ElevatedCard(
        onClick = {},
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .sizeIn(minHeight = 80.dp, maxHeight = 100.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(smallPadding),
            horizontalArrangement = Arrangement.Start
        ) {

            Card(
                modifier = Modifier
                    .fillMaxHeight()
                    .aspectRatio(1f)
            ) {}

            Spacer(modifier = Modifier.width(verySmallPadding))

            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = verySmallPadding)
            ) {
                Text(
                    text = postData.title,
                    maxLines = 1,
                    style = MaterialTheme.typography.titleSmall,
                    overflow = TextOverflow.Ellipsis,
                )
                postData.postName?.let {
                    Text(
                        text = postData.postName ?: "",
                        style = MaterialTheme.typography.bodySmall,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        softWrap = true,
                        modifier = Modifier.alpha(.7f)
                    )
                }
                Row(
                    modifier = Modifier
                        .wrapContentHeight()
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "start: ${postData.startDate ?: "∞"}",
                        style = MaterialTheme.typography.labelSmall,
                        modifier = Modifier.alpha(.5f)
                    )
                    Text(
                        text = "end: ${postData.lastDate ?: "∞"}",
                        style = MaterialTheme.typography.labelSmall,
                        modifier = Modifier.alpha(.5f)
                    )
                }
            }
        }
    }
}