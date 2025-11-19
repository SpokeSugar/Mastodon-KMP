package fr.outadoc.mastodonk.api.entity.admin

import kotlin.time.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents an IP address range that cannot be used to sign up.
 */
@Serializable
public data class AdminIpBlock(
    /**
     * The ID of the IpBlock in the database.
     */
    @SerialName("id")
    val id: String,

    /**
     * The IP address range that is blocked.
     */
    @SerialName("ip")
    val ip: String,

    /**
     * The associated policy with this IP block.
     */
    @SerialName("severity")
    val severity: Severity,

    /**
     * The recorded reason for this IP block.
     */
    @SerialName("comment")
    val comment: String,

    /**
     * When the IP block was created.
     */
    @SerialName("created_at")
    val createdAt: Instant,

    /**
     * When the IP block will expire.
     */
    @SerialName("expires_at")
    val expiresAt: Instant? = null
) {
    /**
     * The policy to be applied by an IP block.
     */
    @Serializable
    public enum class Severity {
        /**
         * Any signup from this IP range will create a pending account.
         */
        @SerialName("sign_up_requires_approval")
        SignUpRequiresApproval,

        /**
         * Any signup from this IP range will be rejected.
         */
        @SerialName("sign_up_block")
        SignUpBlock,

        /**
         * Any activity from this IP range will be rejected entirely.
         */
        @SerialName("no_access")
        NoAccess
    }
}
