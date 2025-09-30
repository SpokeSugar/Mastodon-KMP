package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents the status of notification requests being merged.
 */
@Serializable
public data class RequestsMerged(

    /**
     * Whether the notifications have been merged and are ready for being loaded.
     */
    @SerialName("merged")
    val isMerged: Boolean
)
