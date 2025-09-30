package fr.outadoc.mastodonk.api.entity

import fr.outadoc.mastodonk.api.entity.paging.Pageable
import kotlinx.datetime.Instant
import kotlin.collections.List
import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a user of Mastodon and their associated profile.
 */
@Serializable
public data class Account(

    @SerialName("id")
    val accountId: String,

    /**
     * The username of the account, not including the domain.
     */
    @SerialName("username")
    val username: String,

    /**
     * The WebFinger account URI.
     *
     * Equal to [username] for local users, or `username@domain` for remote users.
     */
    @SerialName("acct")
    val acct: String,

    /**
     * The location of the user's profile page.
     */
    @SerialName("url")
    val url: String?,

    @SerialName("display_name")
    val displayName: String,

    /**
     * The profile's bio / description.
     */
    @SerialName("note")
    val bio: String,

    /**
     * URL to an image that is shown next to the account's statuses and on its profile.
     */
    @SerialName("avatar")
    val avatarUrl: String,

    /**
     * URL to a static version of the avatar.
     *
     * Equal to [avatarUrl] if its value is a static image; different if avatar is an animated GIF.
     */
    @SerialName("avatar_static")
    val avatarStaticUrl: String,

    /**
     * URL to an image banner that is shown above the profile and in profile cards.
     */
    @SerialName("header")
    val headerUrl: String,

    /**
     * URL to a static version of the header.
     *
     * Equal to [headerUrl] if its value is a static image; different if avatar is an animated GIF.
     */
    @SerialName("header_static")
    val headerStaticUrl: String,

    /**
     * Whether the account manually approves follow requests.
     */
    @SerialName("locked")
    val isLocked: Boolean,

    /**
     * Custom emoji entities to be used when rendering the profile.
     *
     * If none, an empty array will be returned.
     */
    @SerialName("emojis")
    val emojis: List<CustomEmoji>,

    /**
     * Date at which the account was created.
     */
    @SerialName("created_at")
    val createdAt: Instant,

    /**
     * Date at which the last status was posted.
     */
    @SerialName("last_status_at")
    val lastStatusAt: LocalDate? = null,

    /**
     * Total number of statuses posted.
     */
    @SerialName("statuses_count")
    val statusesCount: Long,

    /**
     * Total number of accounts following this account.
     */
    @SerialName("followers_count")
    val followersCount: Long,

    /**
     * Total number of accounts followed by this account.
     */
    @SerialName("following_count")
    val followingCount: Long,

    /**
     * Whether the account has opted into discovery features such as the profile directory.
     */
    @SerialName("discoverable")
    val isDiscoverable: Boolean? = null,

    /**
     * Indicates that the profile is currently inactive and that its user has moved to a new account.
     */
    @SerialName("moved")
    val movedTo: Account? = null,

    /**
     * Whether this account represents a group.
     */
    @SerialName("group")
    val isGroup: Boolean,

    /**
     * Additional metadata attached to a profile as name-value pairs.
     */
    @SerialName("fields")
    val fields: List<Field>? = null,

    /**
     * Whether this account is a robot.
     *
     * Indicates that the account may perform automated actions,
     * may not be monitored, or identifies as a robot.
     */
    @SerialName("bot")
    val isBot: Boolean? = null,

    /**
     * The user's ActivityPub actor identifier (used for federation).
     * Version history:
     * 4.2.0 - added
     */
    @SerialName("uri")
    val uri: String? = null,

    /**
     * Whether the account allows indexing by search engines.
     * Version history:
     * 4.3.0 - added
     */
    @SerialName("indexable")
    val indexable: Boolean? = null,

    /**
     * Whether the local user has opted out of being indexed by search engines.
     * Version history:
     * 4.0.0 - added
     */
    @SerialName("noindex")
    val noindex: Boolean? = null,

    /**
     * An extra attribute returned only when an account is memorialized.
     * Version history:
     * 4.2.0 - added
     */
    @SerialName("memorial")
    val memorial: Boolean? = null,

    /**
     * An extra attribute returned only when an account is silenced. If true, indicates that the account should be hidden behind a warning screen.
     * Version history:
     * 3.5.3 - added
     */
    @SerialName("limited")
    val limited: Boolean? = null,

    /**
     * Whether the user hides the contents of their follows and followers collections.
     * Version history:
     * 4.3.0 - added
     */
    @SerialName("hide_collections")
    val hideCollections: Boolean? = null,

    /**
     * An array of roles assigned to the user that are publicly visible.
     * Will be an empty array if no roles are highlighted or if the account is remote.
     * Version history:
     * 4.1.0 - added
     */
    @SerialName("roles")
    val roles: List<AccountRole>? = null,

    /**
     * An entity to be used with API methods to verify and update credentials.
     */
    @SerialName("source")
    val source: Source? = null,

    /**
     * Whether the account is suspended.
     */
    @SerialName("suspended")
    val isSuspended: Boolean? = null,

    /**
     * Instant when a timed mute will expire, if applicable.
     */
    @SerialName("mute_expires_at")
    val muteExpiresAt: Instant? = null
) : Pageable {

    override val id: String
        get() = accountId
}
