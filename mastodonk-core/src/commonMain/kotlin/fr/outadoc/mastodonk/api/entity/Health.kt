package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName

/**
 * Represents the health status of the Mastodon instance.
 */
public data class Health(
    /**
     * The health status.
     */
    @SerialName("status")
    public val status: String
)
