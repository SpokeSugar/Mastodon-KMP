package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents the application used to post a status.
 */
@Serializable
public data class StatusApplication(

    /**
     * The name of the application.
     */
    @SerialName("name")
    val name: String,

    /**
     * The website associated with the application.
     */
    @SerialName("website")
    val website: String? = null
)
