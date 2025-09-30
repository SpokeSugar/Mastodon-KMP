package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Links to scaled resolution images for the instance thumbnail.
 */
@Serializable
public data class InstanceThumbnailVersions(
    /**
     * The URL for the thumbnail image at 1x resolution.
     */
    @SerialName("@1x")
    val x1: String? = null,

    /**
     * The URL for the thumbnail image at 2x resolution.
     */
    @SerialName("@2x")
    val x2: String? = null
)
