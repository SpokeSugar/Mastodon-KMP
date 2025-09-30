package fr.outadoc.mastodonk.api.entity.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Parameters for editing an existing status.
 */
@Serializable
public data class StatusEditRequest(

    @SerialName("status")
    val status: String? = null,

    @SerialName("spoiler_text")
    val spoilerText: String? = null,

    @SerialName("sensitive")
    val sensitive: Boolean? = null,

    @SerialName("language")
    val language: String? = null,

    @SerialName("media_ids")
    val mediaIds: List<String>? = null,

    /**
     * When using a JSON request body, this is typically an array of objects.
     * Each object contains `id`, and optionally `description` and `focus`.
     */
    @SerialName("media_attributes")
    val mediaAttributes: List<MediaAttributeUpdate>? = null,

    @SerialName("poll")
    val poll: PollParameters? = null,

    /**
     * Use the raw string value for QuoteApprovalPolicy as per API.
     * The enum `QuoteApprovalPolicy` can be used by the calling code to provide valid values.
     */
    @SerialName("quote_approval_policy")
    val quoteApprovalPolicy: String? = null
)
