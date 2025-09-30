package fr.outadoc.mastodonk.api.endpoint.v2.notifications

import fr.outadoc.mastodonk.api.entity.NotificationPolicy
import fr.outadoc.mastodonk.api.entity.request.notifications.NotificationPolicyCreate

/**
 * View and manage notification settings.
 *
 * @see [Official Docs](https://docs.joinmastodon.org/methods/notifications/)
 */
public interface NotificationsApi {

    /**
     * Gets the user's notification filtering policy.
     */
    public suspend fun getNotificationPolicy(): NotificationPolicy

    /**
     * Updates the user's notification filtering policy.
     */
    public suspend fun updateNotificationPolicy(policy: NotificationPolicyCreate): NotificationPolicy
}
