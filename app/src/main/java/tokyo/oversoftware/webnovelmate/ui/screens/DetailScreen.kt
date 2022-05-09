package tokyo.oversoftware.webnovelmate.ui.screens

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import tokyo.oversoftware.webnovelmate.commons.AppState
import tokyo.oversoftware.webnovelmate.commons.rememberAppState
import tokyo.oversoftware.webnovelmate.ui.custom.GeneralTopAppBar

@Composable
fun DetailScreen(appState: AppState) {
    Scaffold(
        scaffoldState = appState.scaffoldState,
        topBar = {
            GeneralTopAppBar(navController = appState.navController, title = "本棚", isModal = false)
        }
    ) {
        Button(onClick = {
            appState.navController.popBackStack()
        }) {
            Text(text = "go home")
        }
    }
}

@Preview
@Composable
fun PreviewDetailScreen() {
    DetailScreen(rememberAppState())
}
