package org.quickoline.ui.screens.common

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.twotone.ArrowBack
import androidx.compose.material.icons.twotone.Close
import androidx.compose.material.icons.twotone.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.quickoline.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuickSearchBar(query: MutableState<String>, isSearchBarActive: MutableState<Boolean>) {

    val animatedTopPadding = animateDpAsState(
        label = "null",
        targetValue = if (isSearchBarActive.value) {
            SearchBarDefaults
                .windowInsets
                .asPaddingValues()
                .calculateTopPadding()
        } else 0.dp,
    )

    val animatedHorizontalPadding = animateDpAsState(

        targetValue = if (isSearchBarActive.value) 0.dp else 18.dp,
        label = "Animating Horizontal Padding"
    )

    SearchBar(
        query = query.value,
        onQueryChange = { searchQuery ->
            query.value = searchQuery
        },
        onSearch = { },
        active = isSearchBarActive.value,
        onActiveChange = { activeState ->
            query.value = ""
            isSearchBarActive.value = activeState
        },
        placeholder = {
            Text(
                text = "Search here...",
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.alpha(0.6f)
            )
        },
        leadingIcon = {
            AnimatedVisibility(
                visible = isSearchBarActive.value,
                exit = slideOutHorizontally { -it } + fadeOut(),
                enter = slideInHorizontally() + fadeIn()
            ) {
                IconButton(onClick = { isSearchBarActive.value = false; query.value = "" }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.TwoTone.ArrowBack,
                        contentDescription = "Back Arrow"
                    )
                }
            }
            AnimatedVisibility(
                visible = !isSearchBarActive.value,
                exit = slideOutHorizontally { it } + fadeOut(),
                enter = slideInHorizontally { it } + fadeIn()
            ) {
                IconButton(onClick = { isSearchBarActive.value = true }) {
                    Icon(imageVector = Icons.TwoTone.Search, contentDescription = "Search")
                }
            }
        },
        trailingIcon = {
            Row(
                modifier = Modifier.animateContentSize(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.mic_24px),
                        contentDescription = "Microphone"
                    )
                }

                if (isSearchBarActive.value && query.value.isNotEmpty()) {
                    IconButton(onClick = { query.value = "" }) {
                        Icon(
                            imageVector = Icons.TwoTone.Close,
                            contentDescription = "Clear Text",
                        )
                    }
                }
            }
        },
        shape = RoundedCornerShape(18.dp),
        windowInsets = WindowInsets(top = animatedTopPadding.value),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = animatedHorizontalPadding.value)
            .padding(bottom = 12.dp)
    ) {

    }
}