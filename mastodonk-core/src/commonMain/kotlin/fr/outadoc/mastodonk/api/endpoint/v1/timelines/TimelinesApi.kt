package fr.outadoc.mastodonk.api.endpoint.v1.timelines

import fr.outadoc.mastodonk.api.entity.Status
import fr.outadoc.mastodonk.api.entity.paging.Page
import fr.outadoc.mastodonk.api.entity.paging.PageInfo

/**
 * Read and view timelines of statuses.
 *
 * @see [Official Docs](https://docs.joinmastodon.org/methods/timelines/)
 */
public interface TimelinesApi {

    /**
     * View public statuses.
     *
     * @param onlyLocal Show only local statuses? Defaults to false. Corresponds to `local` in API docs.
     * @param onlyRemote Show only remote statuses? Defaults to false. Corresponds to `remote` in API docs.
     * @param onlyMedia Show only statuses with media attached? Defaults to false.
     * @param limit Maximum number of results to return. Defaults to 20 statuses. Max 40 statuses.
     * @param pageInfo Page info for pagination (max_id, since_id, min_id).
     */
    public suspend fun getPublicTimeline(
        onlyLocal: Boolean? = null,
        onlyRemote: Boolean? = null,
        onlyMedia: Boolean? = null,
        limit: Int? = null,
        pageInfo: PageInfo? = null
    ): Page<List<Status>>

    /**
     * View public statuses containing the given hashtag.
     *
     * @param hashtag The name of the hashtag (not including the # symbol).
     * @param anyOfTags Return statuses that contain any of these additional tags. Corresponds to `any[]` in API docs.
     * @param allOfTags Return statuses that contain all of these additional tags. Corresponds to `all[]` in API docs.
     * @param noneOfTags Return statuses that contain none of these additional tags. Corresponds to `none[]` in API docs.
     * @param onlyLocal Return only local statuses? Defaults to false. Corresponds to `local` in API docs.
     * @param onlyRemote Return only remote statuses? Defaults to false. Corresponds to `remote` in API docs.
     * @param onlyMedia Return only statuses with media attachments? Defaults to false.
     * @param limit Maximum number of results to return. Defaults to 20 statuses. Max 40 statuses.
     * @param pageInfo Page info for pagination (max_id, since_id, min_id).
     */
    public suspend fun getHashtagTimeline(
        hashtag: String,
        anyOfTags: List<String>? = null,
        allOfTags: List<String>? = null,
        noneOfTags: List<String>? = null,
        onlyLocal: Boolean? = null,
        onlyRemote: Boolean? = null,
        onlyMedia: Boolean? = null,
        limit: Int? = null,
        pageInfo: PageInfo? = null
    ): Page<List<Status>>

    /**
     * View statuses from followed users and hashtags.
     *
     * @param limit Maximum number of results to return. Defaults to 20 statuses. Max 40 statuses.
     * @param pageInfo Page info for pagination (max_id, since_id, min_id).
     */
    public suspend fun getHomeTimeline(
        limit: Int? = null,
        pageInfo: PageInfo? = null
    ): Page<List<Status>>

    /**
     * View public statuses containing a link to the specified currently-trending article.
     * This only lists statuses from people who have opted in to discoverability features.
     *
     * @param url The URL of the trending article.
     * @param limit Maximum number of results to return. Defaults to 20 statuses. Max 40 statuses.
     * @param pageInfo Page info for pagination (max_id, since_id, min_id).
     * @return A page of statuses, or null if the URL is not trending (404).
     */
    public suspend fun getLinkTimeline(
        url: String,
        limit: Int? = null,
        pageInfo: PageInfo? = null
    ): Page<List<Status>>?

    /**
     * View statuses in the given list timeline.
     *
     * @param listId Local ID of the List in the database.
     * @param limit Maximum number of results to return. Defaults to 20 statuses. Max 40 statuses.
     * @param pageInfo Page info for pagination (max_id, since_id, min_id).
     * @return A page of statuses, or null if the list is not found (404).
     */
    public suspend fun getListTimeline(
        listId: String,
        limit: Int? = null,
        pageInfo: PageInfo? = null
    ): Page<List<Status>>?
}
