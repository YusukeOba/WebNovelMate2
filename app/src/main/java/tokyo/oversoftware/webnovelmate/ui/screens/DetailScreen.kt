package tokyo.oversoftware.webnovelmate.ui.screens

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun DetailScreen(nav: NavController)  {
    Button(onClick = {
        nav.navigate("home")
    }) {
        Text(text = "go home")
    }
}

@Preview
@Composable
fun PReviewDetailScreen() {
    DetailScreen(nav = rememberNavController())
}
