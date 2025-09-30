package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents the privacy policy of the instance.
 */
@Serializable
public data class PrivacyPolicy(

    /**
     * A timestamp of when the privacy policy was last updated.
     */
    @SerialName("updated_at")
    val updatedAt: String,

    /**
     * The rendered HTML content of the privacy policy.
     */
    @SerialName("content")
    val content: String
)
