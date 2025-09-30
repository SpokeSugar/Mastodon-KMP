package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a keyword used in a filter.
 */
@Serializable
public data class FilterKeyword(
    /**
     * The ID of the FilterKeyword in the database.
     */
    @SerialName("id")
    val id: String,

    /**
     * The keyword to be filtered.
     */
    @SerialName("keyword")
    val keyword: String,

    /**
     * Whether the keyword should match the whole word.
     */
    @SerialName("whole_word")
    val wholeWord: Boolean
)
