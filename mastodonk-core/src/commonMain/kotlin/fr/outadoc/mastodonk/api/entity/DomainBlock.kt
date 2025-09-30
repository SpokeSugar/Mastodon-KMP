package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a domain that is blocked by the instance.
 */
@Serializable
public data class DomainBlock(
    /**
     * The domain which is blocked. This may be obfuscated or partially censored.
     */
    @SerialName("domain")
    val domain: String,

    /**
     * The SHA256 hash digest of the domain string.
     */
    @SerialName("digest")
    val digest: String,

    /**
     * The level to which the domain is blocked.
     */
    @SerialName("severity")
    val severity: DomainBlockSeverity,

    /**
     * An optional reason for the domain block.
     */
    @SerialName("comment")
    val comment: String? = null
)

