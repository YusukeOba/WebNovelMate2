package tokyo.oversoftware.webnovelmate.ui.screens

import android.content.res.Resources
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Details
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.google.android.material.snackbar.BaseTransientBottomBar
import tokyo.oversoftware.webnovelmate.commons.AppTheme
import tokyo.oversoftware.webnovelmate.commons.rememberAppState

sealed class Screen(
    val route: String,
    val title: String,
    val icon: ImageVector,
    val shownBottomBar: Boolean
) {
    object Home : Screen("home", "home", Icons.Filled.Home, true)
    object Detail : Screen("detail", "detail", Icons.Filled.Details, false)
}

val bottomTabs = mapOf(
    Pair(Screen.Home.route, Screen.Home),
)

@Composable
fun App() {
    val appState = rememberAppState()
    AppTheme {
        Scaffold(scaffoldState = appState.scaffoldState,
            bottomBar = {
                val navBackStackEntry by appState.navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                val isShownBottomBar =
                    bottomTabs[currentDestination?.route]?.shownBottomBar ?: false
                if (isShownBottomBar) {
                    BottomNavigation {
                        bottomTabs.forEach { screen ->
                            BottomNavigationItem(
                                icon = {
                                    Icon(screen.value.icon, contentDescription = null)
                                },
                                label = { Text(text = screen.value.title) },
                                selected = currentDestination?.hierarchy?.any { it.route == screen.value.route } == true,
                                onClick = {
                                    appState.navController.navigate(screen.value.route) {
                                        popUpTo(appState.navController.graph.findStartDestination().id) {
                                            saveState = true
                                        }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                })
                        }
                    }
                }
            }
        ) {
            NavHost(
                navController = appState.navController,
                startDestination = Screen.Home.route,
                Modifier.padding(it)
            ) {
                composable(Screen.Home.route) {
                    HomeScreen(appState)
                }
                composable(Screen.Detail.route) {
                    DetailScreen(appState)
                }
            }
        }
    }
}