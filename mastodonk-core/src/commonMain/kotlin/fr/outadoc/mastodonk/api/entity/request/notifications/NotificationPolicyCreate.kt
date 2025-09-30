package fr.outadoc.mastodonk.api.entity.request.notifications

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a user's notification filtering policy to be updated.
 */
@Serializable
public data class NotificationPolicyCreate(
    /**
     * Whether to `accept`, `filter` or `drop` notifications from accounts the user is not following.
     */
    @SerialName("for_not_following")
    val forNotFollowing: String? = null,

    /**
     * Whether to `accept`, `filter` or `drop` notifications from accounts that are not following the user.
     */
    @SerialName("for_not_followers")
    val forNotFollowers: String? = null,

    /**
     * Whether to `accept`, `filter` or `drop` notifications from accounts created in the past 30 days.
     */
    @SerialName("for_new_accounts")
    val forNewAccounts: String? = null,

    /**
     * Whether to `accept`, `filter` or `drop` notifications from private mentions.
     */
    @SerialName("for_private_mentions")
    val forPrivateMentions: String? = null,

    /**
     * Whether to `accept`, `filter` or `drop` notifications from accounts that were limited by a moderator.
     */
    @SerialName("for_limited_accounts")
    val forLimitedAccounts: String? = null
)
