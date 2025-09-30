package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents the results of a search. (API v2)
 */
@Serializable
public data class Search(

    /**
     * Accounts found matching the search query.
     */
    @SerialName("accounts")
    val accounts: List<Account>,

    /**
     * Statuses found matching the search query.
     */
    @SerialName("statuses")
    val statuses: List<Status>,

    /**
     * Hashtags found matching the search query.
     */
    @SerialName("hashtags")
    val hashtags: List<Tag>
)
