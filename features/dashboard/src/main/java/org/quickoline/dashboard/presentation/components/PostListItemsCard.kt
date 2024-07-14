package org.quickoline.dashboard.presentation.components

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import org.quickoline.dashboard.R
import org.quickoline.domain.model.post.PostData
import org.quickoline.ui.theme.smallPadding
import org.quickoline.ui.theme.smallestPadding
import org.quickoline.ui.theme.verySmallPadding

@Composable
internal fun PostListItemsCard(
    modifier: Modifier = Modifier,
    postData: PostData,
    category: Category,
    navigateToPostDetail: (PostData) -> Unit
) {
    OutlinedCard(
        onClick = { navigateToPostDetail(postData) },
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(smallPadding),
            horizontalArrangement = Arrangement.Start
        ) {

            ElevatedCard(
                modifier = Modifier
                    .fillMaxHeight()
                    .aspectRatio(1f)
            ) {
               Image(
                   modifier = Modifier.padding(smallPadding),
                   painter = painterResource(
                       id = when (category) {
                           Category.FORM_FILLING -> R.drawable.form_filling
                           Category.LEGAL_WORK -> R.drawable.legal_work
                           Category.LAST_MINUTE -> R.drawable.last_minute
                           Category.MORE_SERVICES -> R.drawable.extra_service
                       }
                   ),
                   colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary),
                   contentDescription = "",
               )
            }
            Spacer(modifier = Modifier.width(smallestPadding))
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
                    overflow = TextOverflow.Clip,
                )
                Spacer(modifier = Modifier.height(smallestPadding))
                postData.postName?.let { data ->
                    Text(
                        text = data,
                        style = MaterialTheme.typography.bodySmall,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.alpha(.7f)
                    )
                }
                Spacer(modifier = Modifier.height(smallestPadding))
                Text(
                    text = "Last date: ${postData.lastDate ?: "∞"}",
                    style = MaterialTheme.typography.labelSmall,
                    textAlign = TextAlign.End,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = .7f),
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}
