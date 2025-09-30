package fr.outadoc.mastodonk.api.entity

import fr.outadoc.mastodonk.api.entity.paging.Pageable
import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a notification of an event relevant to the user.
 */
@Serializable
public data class Notification(

    /**
     * The id of the notification in the database.
     */
    @SerialName("id")
    val notificationId: String,

    /**
     * The type of event that resulted in the notification.
     */
    @SerialName("type")
    val type: NotificationType,

    /**
     * Group key shared by similar notifications, to be used in the grouped notifications feature.
     * Should be considered opaque, but ungrouped notifications can be assumed to have a
     * `group_key` of the form `ungrouped-{notification_id}`.
     */
    @SerialName("group_key")
    val groupKey: String,

    /**
     * The timestamp of the notification.
     */
    @SerialName("created_at")
    val createdAt: Instant,

    /**
     * The account that performed the action that generated the notification.
     */
    @SerialName("account")
    val account: Account,

    /**
     * Status that was the object of the notification.
     * Attached when `type` of the notification is `favourite`, `reblog`, `status`,
     * `mention`, `poll`, `update`, `quote` or `quoted_update`.
     * In the case of `quoted_update`, your quote of the edited status is attached,
     * not the status that was edited.
     */
    @SerialName("status")
    val status: Status? = null,

    /**
     * Report that was the object of the notification.
     * Attached when `type` of the notification is `admin.report`.
     */
    @SerialName("report")
    val report: Report? = null,

    /**
     * Summary of the event that caused follow relationships to be severed.
     * Attached when `type` of the notification is `severed_relationships`.
     */
    @SerialName("event")
    val event: RelationshipSeveranceEvent? = null,

    /**
     * Moderation warning that caused the notification.
     * Attached when `type` of the notification is `moderation_warning`.
     */
    @SerialName("moderation_warning")
    val moderationWarning: AccountWarning? = null

) : Pageable {
    override val id: String
        get() = notificationId
}
