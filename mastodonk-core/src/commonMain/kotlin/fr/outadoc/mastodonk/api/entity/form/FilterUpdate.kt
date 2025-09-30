package fr.outadoc.mastodonk.api.entity.form

import fr.outadoc.mastodonk.api.entity.Filter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A filter group to be updated.
 */
@Serializable
public data class FilterUpdate(
    /**
     * The name of the filter group.
     */
    @SerialName("title")
    val title: String? = null,

    /**
     * Where the filter should be applied.
     */
    @SerialName("context")
    val context: List<Filter.Context>? = null,

    /**
     * The policy to be applied when the filter is matched.
     */
    @SerialName("filter_action")
    val filterAction: Filter.Action? = null,

    /**
     * How many seconds from now should the filter expire?
     */
    @SerialName("expires_in")
    val expiresIn: Long? = null,

    /**
     * Keywords to be added to, updated in, or removed from the filter group.
     */
    @SerialName("keywords_attributes")
    val keywordsAttributes: List<FilterKeywordUpdate>? = null
)
