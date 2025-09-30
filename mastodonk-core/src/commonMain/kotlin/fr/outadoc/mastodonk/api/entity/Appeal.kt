package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents an appeal against a moderation action.
 */
@Serializable
public data class Appeal(
    /** Text of the appeal from the moderated account to the moderators. */
    @SerialName("text")
    val text: String,

    /** State of the appeal. */
    @SerialName("state")
    val state: AppealState
)
