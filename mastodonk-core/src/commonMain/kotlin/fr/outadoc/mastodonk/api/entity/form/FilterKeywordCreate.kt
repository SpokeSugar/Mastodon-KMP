package fr.outadoc.mastodonk.api.entity.form

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A keyword to be added to a filter group.
 */
@Serializable
public data class FilterKeywordCreate(
    /**
     * The keyword to be added to the filter group.
     */
    @SerialName("keyword")
    val keyword: String,

    /**
     * Whether the keyword should consider word boundaries.
     */
    @SerialName("whole_word")
    val wholeWord: Boolean? = null
)
