package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a focal point in an image.
 *
 * @see [Official docs](https://docs.joinmastodon.org/entities/MediaAttachment/#focal-points)
 */
@Serializable
public data class FocalPoint(

    /**
     * The x coordinate of the focal point.
     *
     * Float, in [-1, 1].
     */
    @SerialName("x")
    val x: Float,

    /**
     * The y coordinate of the focal point.
     *
     * Float, in [-1, 1].
     */
    @SerialName("y")
    val y: Float
)
