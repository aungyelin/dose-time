package dev.yelinaung.dosetime.feature.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import dev.yelinaung.dosetime.core.designsystem.component.DoseToolBar
import dev.yelinaung.dosetime.feature.main.navigation.MainNavHost
import kotlin.reflect.KClass

@Composable
fun MainScreen() {
    val mainScreenState = rememberMainScreenState()
    val tabLevelDestinations = mainScreenState.tabLevelDestinations

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            DoseToolBar(
                navigationItems = {
                    tabLevelDestinations.forEach {
                        val selected = mainScreenState.currentDestination.isRouteInHierarchy(
                            it.route
                        )
                        NavigationBarItem(
                            selected = selected,
                            onClick = {
                                mainScreenState.navigateToTabLevelDestination(it)
                            },
                            icon = {
                                if (selected) {
                                    Icon(it.selectedIcon, contentDescription = null)
                                } else {
                                    Icon(it.unselectedIcon, contentDescription = null)
                                }
                            },
                            modifier = Modifier,
                            label = { Text(text = stringResource(it.titleTextId)) },
                        )
                    }
                }
            )
        },
    ) {
        MainNavHost(
            mainScreenState = mainScreenState,
            tabLevelDestinations = tabLevelDestinations,
            modifier = Modifier.padding(it)
        )
    }
}

private fun NavDestination?.isRouteInHierarchy(route: KClass<*>) =
    this?.hierarchy?.any {
        it.hasRoute(route)
    } ?: false