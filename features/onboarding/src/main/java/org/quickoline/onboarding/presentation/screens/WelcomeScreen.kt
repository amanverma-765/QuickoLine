package org.quickoline.onboarding.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.quickoline.onboarding.presentation.components.BottomBarWithButton
import org.quickoline.onboarding.presentation.viewmodel.OnBoardingUiEvents
import org.quickoline.onboarding.presentation.viewmodel.OnBoardingUiStates
import org.quickoline.ui.R
import org.quickoline.ui.components.QuickolineLogo
import org.quickoline.ui.theme.moderatePadding
import org.quickoline.ui.theme.standardPadding
import org.quickoline.utils.AutoResizedText
import org.quickoline.utils.Constants.POLICY_URL
import org.quickoline.utils.HyperlinkText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun WelcomeScreen(
    modifier: Modifier = Modifier,
    onBoardingUiEvents: (OnBoardingUiEvents) -> Unit,
    onBoardingUiStates: OnBoardingUiStates,
    navigateToDashboard: () -> Unit,
    navigateToPolicy: (String) -> Unit
) {

    LaunchedEffect(key1 = onBoardingUiStates) {
        onBoardingUiEvents(OnBoardingUiEvents.CheckIfOnBoardingIsCompleted)
        if (
            onBoardingUiStates.policyAccepted
            && onBoardingUiStates.userEntryCompleted
        ) navigateToDashboard()
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        QuickolineLogo(
                            modifier = Modifier,
                            logoStyle = TextStyle(fontSize = 32.sp)
                        )
                        Text(
                            text = stringResource(R.string.quickoline_slogan),
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Light,
                            fontFamily = FontFamily.Cursive
                        )
                    }
                }
            )
        },
        bottomBar = {
            BottomBarWithButton(
                btnText = stringResource(R.string.onboarding_get_started) + " ->",
                enabled = onBoardingUiStates.policyAccepted,
                onClick = {
                    onBoardingUiEvents(OnBoardingUiEvents.SaveUserEntryState)
                    navigateToDashboard()
                }
            )
        }

    ) { innerPadding ->
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(50.dp),
                painter = painterResource(id = org.quickoline.onboarding.R.drawable.onboarding_image),
                contentDescription = null,
                contentScale = ContentScale.Fit,
            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
            ) {
                AutoResizedText(
                    text = stringResource(R.string.onboarding_title),
                    style = TextStyle(
                        fontSize = 32.sp,
                        lineHeight = 40.sp,
                        fontWeight = FontWeight.Bold,
                    ),
                    modifier = Modifier.padding(horizontal = 32.dp)
                )

                Spacer(modifier = Modifier.height(standardPadding))

                Text(
                    text = stringResource(R.string.onboarding_disc),
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Light,
                    modifier = Modifier.padding(horizontal = 42.dp)
                )
            }

            Spacer(modifier = Modifier.height(moderatePadding))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(horizontal = 24.dp)
            ) {

                Checkbox(
                    checked = onBoardingUiStates.policyAccepted,
                    onCheckedChange = { state ->
                        onBoardingUiEvents(OnBoardingUiEvents.SavePolicyState(state))
                    }
                )

                HyperlinkText(
                    fullText = "I have read and agree to the Terms & Conditions and Privacy Policy",
                    hyperLinks = mapOf(
                        "Terms & Conditions" to POLICY_URL,
                        "Privacy Policy" to POLICY_URL
                    ),
                    textStyle = TextStyle(
                        color = MaterialTheme.colorScheme.onBackground,
                        fontSize = 16.sp
                    ),
                    linkTextStyle = TextStyle(
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.SemiBold
                    ),
                    onClick = { url ->
                        navigateToPolicy(url)
                    }
                )
            }
        }
    }
}
