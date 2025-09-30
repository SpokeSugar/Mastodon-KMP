package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a media attachment as part of a translation,
 * containing only id and description.
 */
@Serializable
public data class TranslatedMediaAttachment(

    @SerialName("id")
    val id: String,

    @SerialName("description")
    val description: String? = null
)
