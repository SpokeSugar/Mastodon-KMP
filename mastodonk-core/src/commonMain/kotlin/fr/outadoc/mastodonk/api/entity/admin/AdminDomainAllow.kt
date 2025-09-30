package fr.outadoc.mastodonk.api.entity.admin

import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a domain allowed to federate.
 */
@Serializable
public data class AdminDomainAllow(
    /**
     * The ID of the DomainAllow in the database.
     */
    @SerialName("id")
    val id: String,

    /**
     * The domain that is allowed to federate.
     */
    @SerialName("domain")
    val domain: String,

    /**
     * When the domain was allowed to federate.
     */
    @SerialName("created_at")
    val createdAt: Instant
)
