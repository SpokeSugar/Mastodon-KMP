package fr.outadoc.mastodonk.client

import fr.outadoc.mastodonk.api.repository.v1.accounts.AccountsApiImpl
import fr.outadoc.mastodonk.api.repository.v1.accounts.BlocksApiImpl
import fr.outadoc.mastodonk.api.repository.v1.accounts.BookmarksApiImpl
import fr.outadoc.mastodonk.api.repository.v1.accounts.DomainBlocksApiImpl
import fr.outadoc.mastodonk.api.repository.v1.accounts.EndorsementsApiImpl
import fr.outadoc.mastodonk.api.repository.v1.accounts.FavouritesApiImpl
import fr.outadoc.mastodonk.api.repository.v1.accounts.FeaturedTagsApiImpl
import fr.outadoc.mastodonk.api.repository.v1.accounts.V1FiltersApiImpl
import fr.outadoc.mastodonk.api.repository.v1.accounts.FollowRequestsApiImpl
import fr.outadoc.mastodonk.api.repository.v1.accounts.MutesApiImpl
import fr.outadoc.mastodonk.api.repository.v1.accounts.PreferencesApiImpl
import fr.outadoc.mastodonk.api.repository.v1.accounts.ReportsApiImpl
import fr.outadoc.mastodonk.api.repository.v1.accounts.SuggestionsApiImpl
import fr.outadoc.mastodonk.api.repository.v1.admin.AdminApiImpl
import fr.outadoc.mastodonk.api.repository.v1.announcements.AnnouncementsApiImpl
import fr.outadoc.mastodonk.api.repository.v1.apps.AppsApiImpl
import fr.outadoc.mastodonk.api.repository.v1.apps.OAuthApiImpl
import fr.outadoc.mastodonk.api.repository.v1.instance.CustomEmojiApiImpl
import fr.outadoc.mastodonk.api.repository.v1.instance.DirectoryApiImpl
import fr.outadoc.mastodonk.api.repository.v1.instance.HealthApiImpl
import fr.outadoc.mastodonk.api.repository.v1.instance.TrendsApiImpl
import fr.outadoc.mastodonk.api.repository.v1.instance.V1InstanceApiImpl
import fr.outadoc.mastodonk.api.repository.v1.notifications.PushApiImpl
import fr.outadoc.mastodonk.api.repository.v1.notifications.V1NotificationsApiImpl
import fr.outadoc.mastodonk.api.repository.v1.profile.ProfileApiImpl
import fr.outadoc.mastodonk.api.repository.v1.proofs.ProofsApiImpl
import fr.outadoc.mastodonk.api.repository.v1.search.V1SearchApiImpl
import fr.outadoc.mastodonk.api.repository.v1.statuses.PollsApiImpl
import fr.outadoc.mastodonk.api.repository.v1.statuses.ScheduledStatusesApiImpl
import fr.outadoc.mastodonk.api.repository.v1.statuses.StatusesApiImpl
import fr.outadoc.mastodonk.api.repository.v1.statuses.V1MediaApiImpl
import fr.outadoc.mastodonk.api.repository.v1.suggestions.V1SuggestionsApiImpl // Updated import for V1 Impl
import fr.outadoc.mastodonk.api.repository.v1.tags.TagsApiImpl
import fr.outadoc.mastodonk.api.repository.v1.timelines.*
import fr.outadoc.mastodonk.api.repository.v2.filters.FiltersApiImpl
import fr.outadoc.mastodonk.api.repository.v2.instance.InstanceApiImpl
import fr.outadoc.mastodonk.api.repository.v2.notifications.GroupedNotificationsApiImpl
import fr.outadoc.mastodonk.api.repository.v2.notifications.NotificationsApiImpl
import fr.outadoc.mastodonk.api.repository.v2.search.SearchApiImpl 
import fr.outadoc.mastodonk.api.repository.v2.statuses.MediaApiImpl

internal class MastodonClientImpl(httpClient: MastodonHttpClient) : MastodonClient {

    override val timelines = TimelinesApiImpl(httpClient)
    override val conversations = ConversationsApiImpl(httpClient)
    override val lists = ListsApiImpl(httpClient)
    override val markers = MarkersApiImpl(httpClient)
    override val streaming = StreamingApiImpl(httpClient)

    override val instance = InstanceApiImpl(httpClient)
    override val v1Instance = V1InstanceApiImpl(httpClient)
    override val health = HealthApiImpl(httpClient)
    override val trends = TrendsApiImpl(httpClient)
    override val directory = DirectoryApiImpl(httpClient)
    override val customEmoji = CustomEmojiApiImpl(httpClient)

    override val accounts = AccountsApiImpl(httpClient)
    override val bookmarks = BookmarksApiImpl(httpClient)
    override val favourites = FavouritesApiImpl(httpClient)
    override val mutes = MutesApiImpl(httpClient)
    override val blocks = BlocksApiImpl(httpClient)
    override val domainBlocks = DomainBlocksApiImpl(httpClient)
    override val filters = FiltersApiImpl(httpClient)
    override val v1Filters = V1FiltersApiImpl(httpClient)
    override val reports = ReportsApiImpl(httpClient)
    override val followRequests = FollowRequestsApiImpl(httpClient)
    override val endorsements = EndorsementsApiImpl(httpClient)
    override val featuredTags = FeaturedTagsApiImpl(httpClient)
    override val preferences = PreferencesApiImpl(httpClient)
    override val suggestions = SuggestionsApiImpl(httpClient) // Now V2 Impl
    override val v1Suggestions = V1SuggestionsApiImpl(httpClient) // For V1 Impl
    override val tags = TagsApiImpl(httpClient)

    override val profile = ProfileApiImpl(httpClient)

    override val statuses = StatusesApiImpl(httpClient)
    override val media = MediaApiImpl(httpClient)
    override val v1Media = V1MediaApiImpl(httpClient)
    override val polls = PollsApiImpl(httpClient)
    override val scheduledStatuses = ScheduledStatusesApiImpl(httpClient)

    override val v1notifications = V1NotificationsApiImpl(httpClient)
    override val notifications = NotificationsApiImpl(httpClient)
    override val groupedNotifications = GroupedNotificationsApiImpl(httpClient)
    override val push = PushApiImpl(httpClient)

    override val apps = AppsApiImpl(httpClient)
    override val oauth = OAuthApiImpl(httpClient)

    override val search = SearchApiImpl(httpClient)
    override val v1Search = V1SearchApiImpl(httpClient)

    override val announcements = AnnouncementsApiImpl(httpClient)

    override val proofs = ProofsApiImpl(httpClient)

    override val admin = AdminApiImpl(httpClient)
}
