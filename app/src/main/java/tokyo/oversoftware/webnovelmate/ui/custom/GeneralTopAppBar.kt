package tokyo.oversoftware.webnovelmate.ui.custom

import android.icu.text.CaseMap
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Remove
import androidx.compose.runtime.*
import androidx.navigation.NavController


@Composable
fun GeneralTopAppBar(navController: NavController, title: String, isModal: Boolean) {
    var canPop by remember { mutableStateOf(false) }
    navController.addOnDestinationChangedListener { controller, _, _ ->
        canPop = controller.previousBackStackEntry != null
    }
    TopAppBar(title = { Text(text = title) },
        navigationIcon = if (canPop) {
            {
                IconButton(onClick = { navController.navigateUp() }) {
                    Icon(
                        imageVector = if (isModal) {
                            Icons.Filled.Remove
                        } else {
                            Icons.Filled.ArrowBack
                        },
                        contentDescription = "Back"
                    )
                }
            }
        } else {
            null
        }
    )
}