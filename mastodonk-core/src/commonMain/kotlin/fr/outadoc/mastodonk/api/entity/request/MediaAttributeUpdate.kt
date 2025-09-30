package fr.outadoc.mastodonk.api.entity.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Parameters for updating attributes of a media attachment when editing a status.
 */
@Serializable
public data class MediaAttributeUpdate(

    /**
     * The ID of the media attachment to be updated.
     */
    @SerialName("id")
    val id: String,

    /**
     * A new description for the media attachment.
     */
    @SerialName("description")
    val description: String? = null,

    /**
     * New focal point for the media attachment.
     * Represented as a nested object.
     */
    @SerialName("focus")
    val focus: FocusPoint? = null
) {
    /**
     * Represents the x and y coordinates of a focal point.
     */
    @Serializable
    public data class FocusPoint(
        @SerialName("x")
        val x: Float,
        @SerialName("y")
        val y: Float
    )
}
