package tokyo.oversoftware.webnovelmate.data.entities

interface StoreIdentifier {
    fun match(storeIdentifier: StoreIdentifier): Boolean
}

interface Store {

    val identifier: StoreIdentifier

    val title: String

    val searchUrl: String?

    val rankingUrl: String?

}