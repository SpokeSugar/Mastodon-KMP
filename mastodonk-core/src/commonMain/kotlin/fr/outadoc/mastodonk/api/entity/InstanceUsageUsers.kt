package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Usage data related to users on this server.
 */
@Serializable
public data class InstanceUsageUsers(
    /**
     * The number of active users in the past 4 weeks.
     */
    @SerialName("active_month")
    val activeMonth: Int
)
