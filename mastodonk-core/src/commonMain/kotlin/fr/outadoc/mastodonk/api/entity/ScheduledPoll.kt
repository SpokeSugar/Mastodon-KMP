package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.collections.List

/**
 * Represents a poll to be attached to a [ScheduledStatus].
 */
@Serializable
public data class ScheduledPoll(

    /**
     * The poll options to be used.
     */
    @SerialName("options")
    val options: List<String>,

    /**
     * How many seconds the poll should last before closing.
     */
    @SerialName("expires_in")
    val expiresInSeconds: Long,

    /**
     * Whether the poll allows multiple choices.
     */
    @SerialName("multiple")
    val allowsMultipleChoices: Boolean? = null,

    /**
     * Whether the poll should hide total votes until after voting has ended.
     */
    @SerialName("hide_totals")
    val hidesTotals: Boolean? = null
)
