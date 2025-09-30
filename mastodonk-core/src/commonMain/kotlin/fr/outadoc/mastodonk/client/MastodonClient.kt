package fr.outadoc.mastodonk.client

import fr.outadoc.mastodonk.api.endpoint.v1.accounts.AccountsApi
import fr.outadoc.mastodonk.api.endpoint.v1.accounts.BlocksApi
import fr.outadoc.mastodonk.api.endpoint.v1.accounts.BookmarksApi
import fr.outadoc.mastodonk.api.endpoint.v1.accounts.DomainBlocksApi
import fr.outadoc.mastodonk.api.endpoint.v1.accounts.EndorsementsApi
import fr.outadoc.mastodonk.api.endpoint.v1.accounts.FavouritesApi
import fr.outadoc.mastodonk.api.endpoint.v1.accounts.FeaturedTagsApi
import fr.outadoc.mastodonk.api.endpoint.v1.accounts.V1FiltersApi
import fr.outadoc.mastodonk.api.endpoint.v1.accounts.FollowRequestsApi
import fr.outadoc.mastodonk.api.endpoint.v1.accounts.MutesApi
import fr.outadoc.mastodonk.api.endpoint.v1.accounts.PreferencesApi
import fr.outadoc.mastodonk.api.endpoint.v1.accounts.ReportsApi
import fr.outadoc.mastodonk.api.endpoint.v1.accounts.SuggestionsApi
import fr.outadoc.mastodonk.api.endpoint.v1.admin.AdminApi
import fr.outadoc.mastodonk.api.endpoint.v1.announcements.AnnouncementsApi
import fr.outadoc.mastodonk.api.endpoint.v1.apps.AppsApi
import fr.outadoc.mastodonk.api.endpoint.v1.apps.OAuthApi
import fr.outadoc.mastodonk.api.endpoint.v1.instance.CustomEmojiApi
import fr.outadoc.mastodonk.api.endpoint.v1.instance.DirectoryApi
import fr.outadoc.mastodonk.api.endpoint.v1.instance.HealthApi
import fr.outadoc.mastodonk.api.endpoint.v1.instance.V1InstanceApi
import fr.outadoc.mastodonk.api.endpoint.v1.instance.TrendsApi
import fr.outadoc.mastodonk.api.endpoint.v1.notifications.V1NotificationsApi
import fr.outadoc.mastodonk.api.endpoint.v1.notifications.PushApi
import fr.outadoc.mastodonk.api.endpoint.v1.profile.ProfileApi
import fr.outadoc.mastodonk.api.endpoint.v1.proofs.ProofsApi
import fr.outadoc.mastodonk.api.endpoint.v1.search.V1SearchApi
import fr.outadoc.mastodonk.api.endpoint.v1.statuses.PollsApi
import fr.outadoc.mastodonk.api.endpoint.v1.statuses.ScheduledStatusesApi
import fr.outadoc.mastodonk.api.endpoint.v1.statuses.StatusesApi
import fr.outadoc.mastodonk.api.endpoint.v1.statuses.V1MediaApi
import fr.outadoc.mastodonk.api.endpoint.v1.suggestions.V1SuggestionsApi // Updated import for V1
import fr.outadoc.mastodonk.api.endpoint.v1.tags.TagsApi
import fr.outadoc.mastodonk.api.endpoint.v1.timelines.ConversationsApi
import fr.outadoc.mastodonk.api.endpoint.v1.timelines.ListsApi
import fr.outadoc.mastodonk.api.endpoint.v1.timelines.MarkersApi
import fr.outadoc.mastodonk.api.endpoint.v1.timelines.StreamingApi
import fr.outadoc.mastodonk.api.endpoint.v1.timelines.TimelinesApi
import fr.outadoc.mastodonk.api.endpoint.v2.filters.FiltersApi
import fr.outadoc.mastodonk.api.endpoint.v2.instance.InstanceApi
import fr.outadoc.mastodonk.api.endpoint.v2.notifications.GroupedNotificationsApi
import fr.outadoc.mastodonk.api.endpoint.v2.notifications.NotificationsApi
import fr.outadoc.mastodonk.api.endpoint.v2.search.SearchApi 
import fr.outadoc.mastodonk.api.endpoint.v2.statuses.MediaApi
/**
 * Entry point for all Mastodon APIs.
 */
public interface MastodonClient {

    // region Timelines

    public val timelines: TimelinesApi
    public val conversations: ConversationsApi
    public val lists: ListsApi
    public val markers: MarkersApi
    public val streaming: StreamingApi

    // endregion

    // region Instance

    public val instance: InstanceApi
    public val v1Instance: V1InstanceApi
    public val health: HealthApi
    public val trends: TrendsApi
    public val directory: DirectoryApi
    public val customEmoji: CustomEmojiApi

    // endregion

    // region Accounts

    public val accounts: AccountsApi
    public val bookmarks: BookmarksApi
    public val favourites: FavouritesApi
    public val mutes: MutesApi
    public val blocks: BlocksApi
    public val domainBlocks: DomainBlocksApi
    public val v1Filters: V1FiltersApi
    public val filters: FiltersApi
    public val reports: ReportsApi
    public val followRequests: FollowRequestsApi
    public val endorsements: EndorsementsApi
    public val featuredTags: FeaturedTagsApi
    public val preferences: PreferencesApi
    public val suggestions: SuggestionsApi // Now V2
    public val v1Suggestions: V1SuggestionsApi // For V1
    public val tags: TagsApi

    // endregion

    // region Profile
    public val profile: ProfileApi
    // endregion

    // region Statuses

    public val statuses: StatusesApi
    public val media: MediaApi
    public val v1Media: V1MediaApi
    public val polls: PollsApi
    public val scheduledStatuses: ScheduledStatusesApi

    // endregion

    // region Notifications

    public val v1notifications: V1NotificationsApi
    public val notifications: NotificationsApi
    public val groupedNotifications: GroupedNotificationsApi
    public val push: PushApi

    // endregion

    // region Apps

    public val apps: AppsApi
    public val oauth: OAuthApi

    // endregion

    // region Search

    public val search: SearchApi
    public val v1Search: V1SearchApi

    // endregion

    // region Announcements

    public val announcements: AnnouncementsApi

    // endregion

    // region Proofs

    public val proofs: ProofsApi

    // endregion

    // region Admin

    public val admin: AdminApi

    // endregion
}
