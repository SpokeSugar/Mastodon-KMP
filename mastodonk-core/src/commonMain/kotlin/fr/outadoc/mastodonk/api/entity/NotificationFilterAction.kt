package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Defines the action to take for notifications based on a filter policy.
 */
@Serializable
public enum class NotificationFilterAction(public val value: String) {
    /** Accept the notification without filtering. */
    @SerialName("accept")
    ACCEPT("accept"),

    /** Mark the notification as filtered. */
    @SerialName("filter")
    FILTER("filter"),

    /** Prevent creation of the notification object. */
    @SerialName("drop")
    DROP("drop")
}
