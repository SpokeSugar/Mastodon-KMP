package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a size variant for the server's configured icon.
 */
@Serializable
public data class InstanceIcon(
    /**
     * The URL of this icon.
     */
    @SerialName("src")
    val src: String,

    /**
     * The size of this icon (e.g., "36x36").
     */
    @SerialName("size")
    val size: String
)
