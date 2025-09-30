package fr.outadoc.mastodonk.api.entity.form

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A keyword to be updated in a filter group.
 */
@Serializable
public data class FilterKeywordUpdate(
    /**
     * The ID of the FilterKeyword in the database.
     */
    @SerialName("id")
    val id: String,

    /**
     * The keyword to be updated.
     */
    @SerialName("keyword")
    val keyword: String? = null,

    /**
     * Whether the keyword should consider word boundaries.
     */
    @SerialName("whole_word")
    val wholeWord: Boolean? = null,

    /**
     * If true, will remove the keyword with the given ID.
     */
    @SerialName("_destroy")
    val destroy: Boolean? = null
)
