package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Usage statistics for a given link on a given day.
 */
@Serializable
public data class LinkHistory(

    /**
     * UNIX timestamp on midnight of the given day.
     */
    @SerialName("day")
    val day: String,

    /**
     * The counted accounts using the link within that day.
     */
    @SerialName("accounts")
    val accounts: String,

    /**
     * The counted statuses using the link within that day.
     */
    @SerialName("uses")
    val uses: String
)
