package fr.outadoc.mastodonk.api.endpoint.v1.notifications

import fr.outadoc.mastodonk.api.entity.Notification
import fr.outadoc.mastodonk.api.entity.NotificationRequest
import fr.outadoc.mastodonk.api.entity.NotificationType
import fr.outadoc.mastodonk.api.entity.RequestsMerged
import fr.outadoc.mastodonk.api.entity.UnreadCount
import fr.outadoc.mastodonk.api.entity.paging.Page
import fr.outadoc.mastodonk.api.entity.paging.PageInfo

/**
 * Receive notifications for activity on the account or statuses.
 *
 * @see [Official Docs](https://docs.joinmastodon.org/methods/notifications/)
 */
public interface V1NotificationsApi {

    /**
     * Gets notifications concerning the account.
     *
     * @param pageInfo Paging information.
     * @param limit Maximum number of results to return. Defaults to 40, max 80.
     * @param types Types to include in the result.
     * @param excludeTypes Types to exclude from the results.
     * @param accountId Return only notifications received from the specified account.
     * @param includeFiltered Whether to include notifications filtered by the user's notification policy.
     */
    public suspend fun getNotifications(
        pageInfo: PageInfo? = null,
        limit: Int? = null,
        types: List<NotificationType>? = null,
        excludeTypes: List<NotificationType>? = null,
        accountId: String? = null,
        includeFiltered: Boolean? = null
    ): Page<List<Notification>>

    /**
     * Gets information about a notification.
     */
    public suspend fun getNotification(notificationId: String): Notification?

    /**
     * Clears all notifications for the account.
     */
    public suspend fun dismissAllNotifications()

    /**
     * Clears a single notification.
     */
    public suspend fun dismissNotification(notificationId: String)

    /**
     * Gets the number of unread notifications.
     */
    public suspend fun getUnreadNotificationCount(
        limit: Int? = null,
        types: List<NotificationType>? = null,
        excludeTypes: List<NotificationType>? = null,
        accountId: String? = null
    ): UnreadCount

    /**
     * Gets all notification requests.
     */
    public suspend fun getNotificationRequests(
        pageInfo: PageInfo? = null,
        limit: Int? = null
    ): Page<List<NotificationRequest>>

    /**
     * Gets a single notification request.
     */
    public suspend fun getNotificationRequest(requestId: String): NotificationRequest?

    /**
     * Accepts a notification request.
     */
    public suspend fun acceptNotificationRequest(requestId: String)

    /**
     * Dismisses a notification request.
     */
    public suspend fun dismissNotificationRequest(requestId: String)

    /**
     * Accepts multiple notification requests.
     */
    public suspend fun acceptNotificationRequests(requestIds: List<String>)

    /**
     * Dismisses multiple notification requests.
     */
    public suspend fun dismissNotificationRequests(requestIds: List<String>)

    /**
     * Checks if accepted notification requests have been merged.
     */
    public suspend fun checkNotificationRequestsMerged(): RequestsMerged
}
