package fr.outadoc.mastodonk.api.entity

import kotlin.time.Instant
import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.collections.List

/**
 * Represents a user account with extended information available for the authorized user.
 * It includes all standard account fields plus source preferences and role details.
 */
@Serializable
public data class CredentialAccount(

    /** The account ID. */
    @SerialName("id")
    val accountId: String,

    /** The username of the account, not including the domain. */
    @SerialName("username")
    val username: String,

    /** The WebFinger account URI. Equal to [username] for local users, or `username@domain` for remote users. */
    @SerialName("acct")
    val acct: String,

    /** The location of the user's profile page (web interface URL). */
    @SerialName("url")
    val url: String?,

    /** The profile's display name. */
    @SerialName("display_name")
    val displayName: String,

    /** The profile's bio or description (HTML). */
    @SerialName("note")
    val note: String,

    /** URL to an image icon that is shown next to statuses and in the profile. */
    @SerialName("avatar")
    val avatarUrl: String,

    /** URL to a static version of the avatar. Equal to [avatarUrl] if the avatar is a static image; different if animated. */
    @SerialName("avatar_static")
    val avatarStaticUrl: String,

    /** URL to an image banner that is shown above the profile and in profile cards. */
    @SerialName("header")
    val headerUrl: String,

    /** URL to a static version of the header. Equal to [headerUrl] if the header is a static image; different if animated. */
    @SerialName("header_static")
    val headerStaticUrl: String,

    /** Whether the account manually approves follow requests. */
    @SerialName("locked")
    val isLocked: Boolean,

    /** Custom emoji entities to be used when rendering the profile. */
    @SerialName("emojis")
    val emojis: List<CustomEmoji>?,

    /** When the account was created. */
    @SerialName("created_at")
    val createdAt: Instant,

    /** When the most recent status was posted. */
    @SerialName("last_status_at")
    val lastStatusAt: LocalDate? = null,

    /** How many statuses are attached to this account. */
    @SerialName("statuses_count")
    val statusesCount: Long,

    /** The reported followers of this profile. */
    @SerialName("followers_count")
    val followersCount: Long,

    /** The reported follows of this profile. */
    @SerialName("following_count")
    val followingCount: Long,

    /** Whether the account has opted into discovery features such as the profile directory. */
    @SerialName("discoverable")
    val isDiscoverable: Boolean? = null,

    /** Indicates that the profile is currently inactive and that its user has moved to a new account. */
    @SerialName("moved")
    val movedTo: Account? = null,

    /** Indicates that the account represents a Group actor. */
    @SerialName("group")
    val isGroup: Boolean?,

    /** Additional metadata attached to a profile as name-value pairs. */
    @SerialName("fields")
    val fields: List<Field>?,

    /** Indicates that the account may perform automated actions or identifies as a robot. */
    @SerialName("bot")
    val isBot: Boolean?,

    /** The user's ActivityPub actor identifier (used for federation). */
    @SerialName("uri")
    val uri: String?,

    /** Whether the account allows indexing by search engines. */
    @SerialName("indexable")
    val indexable: Boolean?,

    /** Whether the local user has opted out of being indexed by search engines. */
    @SerialName("noindex")
    val noindex: Boolean? = null,

    /** An extra attribute returned only when an account is memorialized. */
    @SerialName("memorial")
    val memorial: Boolean? = null,

    /** An extra attribute returned only when an account is silenced. If true, indicates that the account should be hidden behind a warning screen. */
    @SerialName("limited")
    val limited: Boolean? = null,

    /** Whether the user hides the contents of their follows and followers collections. */
    @SerialName("hide_collections")
    val hideCollections: Boolean? = null,

    /**
     * Publicly visible roles for the account (highlighted roles only), if the account is local.
     * Will be an empty array if no roles are highlighted or if the account is remote.
     * This is different from the main [role] attribute of [CredentialAccount].
     */
    @SerialName("roles")
    val accountRoles: List<AccountRole>? = null,

    /**
     * An extra attribute that contains source values to be used with API methods
     * that verify credentials and update credentials.
     */
    @SerialName("source")
    val source: Source,

    /** An extra attribute returned only when an account is suspended. */
    @SerialName("suspended")
    val isSuspended: Boolean? = null,

    /**
     * The complete role assigned to the currently authorized user,
     * including permissions and highlighted status.
     */
    @SerialName("role")
    val role: AccountRole? = null,
)
