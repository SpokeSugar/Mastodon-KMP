package fr.outadoc.mastodonk.api.entity

import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.collections.List

/**
 * Represents a revision of a status that has been edited.
 */
@Serializable
public data class StatusEdit(

    /**
     * The content of the status at this revision.
     */
    @SerialName("content")
    val content: String,

    /**
     * The content of the subject or content warning at this revision.
     */
    @SerialName("spoiler_text")
    val spoilerText: String,

    /**
     * Whether the status was marked sensitive at this revision.
     */
    @SerialName("sensitive")
    val isSensitive: Boolean,

    /**
     * The timestamp of when the revision was published.
     */
    @SerialName("created_at")
    val createdAt: Instant,

    /**
     * The account that published this revision.
     */
    @SerialName("account")
    val account: Account,

    /**
     * The current state of the poll options at this revision.
     */
    @SerialName("poll")
    val poll: StatusEditPoll? = null,

    /**
     * The current state of the media attachments at this revision.
     */
    @SerialName("media_attachments")
    val attachments: List<MediaAttachment>,

    /**
     * Any custom emoji that are used in the current revision.
     */
    @SerialName("emojis")
    val emojis: List<CustomEmoji>,

    /**
     * Information about the status being quoted, if any.
     */
    @SerialName("quote")
    val quote: Quote? = null
)

