package tokyo.oversoftware.webnovelmate.commons

import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

data class AppState(
    val scaffoldState: ScaffoldState,
    val navController: NavHostController
)

@Composable
fun rememberAppState(
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    navController: NavHostController = rememberNavController()
) = remember(
    scaffoldState, navController
) {
    AppState(scaffoldState = scaffoldState, navController = navController)
}