package org.quickoline.dashboard.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import org.quickoline.ui.theme.verySmallPadding

@Composable
internal fun PostListItemsCard(
    modifier: Modifier = Modifier,
    postItem: PostItem = postListItems[0]
) {
    ElevatedCard(
        onClick = {},
        modifier = modifier
            .fillMaxWidth()
            .height(120.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(verySmallPadding),
            horizontalArrangement = Arrangement.Start
        ) {

            Card(
                modifier = Modifier
                    .fillMaxHeight()
                    .aspectRatio(1f)
            ) {}
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = verySmallPadding)
            ) {
                Text(
                    text = postItem.title,
                    maxLines = 1,
                    style = MaterialTheme.typography.titleSmall,
                    overflow = TextOverflow.Ellipsis,
                    softWrap = true
                )
                Text(
                    text = postItem.description,
                    style = MaterialTheme.typography.bodySmall,
                    maxLines = 4,
                    overflow = TextOverflow.Ellipsis,
                    softWrap = true,
                    modifier = Modifier.alpha(.7f)
                )
                Row(
                    modifier = Modifier
                        .wrapContentHeight()
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "start: ${postItem.startDate}",
                        style = MaterialTheme.typography.labelSmall,
                        modifier = Modifier.alpha(.5f)
                    )
                    Text(
                        text = "end: ${postItem.lastDate}",
                        style = MaterialTheme.typography.labelSmall,
                        modifier = Modifier.alpha(.5f)
                    )
                }
            }
        }
    }
}


data class PostItem(
    val title: String,
    val description: String,
    val lastDate: String,
    val startDate: String
)

val postListItems = listOf(
    PostItem(
        title = "Railway RPF Constable / Sub Inspector Correction / Edit Form 2024, Fee Payment Date Extended",
        description = "RRB Railway Protection Force RPF CEN 01/2024 Sub Inspector and CEN 02/2024 Constable Apply Correction Edit Form for 4660 Post",
        lastDate = "31/06/24",
        startDate = "06/05/24"
    )
)