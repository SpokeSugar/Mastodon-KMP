package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.collections.List

/**
 * Represents display or publishing preferences of the [Account].
 *
 * Returned as an additional entity when verifying and updated credentials.
 */
@Serializable
public data class Source(

    /**
     * The account's bio.
     */
    @SerialName("note")
    val bio: String,

    /**
     * Metadata about the account as a list of name/values.
     */
    @SerialName("fields")
    val fields: List<Field>,

    /**
     * The default post privacy to be used for new statuses.
     */
    @SerialName("privacy")
    val defaultPrivacy: StatusVisibility? = null,

    /**
     * Whether new statuses should be marked sensitive by default.
     */
    @SerialName("sensitive")
    val defaultSensitivity: Boolean? = null,

    /**
     * The default posting language for new statuses.
     *
     * ISO 639-1 language two-letter code.
     */
    @SerialName("language")
    val defaultLanguage: String? = null,

    /**
     * The number of pending follow requests.
     */
    @SerialName("follow_requests_count")
    val followRequestsCount: Long? = null,

    /**
     * Domains of websites allowed to credit the account.
     * Version history: 4.4.0 (mastodon API version 3) - added
     */
    @SerialName("attribution_domains")
    val attributionDomains: List<String>? = null,

    /**
     * Whether the user hides the contents of their follows and followers collections.
     * Version history: 4.1.0 - added
     */
    @SerialName("hide_collections")
    val hideCollections: Boolean? = null,

    /**
     * Whether the account has opted into discovery features such as the profile directory.
     * Version history: 3.1.0 - added
     */
    @SerialName("discoverable")
    val discoverable: Boolean? = null,

    /**
     * Whether public posts should be searchable to anyone.
     * Version history: 4.3.0 - added
     */
    @SerialName("indexable")
    val indexable: Boolean? = null,

    /**
     * The default quote policy to be used for new statuses.
     * (public, followers, nobody)
     * Version history: 4.5.0 (mastodon API version 7) - added
     */
    @SerialName("quote_policy")
    val quotePolicy: String? = null
)
