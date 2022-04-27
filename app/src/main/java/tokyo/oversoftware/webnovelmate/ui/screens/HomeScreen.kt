package tokyo.oversoftware.webnovelmate.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import tokyo.oversoftware.webnovelmate.data.entities.Novel
import tokyo.oversoftware.webnovelmate.data.entities.NovelMeta
import java.util.*

@Composable
fun HomeScreen(nav: NavController, homeViewModel: HomeViewModel = viewModel()) {
    val novels = homeViewModel.novels.observeAsState().value
    Column() {
        Text(text = "Reading ${novels?.first()?.title ?: "nothing"}")
        Button(onClick = {
            nav.navigate("detail")
        }) {
            Text(text = "go detail")
        }
    }

    LaunchedEffect(key1 = Unit) {
        homeViewModel.getNovels()
    }
}

class HomeViewModel : ViewModel() {

    private val _novels = MutableLiveData<List<Novel>>()
    val novels = _novels

    fun getNovels() {
        _novels.postValue(
            listOf(
                object : Novel {
                    override val meta: NovelMeta
                        get() = object : NovelMeta {
                            override fun match(meta: NovelMeta): Boolean {
                                return true
                            }
                        }
                    override val title: String
                        get() = "Test novel"
                    override val authors: List<String>
                        get() = listOf(
                            "Test Author"
                        )
                    override val updateAt: Date
                        get() = Date()
                    override val genre: List<String>
                        get() = listOf(
                            "サブカル"
                        )
                    override val outline: String
                        get() = "あらすじ"
                    override val episodeCount: Int
                        get() = 1
                    override val isComplete: Boolean
                        get() = true
                    override val tags: List<String>
                        get() = listOf(
                            "誰得"
                        )
                    override val url: String?
                        get() = "https://google.co.jp"
                    override val authorUrl: String?
                        get() = "https://goo.co.jp"
                    override val impressionUrl: String?
                        get() = "https://yahoo.co.jp"
                }
            )
        )
    }

}

@Preview
@Composable
fun PreviewHomeScreen() {
    HomeScreen(nav = rememberNavController())
}