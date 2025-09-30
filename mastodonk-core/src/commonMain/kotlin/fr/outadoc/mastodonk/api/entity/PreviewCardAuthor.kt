package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents an author in a rich preview card.
 */
@Serializable
public data class PreviewCardAuthor(

    /**
     * The original resource author's name.
     */
    @SerialName("name")
    val name: String,

    /**
     * A link to the author of the original resource.
     */
    @SerialName("url")
    val url: String,

    /**
     * The fediverse account of the author.
     */
    @SerialName("account")
    val account: Account? = null
)
