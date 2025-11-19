package fr.outadoc.mastodonk.api.repository.v1.statuses

import fr.outadoc.mastodonk.api.endpoint.v1.statuses.ScheduledStatusesApi
import fr.outadoc.mastodonk.api.entity.ScheduledStatus
import fr.outadoc.mastodonk.api.entity.paging.Page
import fr.outadoc.mastodonk.api.entity.paging.PageInfo
import fr.outadoc.mastodonk.api.entity.paging.parameter
import fr.outadoc.mastodonk.api.entity.request.scheduled.ScheduledStatusUpdateRequest // Import the request DTO
import fr.outadoc.mastodonk.client.MastodonHttpClient
import io.ktor.client.request.*
// formData import is not strictly needed if using setBody with Serializable
import io.ktor.http.*
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

internal class ScheduledStatusesApiImpl(private val client: MastodonHttpClient) : ScheduledStatusesApi {

    override suspend fun getScheduledStatuses(limit: Int?, pageInfo: PageInfo?): Page<List<ScheduledStatus>> {
        return client.requestPage("/api/v1/scheduled_statuses") {
            method = HttpMethod.Get
            parameter("limit", limit)
            parameter(pageInfo)
        }
    }

    override suspend fun getScheduledStatus(statusId: String): ScheduledStatus? {
        return client.requestOrNull("/api/v1/scheduled_statuses/${statusId.trim()}") {
            method = HttpMethod.Get
        }
    }

    @OptIn(ExperimentalTime::class)
    override suspend fun updateScheduledStatus(statusId: String, scheduledAt: Instant): ScheduledStatus {
        // Convert Instant to ISO 8601 string for the request body
        val requestBody = ScheduledStatusUpdateRequest(scheduledAt = scheduledAt.toString())
        return client.request("/api/v1/scheduled_statuses/${statusId.trim()}") {
            method = HttpMethod.Put
            contentType(ContentType.Application.Json) // Ensure correct content type for JSON body
            setBody(requestBody)
        }
    }

    override suspend fun cancelScheduledStatus(statusId: String) {
        // Ktor's request function returns the response body.
        // For a DELETE with an empty response, we expect Unit.
        // The client.request<Unit> or equivalent should handle this.
        // If client.request always expects a deserializable body, this might need adjustment
        // in the MastodonHttpClient or a different function call.
        // Assuming client.request can handle Unit for empty responses:
        client.request<Unit>("/api/v1/scheduled_statuses/${statusId.trim()}") {
            method = HttpMethod.Delete
        }
    }
}
