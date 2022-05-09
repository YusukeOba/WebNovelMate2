package tokyo.oversoftware.webnovelmate.ui.screens

import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import tokyo.oversoftware.webnovelmate.commons.rememberAppState

@Composable
fun App() {
    val appState = rememberAppState()
    Scaffold(scaffoldState = appState.scaffoldState) {
        NavHost(navController = appState.navController, startDestination = "home") {
            composable("home") {
                HomeScreen(appState)
            }
            composable("detail") {
                DetailScreen(appState)
            }
        }
    }
}