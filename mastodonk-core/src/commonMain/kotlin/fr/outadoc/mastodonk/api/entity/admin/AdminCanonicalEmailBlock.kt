package fr.outadoc.mastodonk.api.entity.admin

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a canonical email block (hashed).
 */
@Serializable
public data class AdminCanonicalEmailBlock(
    /**
     * The ID of the email block in the database.
     */
    @SerialName("id")
    val id: String,

    /**
     * The SHA256 hash of the canonical email address.
     */
    @SerialName("canonical_email_hash")
    val canonicalEmailHash: String
)
