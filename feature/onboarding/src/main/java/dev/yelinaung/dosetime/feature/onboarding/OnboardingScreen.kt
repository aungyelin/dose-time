package dev.yelinaung.dosetime.feature.onboarding

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import dev.yelinaung.dosetime.core.designsystem.component.ThemePreviews
import dev.yelinaung.dosetime.core.designsystem.theme.DoseTimeTheme
import dev.yelinaung.dosetime.feature.onboarding.R as onboardingR

@Composable
fun OnboardingScreen(
    onClickGetStarted: () -> Unit,
    viewModel: OnboardingVM = hiltViewModel(),
) {
    OnboardingScreen(
        onClickGetStarted = onClickGetStarted,
        setFinishOnboardingStatus = viewModel::setFinishOnboardingStatus
    )
}

@Composable
internal fun OnboardingScreen(
    onClickGetStarted: () -> Unit,
    setFinishOnboardingStatus: (Boolean) -> Unit,
) {
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                text = stringResource(onboardingR.string.feature_onboarding_greeting),
                style = MaterialTheme.typography.titleMedium.copy(
                    fontFamily = FontFamily.Default
                ),
            )
            Text(
                text = "Dose Time",
                style = MaterialTheme.typography.headlineLarge.copy(
                    fontFamily = FontFamily.Serif
                ),
            )
            Spacer(modifier = Modifier.height(100.dp))
            Button(
                onClick = {
                    onClickGetStarted.invoke()
                    setFinishOnboardingStatus.invoke(true)
                },
                modifier = Modifier.padding(10.dp, 0.dp)
            ) {
                Text(text = stringResource(onboardingR.string.feature_onboarding_button_get_started))
            }
        }
    }
}

@ThemePreviews
@Composable
fun OnboardingScreenPreview() {
    DoseTimeTheme {
        OnboardingScreen(
            onClickGetStarted = {},
            setFinishOnboardingStatus = {}
        )
    }
}