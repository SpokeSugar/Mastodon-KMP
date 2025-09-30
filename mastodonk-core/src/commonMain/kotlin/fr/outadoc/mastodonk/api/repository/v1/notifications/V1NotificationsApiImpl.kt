package fr.outadoc.mastodonk.api.repository.v1.notifications

import fr.outadoc.mastodonk.api.endpoint.v1.notifications.V1NotificationsApi
import fr.outadoc.mastodonk.api.entity.Notification
import fr.outadoc.mastodonk.api.entity.NotificationRequest
import fr.outadoc.mastodonk.api.entity.NotificationType
import fr.outadoc.mastodonk.api.entity.RequestsMerged
import fr.outadoc.mastodonk.api.entity.UnreadCount
import fr.outadoc.mastodonk.api.entity.paging.Page
import fr.outadoc.mastodonk.api.entity.paging.PageInfo
import fr.outadoc.mastodonk.api.entity.paging.parameter
import fr.outadoc.mastodonk.client.MastodonHttpClient
import io.ktor.client.request.*
import io.ktor.client.request.forms.*
import io.ktor.http.*

internal class V1NotificationsApiImpl(private val client: MastodonHttpClient) : V1NotificationsApi {

    override suspend fun getNotifications(
        pageInfo: PageInfo?,
        limit: Int?,
        types: List<NotificationType>?,
        excludeTypes: List<NotificationType>?,
        accountId: String?,
        includeFiltered: Boolean?
    ): Page<List<Notification>> {
        return client.requestPage("/api/v1/notifications") {
            method = HttpMethod.Get
            parameter(pageInfo)
            parameter("limit", limit)
            parameter("account_id", accountId)
            parameter("include_filtered", includeFiltered)

            types?.map { it.value }?.forEach {
                parameter("types[]", it)
            }

            excludeTypes?.map { it.value }?.forEach {
                parameter("exclude_types[]", it)
            }
        }
    }

    override suspend fun getNotification(notificationId: String): Notification? {
        return client.requestOrNull("/api/v1/notifications/${notificationId.trim()}") {
            method = HttpMethod.Get
        }
    }

    override suspend fun dismissAllNotifications() {
        client.request<Unit>("/api/v1/notifications/clear") {
            method = HttpMethod.Post
        }
    }

    override suspend fun dismissNotification(notificationId: String) {
        client.request<Unit>("/api/v1/notifications/${notificationId.trim()}/dismiss") {
            method = HttpMethod.Post
        }
    }

    override suspend fun getUnreadNotificationCount(
        limit: Int?,
        types: List<NotificationType>?,
        excludeTypes: List<NotificationType>?,
        accountId: String?
    ): UnreadCount {
        return client.request("/api/v1/notifications/unread_count") {
            method = HttpMethod.Get
            parameter("limit", limit)
            parameter("account_id", accountId)

            types?.map { it.value }?.forEach {
                parameter("types[]", it)
            }

            excludeTypes?.map { it.value }?.forEach {
                parameter("exclude_types[]", it)
            }
        }
    }

    override suspend fun getNotificationRequests(
        pageInfo: PageInfo?,
        limit: Int?
    ): Page<List<NotificationRequest>> {
        return client.requestPage("/api/v1/notifications/requests") {
            method = HttpMethod.Get
            parameter(pageInfo)
            parameter("limit", limit)
        }
    }

    override suspend fun getNotificationRequest(requestId: String): NotificationRequest? {
        return client.requestOrNull("/api/v1/notifications/requests/${requestId.trim()}") {
            method = HttpMethod.Get
        }
    }

    override suspend fun acceptNotificationRequest(requestId: String) {
        client.request<Unit>("/api/v1/notifications/requests/${requestId.trim()}/accept") {
            method = HttpMethod.Post
        }
    }

    override suspend fun dismissNotificationRequest(requestId: String) {
        client.request<Unit>("/api/v1/notifications/requests/${requestId.trim()}/dismiss") {
            method = HttpMethod.Post
        }
    }

    override suspend fun acceptNotificationRequests(requestIds: List<String>) {
        client.request<Unit>("/api/v1/notifications/requests/accept") {
            method = HttpMethod.Post
            formData {
                requestIds.forEach {
                    append("id[]", it)
                }
            }
        }
    }

    override suspend fun dismissNotificationRequests(requestIds: List<String>) {
        client.request<Unit>("/api/v1/notifications/requests/dismiss") {
            method = HttpMethod.Post
            formData {
                requestIds.forEach {
                    append("id[]", it)
                }
            }
        }
    }

    override suspend fun checkNotificationRequestsMerged(): RequestsMerged {
        return client.request("/api/v1/notifications/requests/merged") {
            method = HttpMethod.Get
        }
    }
}
