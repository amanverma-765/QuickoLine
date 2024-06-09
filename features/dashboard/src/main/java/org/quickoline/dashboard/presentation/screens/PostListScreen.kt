package org.quickoline.dashboard.presentation.screens

import android.widget.Toast
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.valentinilk.shimmer.shimmer
import org.quickoline.dashboard.presentation.components.Category
import org.quickoline.dashboard.presentation.components.PostListItemsCard
import org.quickoline.dashboard.presentation.components.SecondaryTopBarWithSearchBar
import org.quickoline.dashboard.presentation.viewmodel.post.PostUiEvents
import org.quickoline.dashboard.presentation.viewmodel.post.PostUiStates
import org.quickoline.ui.R
import org.quickoline.ui.theme.smallPadding
import org.quickoline.ui.theme.verySmallPadding
import org.quickoline.utils.ApiResponse
import org.quickoline.utils.plus

@Composable
internal fun PostListScreen(
    modifier: Modifier = Modifier,
    category: Category,
    uiState: PostUiStates,
    uiEvent: (PostUiEvents) -> Unit,
    navigateBack: () -> Unit
) {

    val lazyState = rememberLazyListState()
    val context = LocalContext.current

    LaunchedEffect(key1 = Unit) {
        uiEvent(PostUiEvents.FetchPostData(category))
    }

    Scaffold(
        topBar = {
            SecondaryTopBarWithSearchBar(
                title = stringResource(id = category.title),
                lazyState = lazyState,
                navigateBack = { navigateBack() }
            )
        }
    ) { innerPadding ->

        LazyColumn(
            state = lazyState,
            verticalArrangement = Arrangement.spacedBy(smallPadding),
            contentPadding = innerPadding.plus(PaddingValues(horizontal = smallPadding)),
            modifier = modifier.fillMaxSize()
        ) {

            val response = when (category) {
                Category.FORM_FILLING -> uiState.postResponse
                Category.LEGAL_WORK -> uiState.postResponse
                Category.LAST_MINUTE -> uiState.postResponse
                Category.MORE_SERVICES -> ApiResponse.Loading
            }

            when (response) {
                is ApiResponse.Error -> {
                    Toast.makeText(
                        context,
                        response.message,
                        Toast.LENGTH_SHORT
                    ).show()
                }
                is ApiResponse.Loading -> {
                    item {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier.fillParentMaxSize()
                        ) {
                            CircularProgressIndicator()
                            Spacer(modifier = Modifier.height(verySmallPadding))
                            Text(text = "Loading...")
                        }
                    }
                }
                is ApiResponse.Success -> {
                    items(response.data) { data ->
                        PostListItemsCard(postData = data)
                    }
                }
            }
        }
    }
}