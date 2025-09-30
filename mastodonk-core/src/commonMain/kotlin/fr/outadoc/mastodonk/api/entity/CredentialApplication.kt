package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.collections.List

/**
 * Represents an application with credentials.
 * Includes all Application attributes plus client_id, client_secret, and client_secret_expires_at.
 */
@Serializable
public data class CredentialApplication(

    /**
     * The numeric ID of the application.
     * Version history: 0.9.9 - added
     */
    @SerialName("id")
    val id: String,

    /**
     * The name of the application.
     * Version history: 0.9.9 - added
     */
    @SerialName("name")
    val name: String,

    /**
     * The website associated with the application.
     * Version history:
     * 0.9.9 - added
     * 3.5.1 - the property is now nullable
     */
    @SerialName("website")
    val website: String? = null,

    /**
     * The scopes for the application. This is the registered `scopes` string split on whitespace.
     * Version history: 4.3.0 - added
     */
    @SerialName("scopes")
    val scopes: List<String>,

    /**
     * The registered redirection URI(s) for the application.
     * Values can be URLs or "urn:ietf:wg:oauth:2.0:oob".
     * Version history: 4.3.0 - added
     */
    @SerialName("redirect_uris")
    val redirectUris: List<String>,

    /**
     * The registered redirection URI(s) for the application stored as a single string.
     * Multiple URIs are separated by whitespace characters. May contain `
` characters.
     * Version history:
     * 0.0.0 - added
     * 4.3.0 - deprecated in favour of `redirectUris`.
     * @deprecated Deprecated since version 4.3.0 in favour of [redirectUris].
     * The value of this property is not a well-formed URI when multiple redirect URIs are registered.
     */
    @SerialName("redirect_uri")
    @Deprecated(
        message = "Deprecated since Mastodon API version 4.3.0 in favour of redirectUris. This value may not be a well-formed URI if multiple URIs are present.",
        replaceWith = ReplaceWith("redirectUris")
    )
    val redirectUri: String,

    /**
     * Used for Push Streaming API.
     * Equivalent to WebPushSubscription#server_key and Instance#vapid_public_key.
     * Version history:
     * 2.8.0 - added
     * 4.3.0 - deprecated pending removal.
     * @deprecated Deprecated since Mastodon API version 4.3.0 pending removal.
     * For this value, please see api/v2/instance (`configuration.vapid.public_key`).
     */
    @SerialName("vapid_key")
    @Deprecated(message = "Deprecated since Mastodon API version 4.3.0 pending removal. See Mastodon API v2 instance endpoint (configuration.vapid.public_key) for this value.")
    val vapidKey: String? = null,

    /**
     * Client ID key, to be used for obtaining OAuth tokens.
     * Version history:
     * 0.9.9 - added
     * 4.3.0 - moved to CredentialApplication from Application
     */
    @SerialName("client_id")
    val clientId: String,

    /**
     * Client secret key, to be used for obtaining OAuth tokens.
     * Version history:
     * 0.9.9 - added
     * 4.3.0 - moved to CredentialApplication from Application
     */
    @SerialName("client_secret")
    val clientSecret: String,

    /**
     * When the client secret key will expire. Presently this always returns `0` indicating that OAuth Clients do not expire.
     * Version history: 4.4.0 - added
     */
    @SerialName("client_secret_expires_at")
    val clientSecretExpiresAt: Long
)
