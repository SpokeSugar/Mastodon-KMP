package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Limits related to accounts, as part of the instance configuration.
 */
@Serializable
public data class InstanceConfigurationAccounts(
    /**
     * The maximum number of featured tags allowed for each account.
     */
    @SerialName("max_featured_tags")
    val maxFeaturedTags: Int,

    /**
     * The maximum number of pinned statuses for each account.
     */
    @SerialName("max_pinned_statuses")
    val maxPinnedStatuses: Int? = null // Field added in 4.3.0
)
