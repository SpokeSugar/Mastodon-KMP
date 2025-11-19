package fr.outadoc.mastodonk.api.entity

import fr.outadoc.mastodonk.serializer.TimestampToInstantSerializer
import kotlin.time.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.time.ExperimentalTime

/**
 * Represents a notification request for a user.
 */
@Serializable
public data class NotificationRequest @OptIn(ExperimentalTime::class) constructor(
    /**
     * The notification request ID.
     */
    @SerialName("id")
    val id: String,

    /**
     * The timestamp of the notification request.
     */
    @SerialName("created_at")
    @Serializable(with = TimestampToInstantSerializer::class)
    val createdAt: Instant,

    /**
     * The timestamp of the last update.
     */
    @SerialName("updated_at")
    @Serializable(with = TimestampToInstantSerializer::class)
    val updatedAt: Instant,

    /**
     * The number of notifications for this request.
     */
    @SerialName("notifications_count")
    val notificationsCount: Long,

    /**
     * The account that sent the notification.
     */
    @SerialName("account")
    val account: Account,

    /**
     * The last status associated with this notification request.
     */
    @SerialName("last_status")
    val lastStatus: Status
)
