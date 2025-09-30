package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.collections.List

/**
 * Summary of a status' quote approval policy and how it applies to the requesting user.
 */
@Serializable
public data class QuoteApproval(

    /**
     * Describes who is expected to be able to quote that status and have the quote automatically authorized.
     */
    @SerialName("automatic")
    val automatic: List<QuoteApprovalPolicy>,

    /**
     * Describes who is expected to have their quotes of this status be manually reviewed by the author before being accepted.
     */
    @SerialName("manual")
    val manual: List<QuoteApprovalPolicy>,

    /**
     * Describes how this status' quote policy applies to the current user.
     */
    @SerialName("current_user")
    val currentUser: CurrentUserQuotePolicy
)
