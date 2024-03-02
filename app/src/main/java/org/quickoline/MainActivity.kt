package org.quickoline

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import org.quickoline.ui.screens.homescreen.QuickHomeScreen
import org.quickoline.ui.theme.QuickoLineTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuickoLineTheme {
                App()
            }
        }
    }
}

@Composable
fun App() {

    QuickHomeScreen()

}
