package fr.outadoc.mastodonk.api.entity.v2

import kotlinx.serialization.SerialName

/**
 * A stripped-down version of an account that only contains what is necessary to display a list of avatars.
 */
public data class PartialAccountWithAvatar(
    /**
     * The account id.
     */
    @SerialName("id")
    public val id: String,

    /**
     * The Webfinger account URI.
     */
    @SerialName("acct")
    public val acct: String,

    /**
     * The location of the user's profile page.
     */
    @SerialName("url")
    public val url: String,

    /**
     * An image icon that is shown next to statuses and in the profile.
     */
    @SerialName("avatar")
    public val avatar: String,

    /**
     * A static version of the avatar.
     */
    @SerialName("avatar_static")
    public val avatarStatic: String,

    /**
     * Whether the account manually approves follow requests.
     */
    @SerialName("locked")
    public val isLocked: Boolean,

    /**
     * Indicates that the account may perform automated actions.
     */
    @SerialName("bot")
    public val isBot: Boolean
)
