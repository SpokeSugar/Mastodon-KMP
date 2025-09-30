package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * URLs of interest for client apps, as part of the instance configuration.
 */
@Serializable
public data class InstanceConfigurationUrls(
    /**
     * The Websockets URL for connecting to the streaming API.
     */
    @SerialName("streaming")
    val streaming: String,

    /**
     * The URL of the server's status page, if configured.
     */
    @SerialName("status")
    val status: String? = null,

    /**
     * The URL of the server's about page.
     */
    @SerialName("about")
    val about: String? = null, // Made nullable based on common patterns, example has it

    /**
     * The URL of the server's privacy policy.
     */
    @SerialName("privacy_policy")
    val privacyPolicy: String? = null,

    /**
     * The URL of the server's current terms of service, if any.
     */
    @SerialName("terms_of_service")
    val termsOfService: String? = null
)
