package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.collections.List

/**
 * Information about the software instance of Mastodon running on this domain.
 */
@Serializable
public data class V1Instance(

    /**
     * The domain name of the instance.
     */
    @SerialName("uri")
    val uri: String,

    /**
     * The title of the instance.
     */
    @SerialName("title")
    val title: String,

    /**
     * An admin-defined description of the instance.
     */
    @SerialName("description")
    val description: String,

    /**
     * A shorter description of the instance defined by the admin.
     */
    @SerialName("short_description")
    val shortDescription: String,

    /**
     * An email that may be contacted for any inquiries.
     */
    @SerialName("email")
    val email: String,

    /**
     * The version of Mastodon installed on the instance.
     */
    @SerialName("version")
    val version: String,

    /**
     * Primary languages of the website and its staff.
     *
     * ISO 639-1 language two-letter code.
     */
    @SerialName("languages")
    val languages: List<String>,

    /**
     * Whether registrations are enabled.
     */
    @SerialName("registrations")
    val areRegistrationsEnabled: Boolean,

    /**
     * Whether registrations require moderator approval.
     */
    @SerialName("approval_required")
    val isApprovalRequired: Boolean,

    /**
     * Whether invites are enabled.
     */
    @SerialName("invites_enabled")
    val areInvitesEnabled: Boolean,

    /**
     * Configured values and limits for this website.
     */
    @SerialName("configuration")
    val configuration: V1InstanceConfiguration,

    /**
     * An itemized list of rules for this website.
     */
    @SerialName("rules")
    val rules: List<Rule>,

    /**
     * URLs of interest for clients apps.
     */
    @SerialName("urls")
    val urls: V1InstanceUrls,

    /**
     * Statistics about how much information the instance contains.
     */
    @SerialName("stats")
    val stats: V1InstanceStats,

    /**
     * URL of a banner image for the instance.
     */
    @SerialName("thumbnail")
    val thumbnail: String? = null,

    /**
     * A staff user that can be contacted, as an alternative to [email].
     */
    @SerialName("contact_account")
    val contactAccount: Account? = null
)
