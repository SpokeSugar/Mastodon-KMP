package fr.outadoc.mastodonk.api.entity

import fr.outadoc.mastodonk.api.entity.paging.Pageable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.collections.List

/**
 * Represents a hashtag used within the content of a status.
 */
@Serializable
public data class Tag(

    /**
     * ID of the hashtag in the database.
     */
    @SerialName("id")
    val tagId: String? = null,

    /**
     * The value of the hashtag after the # sign.
     */
    @SerialName("name")
    val name: String,

    /**
     * A link to the hashtag on the instance.
     */
    @SerialName("url")
    val url: String,

    /**
     * Usage statistics for given days.
     */
    @SerialName("history")
    val history: List<History>? = null,

    /**
     * Whether the current user is following this tag.
     */
    @SerialName("following")
    val isFollowing: Boolean? = null,

    /**
     * Whether the current user is featuring this tag on their profile.
     */
    @SerialName("featuring")
    val isFeaturing: Boolean? = null,

    /**
     * Whether the hashtag has been approved to trend.
     */
    @SerialName("trendable")
    val isTrendable: Boolean? = null,

    /**
     * Whether the hashtag has not been disabled from auto-linking.
     */
    @SerialName("usable")
    val isUsable: Boolean? = null,

    /**
     * Whether the hashtag has not been reviewed yet to approve or deny its trending.
     */
    @SerialName("requires_review")
    val requiresReview: Boolean? = null

) : Pageable {

    override val id: String
        get() = tagId ?: name
}
