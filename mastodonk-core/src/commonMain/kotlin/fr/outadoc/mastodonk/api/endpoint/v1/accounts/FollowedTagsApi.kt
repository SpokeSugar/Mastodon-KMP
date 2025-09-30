package fr.outadoc.mastodonk.api.endpoint.v1.accounts

import fr.outadoc.mastodonk.api.entity.Tag
import fr.outadoc.mastodonk.api.entity.paging.Page
import fr.outadoc.mastodonk.api.entity.paging.PageInfo

/**
 * View your followed hashtags.
 *
 * @see [Official Docs](https://docs.joinmastodon.org/methods/followed_tags/)
 */
public interface FollowedTagsApi {

    /**
     * List your followed hashtags.
     *
     * @param limit Maximum number of results to return. Defaults to 100. Max 200.
     * @param pageInfo Paging information.
     */
    public suspend fun getFollowedTags(limit: Int? = null, pageInfo: PageInfo? = null): Page<List<Tag>>
}