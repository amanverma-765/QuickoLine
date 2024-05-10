package org.quickoline.components

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuickTopAppBar(
    modifier: Modifier = Modifier,
) {

    CenterAlignedTopAppBar(
        modifier = modifier,
        title = {
            QuickolineLogo()
        },
        navigationIcon = {
            IconButton(
                onClick = {
                    // Handle Navigation Drawer
                }
            ) {
                Icon(imageVector = Icons.TwoTone.Menu, contentDescription = "Menu")
            }
        },
        actions = {
            IconButton(
                onClick = {
                    // Handle Profile Click
                }
            ) {
                Surface(
                    color = MaterialTheme.colorScheme.secondaryContainer,
                    modifier = Modifier
                        .padding(2.dp)
                        .fillMaxSize()
                        .aspectRatio(1f)
                        .clip(CircleShape)
                ) {
                    // Image here
                }
            }
        }
    )

}