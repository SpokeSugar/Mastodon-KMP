package fr.outadoc.mastodonk.api.entity.admin

import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a domain limited from federating.
 */
@Serializable
public data class AdminDomainBlock(
    /**
     * The ID of the DomainBlock in the database.
     */
    @SerialName("id")
    val id: String,

    /**
     * The domain that is not allowed to federate.
     */
    @SerialName("domain")
    val domain: String,

    /**
     * The sha256 hex digest of the domain that is not allowed to federated.
     */
    @SerialName("digest")
    val digest: String,

    /**
     * When the domain was blocked from federating.
     */
    @SerialName("created_at")
    val createdAt: Instant,

    /**
     * The policy to be applied by this domain block.
     */
    @SerialName("severity")
    val severity: Severity,

    /**
     * Whether to reject media attachments from this domain.
     */
    @SerialName("reject_media")
    val rejectMedia: Boolean,

    /**
     * Whether to reject reports from this domain.
     */
    @SerialName("reject_reports")
    val rejectReports: Boolean,

    /**
     * A private comment on the domain block.
     */
    @SerialName("private_comment")
    val privateComment: String?,

    /**
     * A public comment on the domain block.
     */
    @SerialName("public_comment")
    val publicComment: String?,

    /**
     * Whether to obfuscate public displays of this domain block.
     */
    @SerialName("obfuscate")
    val obfuscate: Boolean
) {
    /**
     * The policy to be applied by a domain block.
     */
    @Serializable
    public enum class Severity {
        /**
         * Account statuses from this domain will be hidden by default.
         */
        @SerialName("silence")
        Silence,

        /**
         * All incoming data from this domain will be rejected.
         */
        @SerialName("suspend")
        Suspend,

        /**
         * Do nothing. Allows for rejecting media or reports.
         */
        @SerialName("noop")
        NoOp
    }
}
