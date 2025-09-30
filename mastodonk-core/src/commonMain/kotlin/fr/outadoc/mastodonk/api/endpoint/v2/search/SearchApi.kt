package fr.outadoc.mastodonk.api.endpoint.v2.search

import fr.outadoc.mastodonk.api.entity.Results // Use existing Results for V2
import fr.outadoc.mastodonk.api.entity.SearchType

/**
 * Perform a search for content in accounts, statuses and hashtags (API v2).
 *
 * @see [Official Docs](https://docs.joinmastodon.org/methods/search/#v2)
 */
public interface SearchApi {

    /**
     * Perform a search for content (API v2).
     *
     * @param q The search query.
     * @param type Specify whether to search for only `accounts`, `hashtags`, `statuses`.
     * @param resolve If `true`, try to resolve remote accounts or URLs.
     * @param following Only include accounts that the user is following?
     * @param accountId If provided, will only return statuses authored by this account.
     * @param excludeUnreviewed Filter out unreviewed tags?
     * @param maxId All results returned will be lesser than this ID.
     * @param minId Returns results immediately newer than this ID.
     * @param limit Maximum number of results to return, per type. Defaults to 20. Max 40.
     * @param offset Skip the first n results.
     */
    public suspend fun search(
        q: String,
        type: SearchType? = null,
        resolve: Boolean? = null,
        following: Boolean? = null,
        accountId: String? = null,
        excludeUnreviewed: Boolean? = null,
        maxId: String? = null,
        minId: String? = null,
        limit: Int? = null,
        offset: Int? = null
    ): Results
}
