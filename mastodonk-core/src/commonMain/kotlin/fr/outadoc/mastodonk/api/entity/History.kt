package fr.outadoc.mastodonk.api.entity

import kotlin.time.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Usage statistics for a given hashtag.
 */
@Serializable
public data class History(

    /**
     * UNIX timestamp on midnight of the given day.
     */
    @SerialName("day")
    val day: Instant,

    /**
     * The counted usage of the tag within that day.
     */
    @SerialName("uses")
    val uses: Long,

    /**
     * The total of accounts using the tag within that day.
     */
    @SerialName("accounts")
    val accounts: Long
)
