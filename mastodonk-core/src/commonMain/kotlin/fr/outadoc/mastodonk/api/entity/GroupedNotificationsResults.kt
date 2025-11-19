package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName

/**
 * Represents the results of a grouped notifications request.
 */
public data class GroupedNotificationsResults(
    /**
     * Accounts referenced by grouped notifications.
     */
    @SerialName("accounts")
    public val accounts: List<Account>,

    /**
     * Partial accounts referenced by grouped notifications.
     */
    @SerialName("partial_accounts")
    public val partialAccounts: List<PartialAccountWithAvatar>? = null,

    /**
     * Statuses referenced by grouped notifications.
     */
    @SerialName("statuses")
    public val statuses: List<Status>,

    /**
     * The grouped notifications themselves.
     */
    @SerialName("notification_groups")
    public val notificationGroups: List<NotificationGroup>
)
