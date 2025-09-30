package fr.outadoc.mastodonk.api.repository.v2.notifications

import fr.outadoc.mastodonk.api.endpoint.v2.notifications.GroupedNotificationsApi
import fr.outadoc.mastodonk.api.entity.Account
import fr.outadoc.mastodonk.api.entity.paging.Page
import fr.outadoc.mastodonk.api.entity.v2.GroupedNotificationsResults
import fr.outadoc.mastodonk.client.MastodonHttpClient
import io.ktor.client.request.*
import io.ktor.http.*

internal class GroupedNotificationsApiImpl(
    private val client: MastodonHttpClient
) : GroupedNotificationsApi {

    override suspend fun getGroupedNotifications(
        maxId: String?,
        sinceId: String?,
        minId: String?,
        limit: Int?,
        types: List<String>?,
        excludeTypes: List<String>?,
        accountId: String?,
        expandAccounts: String?,
        groupedTypes: List<String>?,
        includeFiltered: Boolean?
    ): Page<GroupedNotificationsResults> {
        return client.requestPage("/api/v2/notifications") {
            parameter("max_id", maxId)
            parameter("since_id", sinceId)
            parameter("min_id", minId)
            parameter("limit", limit)
            parameter("types", types)
            parameter("exclude_types", excludeTypes)
            parameter("account_id", accountId)
            parameter("expand_accounts", expandAccounts)
            parameter("grouped_types", groupedTypes)
            parameter("include_filtered", includeFiltered)
        }
    }

    override suspend fun getNotificationGroup(groupKey: String): GroupedNotificationsResults {
        return client.request("/api/v2/notifications/${groupKey.trim()}")
    }

    override suspend fun dismissNotificationGroup(groupKey: String) {
        client.request<Unit>("/api/v2/notifications/${groupKey.trim()}/dismiss") {
            method = HttpMethod.Post
        }
    }

    override suspend fun getGroupAccounts(groupKey: String): List<Account> {
        return client.request("/api/v2/notifications/${groupKey.trim()}/accounts")
    }

    override suspend fun getUnreadNotificationCount(
        limit: Int?,
        types: List<String>?,
        excludeTypes: List<String>?,
        accountId: String?,
        groupedTypes: List<String>?
    ): Map<String, Int> {
        return client.request("/api/v2/notifications/unread_count") {
            parameter("limit", limit)
            parameter("types", types)
            parameter("exclude_types", excludeTypes)
            parameter("account_id", accountId)
            parameter("grouped_types", groupedTypes)
        }
    }
}
