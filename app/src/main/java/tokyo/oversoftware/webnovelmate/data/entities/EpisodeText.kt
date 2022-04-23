package tokyo.oversoftware.webnovelmate.data.entities

interface EpisodeText {

    val storeIdentifier: StoreIdentifier
    val episodeIdentifier: EpisodeIdentifier
    val text: String?

}