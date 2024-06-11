package org.quickoline.utils

import androidx.compose.foundation.ScrollState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun ScrollState.isScrollingUp(): Boolean {
    var previousScrollOffset by remember(this) { mutableIntStateOf(value) }
    return remember(this) {
        derivedStateOf {
            (previousScrollOffset >= value).also {
                previousScrollOffset = value
            }
        }
    }.value.not()
}