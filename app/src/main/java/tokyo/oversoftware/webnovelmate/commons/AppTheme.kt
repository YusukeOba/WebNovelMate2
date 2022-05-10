package tokyo.oversoftware.webnovelmate.commons

import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalInspectionMode
import com.google.accompanist.systemuicontroller.rememberSystemUiController

val skyColor = Color(0xFF5CBDF6)
val grey = Color(0xFFF3F3F3)
val pink = Color(0xFFFF7AAA)

private val lightColors = lightColors(
    primary = skyColor,
    primaryVariant = skyColor,
    secondary = pink,
    background = grey
)

@Composable
fun AppTheme(content: @Composable () -> Unit) {
    if (!LocalInspectionMode.current) {
        val systemUiController = rememberSystemUiController()
        SideEffect {
            systemUiController.setSystemBarsColor(
                color = lightColors.primaryVariant,
            )
        }
    }
    MaterialTheme(
        colors = lightColors,
        content = content
    )
}
