package fr.outadoc.mastodonk.api.endpoint.v1.instance

import fr.outadoc.mastodonk.api.entity.Status
import fr.outadoc.mastodonk.api.entity.Tag
import fr.outadoc.mastodonk.api.entity.TrendsLink

/**
 * View hashtags, statuses, and links that are currently being used more frequently than usual.
 *
 * @see [Official Docs](https://docs.joinmastodon.org/methods/instance/trends/)
 */
public interface TrendsApi {

    /**
     * Tags that are being used more frequently within the past week.
     *
     * @param limit Maximum number of results to return. Defaults to 10 tags. Max 20 tags.
     * @param offset Skip the first n results.
     */
    public suspend fun getTrendingTags(limit: Int? = null, offset: Int? = null): List<Tag>

    /**
     * Statuses that have been interacted with more than others.
     *
     * @param limit Maximum number of results to return. Defaults to 20 statuses. Max 40 statuses.
     * @param offset Skip the first n results.
     */
    public suspend fun getTrendingStatuses(limit: Int? = null, offset: Int? = null): List<Status>

    /**
     * Links that have been shared more than others.
     *
     * @param limit Maximum number of results to return. Defaults to 10 links. Max 20 links.
     * @param offset Skip the first n results.
     */
    public suspend fun getTrendingLinks(limit: Int? = null, offset: Int? = null): List<TrendsLink>
}
