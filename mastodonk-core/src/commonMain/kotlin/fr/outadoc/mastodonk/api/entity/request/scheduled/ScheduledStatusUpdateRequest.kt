package fr.outadoc.mastodonk.api.entity.request.scheduled

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class ScheduledStatusUpdateRequest(
    @SerialName("scheduled_at")
    val scheduledAt: String
)
