package fr.outadoc.mastodonk.api.entity

import fr.outadoc.mastodonk.serializer.TimestampToInstantSerializer
import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.collections.List

/**
 * Represents an announcement set by an administrator.
 */
@Serializable
public data class Announcement(

    @SerialName("id")
    val announcementId: String,

    /**
     * The content of the announcement.
     */
    @SerialName("text")
    val text: String,

    /**
     * Whether the announcement is currently active.
     * This field is maintained from the original class and might not directly map to the 'published_at' datetime field in the API documentation.
     */
    @SerialName("published")
    val isPublished: Boolean,

    /**
     * Whether the announcement has a start/end time.
     */
    @SerialName("all_day")
    val isAllDay: Boolean,

    /**
     * Moment at which the announcement was published.
     * Maps to "published_at" in the API.
     */
    @SerialName("published_at")
    @Serializable(with = TimestampToInstantSerializer::class)
    val createdAt: Instant,

    /**
     * Moment at which the announcement was last updated.
     */
    @SerialName("updated_at")
    @Serializable(with = TimestampToInstantSerializer::class)
    val updatedAt: Instant,

    /**
     * Whether the announcement has been read by the user.
     */
    @SerialName("read")
    val isRead: Boolean? = null,

    /**
     * Emoji reactions attached to the announcement.
     * Retains the original List<AnnouncementReaction> type.
     */
    @SerialName("reactions")
    val reactions: List<AnnouncementReaction>,

    /**
     * Time at which the announcement will start.
     */
    @SerialName("starts_at")
    @Serializable(with = TimestampToInstantSerializer::class)
    val startsAt: Instant? = null,

    /**
     * Time at which the announcement will end.
     */
    @SerialName("ends_at")
    @Serializable(with = TimestampToInstantSerializer::class)
    val endsAt: Instant? = null,

    /**
     * Accounts mentioned in the announcement text.
     */
    @SerialName("mentions")
    val mentions: List<AccountMention>? = null, // Making nullable for safety if not always present

    /**
     * Statuses linked in the announcement text.
     */
    @SerialName("statuses")
    val statuses: List<StatusMention>? = null, // Making nullable for safety if not always present

    /**
     * Tags linked in the announcement text.
     */
    @SerialName("tags")
    val tags: List<StatusTag>? = null, // Making nullable for safety if not always present

    /**
     * Custom emoji used in the announcement text.
     */
    @SerialName("emojis")
    val emojis: List<CustomEmoji>? = null // Making nullable for safety if not always present
) {
    /**
     * Represents an account mentioned in an announcement.
     */
    @Serializable
    public data class AccountMention(
        /** The account ID of the mentioned user. */
        @SerialName("id")
        val id: String,

        /** The username of the mentioned user. */
        @SerialName("username")
        val username: String,

        /** The location of the mentioned user's profile. */
        @SerialName("url")
        val url: String,

        /** The webfinger acct: URI of the mentioned user. */
        @SerialName("acct")
        val acct: String
    )

    /**
     * Represents a status linked in an announcement.
     */
    @Serializable
    public data class StatusMention(
        /** The ID of an attached Status in the database. */
        @SerialName("id")
        val id: String,

        /** The URL of an attached Status. */
        @SerialName("url")
        val url: String
    )
}
