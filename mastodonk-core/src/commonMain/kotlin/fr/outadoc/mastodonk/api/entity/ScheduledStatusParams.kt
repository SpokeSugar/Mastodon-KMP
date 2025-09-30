package fr.outadoc.mastodonk.api.entity

import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.collections.List
/**
 * Parameters for a [ScheduledStatus].
 */
@Serializable
public data class ScheduledStatusParams(

    /**
     * Text to be used as status content.
     */
    @SerialName("text")
    val text: String,

    /**
     * Poll to be attached to the status.
     */
    @SerialName("poll")
    val poll: ScheduledPoll? = null,

    /**
     * IDs of the MediaAttachments that will be attached to the status.
     */
    @SerialName("media_ids")
    val mediaIds: List<String>? = null,

    /**
     * Whether the status will be marked as sensitive.
     */
    @SerialName("sensitive")
    val isSensitive: Boolean? = null,

    /**
     * The text of the content warning or summary for the status.
     */
    @SerialName("spoiler_text")
    val spoilerText: String? = null,

    /**
     * The visibility that the status will have once it is posted.
     */
    @SerialName("visibility")
    val visibility: StatusVisibility? = null,

    /**
     * ID of the Status that will be replied to.
     */
    @SerialName("in_reply_to_id")
    val inReplyToId: String? = null,

    /**
     * The language that will be used for the status.
     */
    @SerialName("language")
    val language: String? = null,

    /**
     * When the status will be scheduled. This will be null because the status is only scheduled once.
     */
    @SerialName("scheduled_at")
    val scheduledAt: Instant? = null,

    /**
     * Idempotency key to prevent duplicate statuses.
     */
    @SerialName("idempotency")
    val idempotency: String? = null,

    /**
     * Internal ID of the Application that posted the status.
     */
    @Deprecated("Provided for historical compatibility only and can be ignored.")
    @SerialName("application_id")
    val applicationId: Long? = null,

    /**
     * Whether status creation is subject to rate limiting.
     */
    @Deprecated("Provided for historical compatibility only and can be ignored.")
    @SerialName("with_rate_limit")
    val withRateLimit: Boolean = false
)
