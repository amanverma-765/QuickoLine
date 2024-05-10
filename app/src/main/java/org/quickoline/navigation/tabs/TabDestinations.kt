package org.quickoline.navigation.tabs

import android.app.Application
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat.getColorStateList
import androidx.core.content.ContextCompat.getString
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import org.quickoline.R

@Serializable
sealed interface TabDestinations {

    @Serializable
    data object HomeTab : TabDestinations

    @Serializable
    data object ActivityTab : TabDestinations
}

