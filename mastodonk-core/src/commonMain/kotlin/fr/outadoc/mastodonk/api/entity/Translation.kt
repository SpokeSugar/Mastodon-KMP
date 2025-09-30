package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents the translation of a status.
 */
@Serializable
public data class Translation(

    /**
     * HTML-encoded translated content of the status.
     */
    @SerialName("content")
    val content: String,

    /**
     * Translated spoiler text of the status.
     */
    @SerialName("spoiler_text")
    val spoilerText: String,

    /**
     * Translated media attachments.
     */
    @SerialName("media_attachments")
    val mediaAttachments: List<TranslatedMediaAttachment>,

    /**
     * Translated poll.
     * This is nullable as a status might not have a poll.
     */
    @SerialName("poll")
    val poll: TranslatedPoll? = null,

    /**
     * The language of the status content, as detected by the machine translation provider.
     * ISO 639-1 language code.
     */
    @SerialName("detected_source_language")
    val detectedSourceLanguage: String,

    /**
     * The service that provided the machine translation.
     */
    @SerialName("provider")
    val provider: String
)
