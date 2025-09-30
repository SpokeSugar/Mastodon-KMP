package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Limits related to authoring statuses.
 */
@Serializable
public data class V1InstanceConfigurationStatuses(
    /**
     * The maximum number of allowed characters per status.
     */
    @SerialName("max_characters")
    val maxCharacters: Int,

    /**
     * The maximum number of media attachments that can be added to a status.
     */
    @SerialName("max_media_attachments")
    val maxMediaAttachments: Int,

    /**
     * Each URL in a status will be assumed to be exactly this many characters.
     */
    @SerialName("characters_reserved_per_url")
    val charactersReservedPerUrl: Int
)
