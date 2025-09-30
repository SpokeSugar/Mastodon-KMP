package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a hashtag used within the content of a status.
 */
@Serializable
public data class StatusTag(

    /**
     * The value of the hashtag after the # sign.
     */
    @SerialName("name")
    val name: String,

    /**
     * A link to the hashtag on the instance.
     */
    @SerialName("url")
    val url: String
)
