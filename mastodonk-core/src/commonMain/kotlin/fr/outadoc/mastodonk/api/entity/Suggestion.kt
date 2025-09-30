package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.collections.List

/**
 * Represents a suggested account to follow and an associated reason for the suggestion.
 */
@Serializable
public data class Suggestion(

    /**
     * The reason this account is being suggested.
     */
    @Deprecated("Replaced by sources", replaceWith = ReplaceWith("sources"))
    @SerialName("source")
    val source: SuggestionSource? = null,

    /**
     * A list of reasons this account is being suggested.
     */
    @SerialName("sources")
    val sources: List<SuggestionSource>? = null,

    /**
     * The account being recommended to follow.
     */
    @SerialName("account")
    val account: Account
)
