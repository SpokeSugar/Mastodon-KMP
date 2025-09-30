package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.collections.List

/**
 * Represents a filter whose keywords matched a given status.
 */
@Serializable
public data class FilterResult(
    /**
     * The filter that was matched.
     */
    @SerialName("filter")
    val filter: Filter,

    /**
     * The keyword within the filter that was matched.
     * Null if no keyword was matched.
     */
    @SerialName("keyword_matches")
    val keywordMatches: List<String>? = null,

    /**
     * The status ID within the filter that was matched.
     * Null if no status ID was matched.
     */
    @SerialName("status_matches")
    val statusMatches: List<String>? = null
)
