package fr.outadoc.mastodonk.api.entity

import kotlin.time.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.collections.List

/**
 * Represents a poll attached to a status.
 */
@Serializable
public data class Poll(

    /**
     * The ID of the poll in the database.
     */
    @SerialName("id")
    val pollId: String,

    /**
     * When the poll ends.
     * Null if the poll does not end.
     */
    @SerialName("expires_at")
    val expiresAt: Instant? = null,

    /**
     * Is the poll currently expired?
     */
    @SerialName("expired")
    val isExpired: Boolean,

    /**
     * Does the poll allow multiple-choice answers?
     */
    @SerialName("multiple")
    val allowsMultipleChoices: Boolean,

    /**
     * How many votes have been received.
     */
    @SerialName("votes_count")
    val votesCount: Long,

    /**
     * How many unique accounts have voted on a multiple-choice poll.
     * Null if `multiple` is false.
     */
    @SerialName("voters_count")
    val votersCount: Long? = null,

    /**
     * Possible answers for the poll.
     */
    @SerialName("options")
    val options: List<PollOption>,

    /**
     * Custom emoji to be used for rendering poll options.
     */
    @SerialName("emojis")
    val emojis: List<CustomEmoji>,

    /**
     * When called with a user token, has the authorized user voted?
     */
    @SerialName("voted")
    val hasVoted: Boolean? = null,

    /**
     * When called with a user token, which options has the authorized user chosen?
     * Contains an array of index values for `options`.
     */
    @SerialName("own_votes")
    val ownVotes: List<Int>? = null
)
