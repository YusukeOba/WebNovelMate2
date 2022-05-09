package tokyo.oversoftware.webnovelmate.data.entities

import java.util.*

interface EpisodeIdentifier {
    fun match(identifier: EpisodeIdentifier): Boolean
}

interface Episode {
    val storeIdentifier: StoreIdentifier
    val episodeIdentifier: EpisodeIdentifier
    val chapterName: String?
    val episodeName: String?
    val createdAt: Date?
    val updatedAt: Date?
    val url: String
}