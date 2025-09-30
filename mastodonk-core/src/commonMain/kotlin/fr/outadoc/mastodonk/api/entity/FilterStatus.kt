package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a status ID that is part of a filter.
 */
@Serializable
public data class FilterStatus(
    /**
     * The ID of the FilterStatus in the database.
     */
    @SerialName("id")
    val id: String,

    /**
     * The ID of the Status that will be filtered.
     */
    @SerialName("status_id")
    val statusId: String
)
