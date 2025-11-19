package fr.outadoc.mastodonk.api.entity

import kotlin.time.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents an event that caused follow relationships to be severed.
 * Placeholder - Update with full structure if available.
 */
@Serializable
public data class RelationshipSeveranceEvent(
    /**
     * The ID of the event.
     */
    @SerialName("id")
    val id: String,

    /**
     * The type of the event (e.g. "block", "moderator_action").
     */
    @SerialName("type")
    val type: String,

    /**
     * The timestamp of when the event occurred.
     */
    @SerialName("date")
    val date: Instant? = null,

    /**
     * Number of relationships severed.
     */
    @SerialName("relationships_count")
    val relationshipsCount: Int? = null
    // Add other fields as per API documentation
)
