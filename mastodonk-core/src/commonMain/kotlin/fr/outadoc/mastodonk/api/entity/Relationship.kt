package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.collections.List

/**
 * Represents the relationship between accounts.
 */
@Serializable
public data class Relationship(

    /**
     * The account ID.
     */
    @SerialName("id")
    val accountId: String,

    /**
     * Are you following this user?
     */
    @SerialName("following")
    val isFollowing: Boolean,

    /**
     * Are you receiving this user's boosts in your home timeline?
     */
    @SerialName("showing_reblogs")
    val isShowingBoosts: Boolean,

    /**
     * Have you enabled notifications for this user?
     */
    @SerialName("notifying")
    val isNotifying: Boolean,

    /**
     * Which languages are you following from this user?
     */
    @SerialName("languages")
    val languages: List<String>? = null,

    /**
     * Are you followed by this user?
     */
    @SerialName("followed_by")
    val isFollowedBy: Boolean,

    /**
     * Are you blocking this user?
     */
    @SerialName("blocking")
    val isBlocking: Boolean,

    /**
     * Is this user blocking you?
     */
    @SerialName("blocked_by")
    val isBlockedBy: Boolean,

    /**
     * Are you muting this user?
     */
    @SerialName("muting")
    val isMuting: Boolean,

    /**
     * Are you muting notifications from this user?
     */
    @SerialName("muting_notifications")
    val isMutingNotifications: Boolean,

    /**
     * Do you have a pending follow request for this user?
     */
    @SerialName("requested")
    val hasPendingFollowRequest: Boolean,

    /**
     * Has this user requested to follow you?
     */
    @SerialName("requested_by")
    val isRequestedBy: Boolean? = null,

    /**
     * Are you blocking this user's domain?
     */
    @SerialName("domain_blocking")
    val isDomainBlocking: Boolean,

    /**
     * Are you featuring this user on your profile?
     */
    @SerialName("endorsed")
    val isFeatured: Boolean,

    /**
     * This user's profile bio.
     */
    @SerialName("note")
    val note: String
)
