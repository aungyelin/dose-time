package dev.yelinaung.dosetime

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import dagger.hilt.android.AndroidEntryPoint
import dev.yelinaung.dosetime.core.model.UserData
import dev.yelinaung.dosetime.ui.DoseTimeApp
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainActivityVM by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        splashScreen.setKeepOnScreenCondition { viewModel.uiState.value is MainActivityUiState.Loading }

        setContent {
            val isOnboarded = rememberSaveable { mutableStateOf<Boolean?>(null) }

            LaunchedEffect(Unit) {
                viewModel.uiState
                    .filter { it is MainActivityUiState.Success }
                    .map { (it as MainActivityUiState.Success).userData.finishedOnboarding }
                    .onEach { isOnboarded.value = it }
                    .first()
            }

            isOnboarded.value?.let {
                DoseTimeApp(it)
            }
        }
    }

}