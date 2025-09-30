package fr.outadoc.mastodonk.api.entity.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Parameters for a poll when creating or editing a status.
 */
@Serializable
public data class PollParameters(

    /**
     * Possible answers to the poll.
     */
    @SerialName("options")
    val options: List<String>,

    /**
     * Duration that the poll should be open, in seconds.
     */
    @SerialName("expires_in")
    val expiresIn: Int,

    /**
     * Allow multiple choices? Defaults to false.
     */
    @SerialName("multiple")
    val multiple: Boolean? = null,

    /**
     * Hide vote counts until the poll ends? Defaults to false.
     */
    @SerialName("hide_totals")
    val hideTotals: Boolean? = null
)
