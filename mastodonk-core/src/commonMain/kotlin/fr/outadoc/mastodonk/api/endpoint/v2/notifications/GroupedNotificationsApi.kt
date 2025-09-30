package fr.outadoc.mastodonk.api.endpoint.v2.notifications

import fr.outadoc.mastodonk.api.entity.Account
import fr.outadoc.mastodonk.api.entity.v2.GroupedNotificationsResults
import fr.outadoc.mastodonk.api.entity.paging.Page

/**
 * Receive grouped notifications for activity on your account or statuses.
 *
 * To be used with Mastodon API version 2.
 */
public interface GroupedNotificationsApi {

    /**
     * Return grouped notifications concerning the user.
     */
    public suspend fun getGroupedNotifications(
        maxId: String? = null,
        sinceId: String? = null,
        minId: String? = null,
        limit: Int? = null,
        types: List<String>? = null,
        excludeTypes: List<String>? = null,
        accountId: String? = null,
        expandAccounts: String? = null,
        groupedTypes: List<String>? = null,
        includeFiltered: Boolean? = null
    ): Page<GroupedNotificationsResults>

    /**
     * View information about a specific notification group.
     */
    public suspend fun getNotificationGroup(groupKey: String): GroupedNotificationsResults

    /**
     * Dismiss a single notification group from the server.
     */
    public suspend fun dismissNotificationGroup(groupKey: String)

    /**
     * Get accounts of all notifications in a notification group.
     */
    public suspend fun getGroupAccounts(groupKey: String): List<Account>

    /**
     * Get the (capped) number of unread notification groups for the current user.
     */
    public suspend fun getUnreadNotificationCount(
        limit: Int? = null,
        types: List<String>? = null,
        excludeTypes: List<String>? = null,
        accountId: String? = null,
        groupedTypes: List<String>? = null
    ): Map<String, Int>
}
