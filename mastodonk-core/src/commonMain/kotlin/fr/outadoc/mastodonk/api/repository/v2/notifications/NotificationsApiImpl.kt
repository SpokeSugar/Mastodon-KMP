package fr.outadoc.mastodonk.api.repository.v2.notifications

import fr.outadoc.mastodonk.api.endpoint.v2.notifications.NotificationsApi
import fr.outadoc.mastodonk.api.entity.NotificationPolicy
import fr.outadoc.mastodonk.api.entity.request.notifications.NotificationPolicyCreate
import fr.outadoc.mastodonk.client.MastodonHttpClient
import io.ktor.client.request.setBody
import io.ktor.http.HttpMethod

internal class NotificationsApiImpl(private val client: MastodonHttpClient) : NotificationsApi {

    override suspend fun getNotificationPolicy(): NotificationPolicy {
        return client.request("/api/v2/notifications/policy") {
            method = HttpMethod.Get
        }
    }

    override suspend fun updateNotificationPolicy(policy: NotificationPolicyCreate): NotificationPolicy {
        return client.request("/api/v2/notifications/policy") {
            method = HttpMethod.Patch
            setBody(policy)
        }
    }
}
