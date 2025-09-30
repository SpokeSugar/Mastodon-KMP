package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Machine-readable API version information.
 */
@Serializable
public data class InstanceApiVersions(
    /**
     * API version number that increments with substantial API changes.
     */
    @SerialName("mastodon")
    val mastodon: Int
    // Other implementations may have additional attributes here
)
