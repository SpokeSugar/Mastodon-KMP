package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents the number of unread notifications.
 */
@Serializable
public data class UnreadCount(
    /**
     * The number of unread notifications.
     */
    @SerialName("count")
    val count: Long
)
