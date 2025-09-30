package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.collections.List

/**
 * Represents the poll options at a given revision of a status.
 */
@Serializable
public data class StatusEditPoll(

    /**
     * The poll options at this revision.
     */
    @SerialName("options")
    val options: List<StatusEditPollOption>
)