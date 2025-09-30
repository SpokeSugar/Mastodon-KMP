package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Describes how a status' quote policy applies to the current user.
 */
@Serializable
public enum class CurrentUserQuotePolicy {
    /**
     * The requesting user is expected to be allowed to quote and have their quote be automatically accepted.
     */
    @SerialName("automatic")
    Automatic,

    /**
     * The requesting user is expected to be allowed to quote after manual review of the post by the quoted status' author.
     */
    @SerialName("manual")
    Manual,

    /**
     * The requesting user is not expected to be allowed to quote this post.
     */
    @SerialName("denied")
    Denied,

    /**
     * The user is not covered by the quote policies supported by Mastodon.
     */
    @SerialName("unknown")
    Unknown
}
