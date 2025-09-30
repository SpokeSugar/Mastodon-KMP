package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Summary of filtered notifications.
 */
@Serializable
public data class NotificationPolicySummary(
    /**
     * Number of different accounts from which the user has non-dismissed filtered notifications.
     * Capped at 100.
     */
    @SerialName("pending_requests_count")
    val pendingRequestsCount: Int,

    /**
     * Number of total non-dismissed filtered notifications.
     * May be inaccurate.
     */
    @SerialName("pending_notifications_count")
    val pendingNotificationsCount: Int
)
