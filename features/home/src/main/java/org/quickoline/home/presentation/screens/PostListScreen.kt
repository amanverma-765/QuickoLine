package org.quickoline.home.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import org.quickoline.home.R
import org.quickoline.home.presentation.components.Category
import org.quickoline.home.presentation.components.PostListItemsCard
import org.quickoline.home.presentation.components.SecondaryTopBarWithSearchBar
import org.quickoline.ui.theme.smallPadding

@Composable
internal fun PostListScreen(
    modifier: Modifier = Modifier,
    category: Category,
    navigateBack: () -> Unit
) {

    val lazyState = rememberLazyListState()

    Scaffold(
        topBar = {
            SecondaryTopBarWithSearchBar(
                title =  when(category) {
                    Category.FORM_FILLING -> stringResource(R.string.form_filling_services_title)
                    Category.LEGAL_WORK -> stringResource(R.string.legal_services_title)
                    Category.LAST_MINUTE -> stringResource(R.string.last_minute_services_title)
                    Category.MORE_SERVICES -> stringResource(R.string.more_services_title)
                },
                lazyState = lazyState,
                navigateBack = { navigateBack() }
            )
        }
    ) { innerPadding ->

        LazyColumn(
            state = lazyState,
            verticalArrangement = Arrangement.spacedBy(smallPadding),
            contentPadding = innerPadding,
            modifier = modifier.fillMaxSize()
        ) {

            items(50) {
                PostListItemsCard()
            }

        }
    }

}