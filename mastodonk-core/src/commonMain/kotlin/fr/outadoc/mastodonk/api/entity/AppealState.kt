package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents the state of an appeal.
 */
@Serializable
public enum class AppealState {
    /** The appeal has been approved by a moderator. */
    @SerialName("approved")
    APPROVED,

    /** The appeal has been rejected by a moderator. */
    @SerialName("rejected")
    REJECTED,

    /** The appeal has been submitted, but neither approved nor rejected yet. */
    @SerialName("pending")
    PENDING
}
