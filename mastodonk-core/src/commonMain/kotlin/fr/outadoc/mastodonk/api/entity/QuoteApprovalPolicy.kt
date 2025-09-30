package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Describes who is expected to be able to quote a status.
 */
@Serializable
public enum class QuoteApprovalPolicy {
    /**
     * Anybody is expected to be able to quote this status.
     */
    @SerialName("public")
    Public,

    /**
     * Followers are expected to be able to quote this status.
     */
    @SerialName("followers")
    Followers,

    /**
     * People followed by the author are expected to be able to quote this status.
     */
    @SerialName("following")
    Following,

    /**
     * The underlying quote policy is not supported by Mastodon.
     */
    @SerialName("unsupported_policy")
    UnsupportedPolicy
}
