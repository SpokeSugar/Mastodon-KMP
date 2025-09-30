package fr.outadoc.mastodonk.api.entity.request

import fr.outadoc.mastodonk.api.entity.QuoteApprovalPolicy
import fr.outadoc.mastodonk.api.entity.StatusVisibility
import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Parameters for creating a new status.
 */
@Serializable
public data class StatusCreate(

    @SerialName("status")
    val status: String? = null,

    @SerialName("media_ids")
    val mediaIds: List<String>? = null,

    @SerialName("poll")
    val poll: PollParameters? = null,

    @SerialName("in_reply_to_id")
    val inReplyToId: String? = null,

    @SerialName("sensitive")
    val sensitive: Boolean? = null,

    @SerialName("spoiler_text")
    val spoilerText: String? = null,

    @SerialName("visibility")
    val visibility: StatusVisibility? = null,

    @SerialName("language")
    val language: String? = null,

    @SerialName("scheduled_at")
    val scheduledAt: Instant? = null,

    @SerialName("quoted_status_id")
    val quotedStatusId: String? = null,

    /**
     * Use the raw string value for QuoteApprovalPolicy as per API.
     * The enum itself can be used by the calling code to provide valid values.
     */
    @SerialName("quote_approval_policy")
    val quoteApprovalPolicy: String? = null
)
