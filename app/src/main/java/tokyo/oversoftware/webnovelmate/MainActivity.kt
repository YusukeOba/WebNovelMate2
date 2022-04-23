package tokyo.oversoftware.webnovelmate

import android.os.Bundle
import android.os.Handler
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import tokyo.oversoftware.webnovelmate.data.entities.Novel
import tokyo.oversoftware.webnovelmate.data.entities.NovelMeta
import tokyo.oversoftware.webnovelmate.databinding.ActivityMainBinding
import java.time.Instant.now
import java.util.*

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MessageText(viewModel)
        }

        Handler().postDelayed({
            viewModel.getNovels()
        }, 10000)
    }

    @Composable
    fun MessageText(viewModel: MainViewModel) {
        val novels = viewModel.novels.observeAsState().value
        Text(text = "Reading ${novels?.first()?.title}")
    }
}

class MainViewModel : ViewModel() {

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