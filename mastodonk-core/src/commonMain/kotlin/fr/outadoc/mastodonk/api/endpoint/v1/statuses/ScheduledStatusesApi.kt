package fr.outadoc.mastodonk.api.endpoint.v1.statuses

import fr.outadoc.mastodonk.api.entity.ScheduledStatus
import fr.outadoc.mastodonk.api.entity.paging.Page
import fr.outadoc.mastodonk.api.entity.paging.PageInfo
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

/**
 * View and manage currently scheduled statuses.
 *
 * @see [Official Docs](https://docs.joinmastodon.org/methods/statuses/scheduled_statuses/)
 */
public interface ScheduledStatusesApi {

    /**
     * Gets currently scheduled statuses for this account.
     * Query parameters: max_id, since_id, min_id, limit.
     */
    public suspend fun getScheduledStatuses(limit: Int? = null, pageInfo: PageInfo? = null): Page<List<ScheduledStatus>>

    /**
     * Gets a single [ScheduledStatus].
     * Path parameter: :id.
     */
    public suspend fun getScheduledStatus(statusId: String): ScheduledStatus?

    /**
     * Updates the schedule of a [ScheduledStatus].
     * Path parameter: :id.
     * Form data: scheduled_at (Datetime string).
     */
    @OptIn(ExperimentalTime::class)
    public suspend fun updateScheduledStatus(statusId: String, scheduledAt: Instant): ScheduledStatus // Changed to non-nullable Instant

    /**
     * Cancels a [ScheduledStatus].
     * Path parameter: :id.
     */
    public suspend fun cancelScheduledStatus(statusId: String)
}
