package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a poll option as part of a translation,
 * containing only the title.
 */
@Serializable
public data class TranslatedPollOption(

    @SerialName("title")
    val title: String
)
