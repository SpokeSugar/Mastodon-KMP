package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Hints related to translation, as part of the instance configuration.
 */
@Serializable
public data class InstanceConfigurationTranslation(
    /**
     * Whether the Translations API is available on this server.
     */
    @SerialName("enabled")
    val enabled: Boolean
)
