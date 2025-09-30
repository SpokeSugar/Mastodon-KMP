package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Usage data for this server.
 */
@Serializable
public data class InstanceUsage(
    /**
     * Usage data related to users on this server.
     */
    @SerialName("users")
    val users: InstanceUsageUsers
)
