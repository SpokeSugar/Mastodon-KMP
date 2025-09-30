package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Hints related to contacting a representative of the website.
 */
@Serializable
public data class InstanceContact(
    /**
     * An email address that can be messaged regarding inquiries or issues.
     */
    @SerialName("email")
    val email: String,

    /**
     * An account that can be contacted natively over the network regarding inquiries or issues.
     */
    @SerialName("account")
    val account: Account? = null
)
