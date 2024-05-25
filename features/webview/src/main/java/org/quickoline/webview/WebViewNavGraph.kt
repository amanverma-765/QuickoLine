package org.quickoline.webview

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import kotlinx.serialization.Serializable

@Serializable
data class WebViewGraph(val url: String)

fun NavGraphBuilder.webViewGraph(
    navigator: NavController,
) {

    composable<WebViewGraph> { backStack ->

        val url = backStack.toRoute<WebViewGraph>().url

        WebViewScreen(
            url = url,
            onNavigateBack = { navigator.popBackStack() }
        )
    }

}