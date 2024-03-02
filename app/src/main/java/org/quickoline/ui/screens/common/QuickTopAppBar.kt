package org.quickoline.ui.screens.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.Menu
import androidx.compose.material.icons.twotone.Notifications
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import org.quickoline.R
import org.quickoline.ui.screens.utils.isScrollingUp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuickTopAppBar(
    lazyState: LazyListState,
    drawerState: DrawerState,
) {

    val badgeCount = rememberSaveable { mutableIntStateOf(222) }
    val coroutineScope = rememberCoroutineScope()

    CenterAlignedTopAppBar(
        title = {
            Text(buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.Bold
                    )
                ) {
                    append("Quicko")
                }
                withStyle(
                    style = SpanStyle(
                        color = MaterialTheme.colorScheme.secondary,
                        fontWeight = FontWeight.Bold
                    )
                ) {
                    append("Line")
                }
            })
        }, navigationIcon = {
            IconButton(
                onClick = {
                    coroutineScope.launch {
                        drawerState.apply {
                            if (isClosed) open() else close()
                        }
                    }
                }
            ) {
                Icon(imageVector = Icons.TwoTone.Menu, contentDescription = "Menu")
            }
        }, actions = {


            BadgedBox(
                badge = { Badge { Text(text = if (badgeCount.intValue < 9) badgeCount.intValue.toString() else "9+") } },
//                modifier = Modifier.padding(8.dp)
            ) {
                Icon(
                    imageVector = Icons.TwoTone.Notifications,
                    contentDescription = "Notifications"
                )
            }

            IconButton(onClick = { /*TODO*/ }, modifier = Modifier.padding(horizontal = 8.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.user),
                    contentDescription = "user",
                    modifier = Modifier
                        .size(30.dp)
                        .clip(CircleShape)
                )
            }
        }, colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = if (lazyState.isScrollingUp()) {
                MaterialTheme.colorScheme.background

            } else {
                MaterialTheme.colorScheme.surfaceColorAtElevation(3.dp)
            }
        )
    )
}


