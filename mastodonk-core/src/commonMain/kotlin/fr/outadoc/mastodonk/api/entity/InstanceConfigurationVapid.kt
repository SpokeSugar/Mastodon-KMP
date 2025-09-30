package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * VAPID key information for push notifications.
 */
@Serializable
public data class InstanceConfigurationVapid(
    /**
     * The server's VAPID public key.
     */
    @SerialName("public_key")
    val publicKey: String
)
