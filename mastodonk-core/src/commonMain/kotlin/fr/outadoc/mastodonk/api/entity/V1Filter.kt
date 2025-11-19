package fr.outadoc.mastodonk.api.entity

import kotlin.time.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.collections.List

/**
 * Represents a user-defined filter for determining
 * which statuses should not be shown to the user.
 */
@Serializable
public data class V1Filter(

    @SerialName("id")
    val filterId: String,

    /**
     * The text to be filtered.
     */
    @SerialName("phrase")
    val phrase: String,

    /**
     * The contexts in which the filter should be applied.
     */
    @SerialName("context")
    val context: List<V1FilterContext>,

    /**
     * Should matching entities in home and notifications be dropped by the server?
     */
    @SerialName("irreversible")
    val isIrreversible: Boolean,

    /**
     * Should the filter consider word boundaries?
     *
     * @see [Filter docs](https://docs.joinmastodon.org/entities/filter/)
     */
    @SerialName("whole_word")
    val wholeWord: Boolean,

    /**
     * Time at which the filter should no longer be applied.
     */
    @SerialName("expires_at")
    val expiresAt: Instant?
)
