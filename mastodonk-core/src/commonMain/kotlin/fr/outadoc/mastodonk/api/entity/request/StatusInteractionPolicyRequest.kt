package fr.outadoc.mastodonk.api.entity.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Parameters for editing a status's interaction policies.
 */
@Serializable
public data class StatusInteractionPolicyRequest(

    /**
     * Sets who is allowed to quote the status.
     * Use the raw string value for QuoteApprovalPolicy as per API.
     * The enum `QuoteApprovalPolicy` can be used by the calling code to provide valid values.
     */
    @SerialName("quote_approval_policy")
    val quoteApprovalPolicy: String
)
