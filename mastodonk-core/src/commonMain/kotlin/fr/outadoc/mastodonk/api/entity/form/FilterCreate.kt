package fr.outadoc.mastodonk.api.entity.form

import fr.outadoc.mastodonk.api.entity.FilterAction
import fr.outadoc.mastodonk.api.entity.FilterContext
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A filter group to be created.
 */
@Serializable
public data class FilterCreate(
    /**
     * The name of the filter group.
     */
    @SerialName("title")
    val title: String,

    /**
     * Where the filter should be applied.
     */
    @SerialName("context")
    val context: List<FilterContext>,

    /**
     * The policy to be applied when the filter is matched.
     */
    @SerialName("filter_action")
    val filterAction: FilterAction? = null,

    /**
     * How many seconds from now should the filter expire?
     */
    @SerialName("expires_in")
    val expiresIn: Long? = null,

    /**
     * Keywords to be added to the newly-created filter group.
     */
    @SerialName("keywords_attributes")
    val keywordsAttributes: List<FilterKeywordCreate>? = null
)
