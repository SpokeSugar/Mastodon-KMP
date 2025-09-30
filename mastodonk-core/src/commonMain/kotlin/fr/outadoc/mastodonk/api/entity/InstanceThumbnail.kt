package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * An image used to represent this server.
 */
@Serializable
public data class InstanceThumbnail(
    /**
     * The URL for the thumbnail image.
     */
    @SerialName("url")
    val url: String,

    /**
     * A hash computed by the BlurHash algorithm.
     */
    @SerialName("blurhash")
    val blurhash: String? = null,

    /**
     * Links to scaled resolution images.
     */
    @SerialName("versions")
    val versions: InstanceThumbnailVersions? = null
)
