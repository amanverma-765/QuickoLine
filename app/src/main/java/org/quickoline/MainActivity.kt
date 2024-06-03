package org.quickoline

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.viewmodel.compose.viewModel
import org.koin.androidx.compose.KoinAndroidContext
import org.koin.core.annotation.KoinExperimentalAPI
import org.quickoline.navigation.root.RootNavHost
import org.quickoline.onboarding.navigation.OnBoardingGraph
import org.quickoline.ui.theme.QuickoLineTheme
import org.quickoline.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {
    @OptIn(KoinExperimentalAPI::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var shouldShowSplash by mutableStateOf(true)
        installSplashScreen().apply {
            setKeepOnScreenCondition { shouldShowSplash }
        }
        enableEdgeToEdge()
        setContent {
            QuickoLineTheme {
                KoinAndroidContext {

                    val mainVm = viewModel<MainViewModel>()
                    val mainState by mainVm.mainState.collectAsState()

                    LaunchedEffect(key1 = mainState) {
                        shouldShowSplash = mainState.shouldShowSplash
                    }

                    RootNavHost(
                        startDestination = OnBoardingGraph,
                        modifier = Modifier.background(MaterialTheme.colorScheme.background)
                    )
                }
            }
        }
    }
}