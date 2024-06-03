package org.quickoline.utils

import androidx.lifecycle.Lifecycle
import androidx.navigation.NavController

fun NavController.canNavigate(): Boolean {
    return currentBackStackEntry?.lifecycle?.currentState == Lifecycle.State.RESUMED
}
