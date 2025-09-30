package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a user's notification filtering policy.
 */
@Serializable
public data class NotificationPolicy(

    /**
     * Whether to `accept`, `filter` or `drop` notifications from accounts the user is not following.
     */
    @SerialName("for_not_following")
    val forNotFollowing: String,

    /**
     * Whether to `accept`, `filter` or `drop` notifications from accounts that are not following the user.
     */
    @SerialName("for_not_followers")
    val forNotFollowers: String,

    /**
     * Whether to `accept`, `filter` or `drop` notifications from accounts created in the past 30 days.
     */
    @SerialName("for_new_accounts")
    val forNewAccounts: String,

    /**
     * Whether to `accept`, `filter` or `drop` notifications from private mentions.
     */
    @SerialName("for_private_mentions")
    val forPrivateMentions: String,

    /**
     * Whether to `accept`, `filter` or `drop` notifications from accounts that were limited by a moderator.
     */
    @SerialName("for_limited_accounts")
    val forLimitedAccounts: String,

    /**
     * Summary of the policy's effects.
     */
    @SerialName("summary")
    val summary: Summary
) {
    /**
     * Summary of the effects of a [NotificationPolicy].
     */
    @Serializable
    public data class Summary(

        /**
         * The number of pending notification requests.
         */
        @SerialName("pending_requests_count")
        val pendingRequestsCount: Long,

        /**
         * The number of pending notifications.
         */
        @SerialName("pending_notifications_count")
        val pendingNotificationsCount: Long
    )
}
