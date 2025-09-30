package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Limits related to polls.
 */
@Serializable
public data class V1InstanceConfigurationPolls(
    /**
     * Each poll is allowed to have up to this many options.
     */
    @SerialName("max_options")
    val maxOptions: Int,

    /**
     * Each poll option is allowed to have this many characters.
     */
    @SerialName("max_characters_per_option")
    val maxCharactersPerOption: Int,

    /**
     * The shortest allowed poll duration, in seconds.
     */
    @SerialName("min_expiration")
    val minExpiration: Int,

    /**
     * The longest allowed poll duration, in seconds.
     */
    @SerialName("max_expiration")
    val maxExpiration: Int
)
