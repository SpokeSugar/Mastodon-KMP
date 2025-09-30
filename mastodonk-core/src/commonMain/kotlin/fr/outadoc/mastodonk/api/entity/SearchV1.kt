package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents the results of a search. (API v1)
 * In v1, hashtags was an array of strings.
 */
@Serializable
public data class SearchV1(

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
     * Hashtags found matching the search query. (Array of strings in v1)
     */
    @SerialName("hashtags")
    val hashtags: List<String>
)
