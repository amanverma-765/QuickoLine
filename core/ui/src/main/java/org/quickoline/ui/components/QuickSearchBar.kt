package org.quickoline.ui.components

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.add
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.exclude
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Mic
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import org.quickoline.ui.R
import org.quickoline.ui.theme.standardPadding

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuickSearchBar(
    modifier: Modifier = Modifier,
    activeState: (isActive: Boolean) -> Unit
) {

    var active by remember { mutableStateOf(false) }

    val animatedHorizontalPadding = animateDpAsState(
        targetValue = if (active) 0.dp else standardPadding,
        label = "Animating Horizontal Padding"
    )


    val animatedTopPadding = animateDpAsState(
        targetValue = if (active) {
            SearchBarDefaults
                .windowInsets
                .asPaddingValues()
                .calculateTopPadding()
        } else 0.dp,
        label = "Animating Top Padding",
    )

    SearchBar(
        query = "",
        onQueryChange = {},
        onSearch = {},
        active = active,
        onActiveChange = { state ->
            active = state
            activeState(state)
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Rounded.Search,
                contentDescription = stringResource(R.string.search)
            )
        },
        trailingIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Rounded.Mic,
                    contentDescription = stringResource(R.string.microphone)
                )
            }
        },
        placeholder = { Text(text = stringResource(R.string.search_here)) },
        shape = RoundedCornerShape(16.dp),
        windowInsets = SearchBarDefaults.windowInsets
            .exclude(WindowInsets.systemBars)
            .add(WindowInsets(top = animatedTopPadding.value)),
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = animatedHorizontalPadding.value)
    ) { }
}