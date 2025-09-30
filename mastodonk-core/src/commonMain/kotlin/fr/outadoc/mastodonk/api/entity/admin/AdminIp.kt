package fr.outadoc.mastodonk.api.entity.admin

import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents an IP address associated with a user.
 */
@Serializable
public data class AdminIp(
    /**
     * The IP address.
     */
    @SerialName("ip")
    val ip: String,

    /**
     * The timestamp of when the IP address was last used for this account.
     */
    @SerialName("used_at")
    val usedAt: Instant
)
