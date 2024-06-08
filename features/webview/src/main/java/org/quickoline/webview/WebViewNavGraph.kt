package org.quickoline.webview

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import kotlinx.serialization.Serializable
import org.quickoline.utils.canNavigate

@Serializable
data class WebViewGraph(val url: String)

fun NavController.navigateToWebViewGraph(url: String, navOptions: NavOptions? = null) {
    if (canNavigate()) navigate(route = WebViewGraph(url), navOptions = navOptions)
}

fun NavGraphBuilder.webViewGraph(
    navigator: NavController,
) {
    composable<WebViewGraph> { backStack ->
        val url = backStack.toRoute<WebViewGraph>().url
        WebViewScreen(
            url = url,
            navigateBack = {
                if (navigator.canNavigate()) navigator.popBackStack()
            }
        )
    }
}