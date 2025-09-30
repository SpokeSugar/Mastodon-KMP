package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a poll option at a given revision of a status.
 */
@Serializable
public data class StatusEditPollOption(

    /**
     * The text for a poll option.
     */
    @SerialName("title")
    val title: String
)