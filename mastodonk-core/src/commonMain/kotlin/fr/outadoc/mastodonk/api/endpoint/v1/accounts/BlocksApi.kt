package fr.outadoc.mastodonk.api.endpoint.v1.accounts

import fr.outadoc.mastodonk.api.entity.Account
import fr.outadoc.mastodonk.api.entity.paging.Page
import fr.outadoc.mastodonk.api.entity.paging.PageInfo

/**
 * View your blocks.
 *
 * @see [Official Docs](https://docs.joinmastodon.org/methods/blocks/)
 */
public interface BlocksApi {

    /**
     * View your blocked users.
     *
     * @param limit Maximum number of results to return. Defaults to 40. Max 80.
     * @param pageInfo Paging information.
     */
    public suspend fun getBlocks(limit: Int? = null, pageInfo: PageInfo? = null): Page<List<Account>>
}
