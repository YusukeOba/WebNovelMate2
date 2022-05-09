package tokyo.oversoftware.webnovelmate.data.entities

import java.util.*

interface NovelMeta {
    fun match(meta: NovelMeta): Boolean
}

interface Novel {
    val meta: NovelMeta
    val title: String
    val authors: List<String>
    val updateAt: Date
    val genre: List<String>
    val outline: String
    val episodeCount: Int
    val isComplete: Boolean
    val tags: List<String>
    val url: String?
    val authorUrl: String?
    val impressionUrl: String?
}