package tokyo.oversoftware.webnovelmate.data.entities

interface NovelParser {

    /**
     * 指定URLに小説IDがあるかどうか
     */
    fun hasNovel(url: String): List<NovelMeta>

    /**
     * 小説IDから小説概要を取得
     */
    fun searchNovels(novelMetas: List<NovelMeta>): List<Novel>

    /**
     * 小説概要からエピソードを取得
     */
    fun searchEpisode(novels: List<Novel>): List<Episode>

    /**
     * エピソードから本文を取得
     */
    fun searchEpisodeText(episodes: List<Episode>): EpisodeText

}