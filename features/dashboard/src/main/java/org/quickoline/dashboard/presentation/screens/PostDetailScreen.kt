package org.quickoline.dashboard.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowOutward
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import org.quickoline.domain.model.post.PostData
import org.quickoline.ui.components.BottomBarWithButton
import org.quickoline.ui.components.SecondaryTopAppBar
import org.quickoline.ui.theme.mediumPadding
import org.quickoline.ui.theme.smallPadding
import org.quickoline.ui.theme.smallestPadding
import org.quickoline.utils.isScrollingUp
import org.quickoline.utils.plus

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
internal fun PostDetailScreen(
    modifier: Modifier = Modifier,
    postData: PostData,
    navigateToSource: (String) -> Unit,
    navigateToWebsite: (String) -> Unit,
    navigateBack: () -> Unit
) {

    val scrollState = rememberScrollState()

    Scaffold(
        topBar = {
            SecondaryTopAppBar(
                title = "Post Details",
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = if (scrollState.isScrollingUp()) {
                        TopAppBarDefaults.topAppBarColors().scrolledContainerColor
                    } else {
                        TopAppBarDefaults.topAppBarColors().containerColor
                    }
                ),
                navigateBack = { navigateBack() }
            )
        },
        bottomBar = {
            BottomBarWithButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(mediumPadding),
                onClick = { /*TODO*/ }) {
                Text(text = "Apply Now")
            }
        }
    ) { innerPadding ->
        Column(
            verticalArrangement = Arrangement.spacedBy(mediumPadding),
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding.plus(PaddingValues(horizontal = smallPadding)))
                .verticalScroll(scrollState)
        ) {
            Text(
                text = postData.postName ?: postData.title,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.SemiBold
            )

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(12.dp))
                        .background(MaterialTheme.colorScheme.surfaceContainer)
                ) {
                    Text(
                        text = buildAnnotatedString {
                            withStyle(
                                SpanStyle(
                                    color = MaterialTheme.colorScheme.primary
                                )
                            ) {
                                append("Start: ")
                            }
                            append(postData.startDate ?: "Active")
                        },
                        modifier = Modifier.padding(smallPadding)
                    )
                }
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(12.dp))
                        .background(MaterialTheme.colorScheme.surfaceContainer)
                ) {
                    Text(
                        text = buildAnnotatedString {
                            withStyle(
                                SpanStyle(
                                    color = MaterialTheme.colorScheme.primary
                                )
                            ) {
                                append("Last: ")
                            }
                            append(postData.lastDate ?: "Available Soon")
                        },
                        modifier = Modifier.padding(smallPadding)
                    )
                }
            }
            postData.shortInfo?.let { info ->
                OutlinedCard(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                ) {
                    Box(modifier = Modifier.padding(smallPadding)) {
                        Text(
                            text = buildAnnotatedString {
                                withStyle(
                                    SpanStyle(
                                        color = MaterialTheme.colorScheme.primary,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = MaterialTheme.typography.titleMedium.fontSize
                                    )
                                ) {
                                    append("Short info: ")
                                }
                                append(info)
                            }
                        )
                    }
                }
            }
            postData.docsRequired?.let { documents ->
                Text(
                    text = "Documents required: ",
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleMedium
                )
                FlowRow(
                    horizontalArrangement = Arrangement.spacedBy(smallPadding),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    documents.forEach { doc ->
                        FilterChip(
                            selected = true,
                            onClick = { },
                            label = { Text(text = doc) }
                        )
                    }
                }
            }
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceContainer
                )
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(mediumPadding),
                    modifier = Modifier.padding(mediumPadding)
                ) {
                    Text(
                        text = "Fees details: ",
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.titleMedium
                    )
                    postData.fees.toList().forEach { (category, fees) ->
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Box(
                                contentAlignment = Alignment.CenterStart,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .weight(1f)
                            ) {
                                Text(
                                    text = category,
                                    style = MaterialTheme.typography.bodyLarge
                                )
                            }
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .weight(1f)
                            ) {
                                Text(
                                    text = ":",
                                    style = MaterialTheme.typography.bodyLarge,
                                    fontWeight = FontWeight.ExtraBold
                                )
                            }
                            Box(
                                contentAlignment = Alignment.CenterEnd,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .weight(1f)
                            ) {
                                Text(
                                    text = if (fees == 0) "Free" else "$fees INR",
                                    color = if (fees == 0) MaterialTheme.colorScheme.primary
                                    else Color.Unspecified,
                                    style = MaterialTheme.typography.bodyLarge
                                )
                            }
                        }
                    }
                }
            }
            Row(horizontalArrangement = Arrangement.End, modifier = Modifier.fillMaxWidth()) {
                postData.srcUrl?.let { source ->
                    OutlinedButton(
                        onClick = { navigateToSource(source) }
                    ) {
                        Text(text = "More info")
                        Spacer(modifier = Modifier.width(smallestPadding))
                        Icon(imageVector = Icons.Rounded.ArrowOutward, contentDescription = "more")
                    }
                }
                Spacer(modifier = Modifier.width(mediumPadding))
                postData.postUrl?.let { postUrl ->
                    OutlinedButton(
                        onClick = { navigateToWebsite(postUrl) }
                    ) {
                        Text(text = "Visit")
                        Spacer(modifier = Modifier.width(smallestPadding))
                        Icon(imageVector = Icons.Rounded.ArrowOutward, contentDescription = "more")
                    }
                }
            }
        }
    }
}