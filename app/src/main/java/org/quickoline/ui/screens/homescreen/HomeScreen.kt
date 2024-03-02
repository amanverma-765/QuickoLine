package org.quickoline.ui.screens.homescreen

import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Card
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.quickoline.ui.screens.common.QuickAppDrawer
import org.quickoline.ui.screens.common.QuickBottomBar
import org.quickoline.ui.screens.common.QuickTopBarWithSearchBar

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun QuickHomeScreen() {

    val query = remember { mutableStateOf("") }
    val isSearchBarActive = remember { mutableStateOf(false) }
    val lazyState = rememberLazyListState()

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = { QuickAppDrawer() }
    ) {
        Scaffold(

            topBar = {
                QuickTopBarWithSearchBar(
                    lazyState = lazyState,
                    isSearchBarActive = isSearchBarActive,
                    query = query,
                    drawerState = drawerState
                )
            },
            bottomBar = { QuickBottomBar() }

        ) { scaffoldPadding ->

            LazyColumn(
                state = lazyState,
                contentPadding = scaffoldPadding,
                modifier = Modifier.fillMaxSize()
            ) {

                item {
                    FlowRow(
                        maxItemsInEachRow = 2,
                        modifier = Modifier.fillMaxWidth()
                    ) {

                        CategoryList.forEach { category ->
                            QuickCategoryCard(
                                cardColor = category.cardColor,
                                category.image,
                                category.title
                            )
                        }
                    }
                }
                items(100) {
                    Card(
                        onClick = {},
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                            .padding(horizontal = 15.dp, vertical = 10.dp)
                    ) {


                    }
                }
            }
        }
    }
}

