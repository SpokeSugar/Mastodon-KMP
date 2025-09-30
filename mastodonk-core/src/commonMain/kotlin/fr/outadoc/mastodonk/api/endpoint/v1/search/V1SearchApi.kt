package fr.outadoc.mastodonk.api.endpoint.v1.search

import fr.outadoc.mastodonk.api.entity.SearchV1 // Changed to use SearchV1
import fr.outadoc.mastodonk.api.entity.SearchType
import fr.outadoc.mastodonk.api.entity.paging.OffsetPageInfo

/**
 * Search for content in accounts, statuses and hashtags (API v1 - DEPRECATED / REMOVED).
 * This interface reflects the existing v1 search implementation in the library.
 *
 * @see [Official Docs](https://docs.joinmastodon.org/methods/search/#v1)
 */
public interface V1SearchApi {

    /**
     * Searches for content (API v1).
     *
     * @param q Search query.
     * @param accountId If provided, statuses returned will be authored only by this account.
     * @param type If provided, will only search for this type of content.
     * @param excludeUnreviewed Filter out unreviewed tags? (Parameter from existing codebase for v1)
     * @param attemptResolve Attempt WebFinger lookup? (Corresponds to 'resolve' in v1 docs, named 'attemptResolve' in existing code)
     * @param onlyFollowing Only include accounts that the user is following? (Parameter from existing codebase for v1)
     * @param limit Maximum number of results to return.
     * @param pageInfo Contains offset for pagination. V1 API docs also mention max_id, min_id which are not covered by OffsetPageInfo.
     */
    public suspend fun search(
        q: String,
        accountId: String? = null,
        type: SearchType? = null,
        excludeUnreviewed: Boolean? = null,
        attemptResolve: Boolean? = null,
        onlyFollowing: Boolean? = null,
        limit: Int? = null,
        pageInfo: OffsetPageInfo? = null
    ): SearchV1 // Return type changed to SearchV1
}
