package fr.outadoc.mastodonk.api.entity

import fr.outadoc.mastodonk.api.entity.paging.Pageable
import fr.outadoc.mastodonk.serializer.TimestampToInstantSerializer
import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.collections.List

/**
 * Represents a status that will be published at a future scheduled date.
 */
@Serializable
public data class ScheduledStatus(

    @SerialName("id")
    val statusId: String,

    /**
     * The timestamp for when the status will be posted.
     */
    @SerialName("scheduled_at")
    @Serializable(with = TimestampToInstantSerializer::class)
    val scheduledAt: Instant,

    /**
     * The parameters that were used when scheduling the status, to be used when the status is posted.
     */
    @SerialName("params")
    val params: ScheduledStatusParams,

    /**
     * Media that will be attached when the status is posted.
     */
    @SerialName("media_attachments")
    val attachments: List<MediaAttachment>
) : Pageable {

    override val id: String
        get() = statusId
}

/**
 * Parameters for a scheduled status, reflecting the structure from the API example.
 */
@Serializable
public data class ScheduledStatusParams(

    @SerialName("text")
    val text: String,

    /**
     * Poll parameters, if a poll is part of the scheduled status.
     */
    @SerialName("poll")
    val poll: ParamsPoll? = null,

    @SerialName("media_ids")
    val mediaIds: List<String>? = null,

    @SerialName("sensitive")
    val sensitive: Boolean? = null,

    @SerialName("visibility")
    val visibility: String? = null, // Or StatusVisibility, but String? is also acceptable

    @SerialName("idempotency")
    val idempotency: String? = null,

    /**
     * This is params.scheduled_at from the API response.
     */
    @SerialName("scheduled_at")
    @Serializable(with = TimestampToInstantSerializer::class)
    val scheduledAtInstant: Instant? = null, // Renamed to avoid conflict if `scheduled_at` becomes a string

    @SerialName("spoiler_text")
    val spoilerText: String? = null,

    @SerialName("application_id")
    val applicationId: Long,

    @SerialName("in_reply_to_id")
    val inReplyToId: String? = null
)

/**
 * Represents the poll object within ScheduledStatusParams.
 * This should mirror the structure of parameters needed to define a poll.
 */
@Serializable
public data class ParamsPoll(
    @SerialName("options")
    val options: List<String>,

    @SerialName("expires_in")
    val expiresIn: Int,

    @SerialName("multiple")
    val multiple: Boolean? = null,

    @SerialName("hide_totals")
    val hideTotals: Boolean? = null
)

// Reminder: MediaAttachment.kt is assumed to be correctly defined and imported.
