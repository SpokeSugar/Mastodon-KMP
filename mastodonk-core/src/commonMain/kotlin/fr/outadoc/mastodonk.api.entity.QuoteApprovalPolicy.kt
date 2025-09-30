package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Describes who is allowed to quote a status, used in the `quote_approval_policy` form data parameter
 * and reflected in the `automatic` and `manual` fields of the `QuoteApproval` entity.
 */
@Serializable
public enum class QuoteApprovalPolicy {
    /**
     * Anyone is allowed to quote this status.
     */
    @SerialName("public")
    Public,

    /**
     * Only followers and the author are allowed to quote this status.
     */
    @SerialName("followers")
    Followers,

    /**
     * Only the author is allowed to quote the status.
     */
    @SerialName("nobody")
    Nobody
}
