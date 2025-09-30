package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a poll as part of a translation,
 * containing only the id and a list of options (with titles).
 */
@Serializable
public data class TranslatedPoll(

    @SerialName("id")
    val id: String,

    @SerialName("options")
    val options: List<TranslatedPollOption>
)
