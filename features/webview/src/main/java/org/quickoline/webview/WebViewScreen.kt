package org.quickoline.webview

import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.viewinterop.AndroidView
import org.quickoline.ui.components.SecondaryTopAppBar
import org.quickoline.ui.R

@Composable
internal fun WebViewScreen(
    modifier: Modifier = Modifier,
    url: String,
    onNavigateBack: () -> Unit
) {

    Scaffold(
        topBar = {
            SecondaryTopAppBar(
                title = stringResource(R.string.our_policies),
                onNavigateBack = onNavigateBack
            )
        }
    ) { innerPadding ->
        AndroidView(
            modifier = modifier.padding(innerPadding),
            factory = { context ->
                WebView(context).apply {
                    webViewClient = WebViewClient()
                    settings.loadWithOverviewMode = true
                    settings.useWideViewPort = true
                    settings.setSupportZoom(true)
                }
            },
            update = { webView ->
                webView.loadUrl(url)
            }
        )
    }

}