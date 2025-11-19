package fr.outadoc.mastodonk.api.entity

import fr.outadoc.mastodonk.serializer.TimestampToInstantSerializer
import kotlin.time.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.collections.List

/**
 * Represents a user-defined filter for determining which statuses should not be shown to the user.
 */
@Serializable
public data class Filter(
    /**
     * The ID of the Filter in the database.
     */
    @SerialName("id")
    val id: String,

    /**
     * A title given by the user to name the filter.
     */
    @SerialName("title")
    val title: String,

    /**
     * The contexts in which the filter should be applied.
     */
    @SerialName("context")
    val context: List<FilterContext>,

    /**
     * When the filter should no longer be applied.
     * Null if the filter does not expire.
     */
    @SerialName("expires_at")
    @Serializable(with = TimestampToInstantSerializer::class)
    val expiresAt: Instant? = null,

    /**
     * The action to be taken when a status matches this filter.
     */
    @SerialName("filter_action")
    val filterAction: FilterAction,

    /**
     * The keywords grouped under this filter.
     * Omitted when part of a [FilterResult].
     */
    @SerialName("keywords")
    val keywords: List<FilterKeyword>? = null,

    /**
     * The statuses grouped under this filter.
     * Omitted when part of a [FilterResult].
     */
    @SerialName("statuses")
    val statuses: List<FilterStatus>? = null
)

/**
 * Contexts in which a filter can be applied.
 */
@Serializable
public enum class FilterContext(public val value: String) {
    /** Home timeline and lists. */
    @SerialName("home")
    HOME("home"),

    /** Notifications timeline. */
    @SerialName("notifications")
    NOTIFICATIONS("notifications"),

    /** Public timelines. */
    @SerialName("public")
    PUBLIC("public"),

    /** Expanded thread of a detailed status. */
    @SerialName("thread")
    THREAD("thread"),

    /** When viewing a profile. */
    @SerialName("account")
    ACCOUNT("account")
}

/**
 * Action to be taken when a status matches a filter.
 */
@Serializable
public enum class FilterAction(public val value: String) {
    /** Show a warning that identifies the matching filter by title, and allow the user to expand the filtered status. */
    @SerialName("warn")
    WARN("warn"),

    /** Do not show this status if it is received. */
    @SerialName("hide")
    HIDE("hide"),

    /** Hide/blur media attachments with a warning identifying the matching filter by title. */
    @SerialName("blur")
    BLUR("blur")
}
