package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Limits related to accounts.
 */
@Serializable
public data class V1InstanceConfigurationAccounts(
    /**
     * The maximum number of featured tags allowed for each account.
     */
    @SerialName("max_featured_tags")
    val maxFeaturedTags: Int
)
