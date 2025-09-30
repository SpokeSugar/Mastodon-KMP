package fr.outadoc.mastodonk.api.entity.v2

import fr.outadoc.mastodonk.api.entity.AccountWarning
import fr.outadoc.mastodonk.api.entity.Report
import fr.outadoc.mastodonk.api.entity.RelationshipSeveranceEvent
import fr.outadoc.mastodonk.api.entity.Status
import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName

/**
 * Represents a group of notifications.
 */
public data class NotificationGroup(
    /**
     * Group key identifying the grouped notifications.
     */
    @SerialName("group_key")
    public val groupKey: String,

    /**
     * Total number of individual notifications that are part of this notification group.
     */
    @SerialName("notifications_count")
    public val notificationsCount: Long,

    /**
     * The type of event that resulted in the notifications in this group.
     */
    @SerialName("type")
    public val type: String,

    /**
     * ID of the most recent notification in the group.
     */
    @SerialName("most_recent_notification_id")
    public val mostRecentNotificationId: String,

    /**
     * ID of the oldest notification from this group represented within the current page.
     */
    @SerialName("page_min_id")
    public val pageMinId: String? = null,

    /**
     * ID of the newest notification from this group represented within the current page.
     */
    @SerialName("page_max_id")
    public val pageMaxId: String? = null,

    /**
     * Date at which the most recent notification from this group within the current page has been created.
     */
    @SerialName("latest_page_notification_at")
    public val latestPageNotificationAt: Instant? = null,

    /**
     * IDs of some of the accounts who most recently triggered notifications in this group.
     */
    @SerialName("sample_account_ids")
    public val sampleAccountIds: List<String>,

    /**
     * ID of the [Status] that was the object of the notification.
     */
    @SerialName("status_id")
    public val statusId: String? = null,

    /**
     * Report that was the object of the notification.
     */
    @SerialName("report")
    public val report: Report? = null,

    /**
     * Summary of the event that caused follow relationships to be severed.
     */
    @SerialName("event")
    public val event: RelationshipSeveranceEvent? = null,

    /**
     * Moderation warning that caused the notification.
     */
    @SerialName("moderation_warning")
    public val moderationWarning: AccountWarning? = null
)
