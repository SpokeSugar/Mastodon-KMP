package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents the source properties of a status, for editing.
 */
@Serializable
public data class StatusSource(

    /**
     * ID of the status.
     */
    @SerialName("id")
    val id: String,

    /**
     * The plain text content of the status.
     */
    @SerialName("text")
    val text: String,

    /**
     * The plain text subject or content warning of the status.
     */
    @SerialName("spoiler_text")
    val spoilerText: String
)
