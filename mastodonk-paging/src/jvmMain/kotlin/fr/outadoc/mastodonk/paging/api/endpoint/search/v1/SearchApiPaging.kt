package fr.outadoc.mastodonk.paging.api.endpoint.search.v1

import androidx.paging.PagingSource
import fr.outadoc.mastodonk.api.endpoint.v1.search.V1SearchApi
import fr.outadoc.mastodonk.api.entity.Account
import fr.outadoc.mastodonk.api.entity.SearchType
import fr.outadoc.mastodonk.api.entity.Status
import fr.outadoc.mastodonk.api.entity.paging.OffsetPageInfo
import fr.outadoc.mastodonk.paging.offsetPagingSource

public fun V1SearchApi.searchAccountsSource(
    q: String,
    accountId: String? = null,
    excludeUnreviewed: Boolean? = null,
    attemptResolve: Boolean? = null,
    onlyFollowing: Boolean? = null
): PagingSource<OffsetPageInfo, Account> {
    return offsetPagingSource { params ->
        search(
            q = q,
            accountId = accountId,
            type = SearchType.Accounts,
            excludeUnreviewed = excludeUnreviewed,
            attemptResolve = attemptResolve,
            onlyFollowing = onlyFollowing,
            limit = params.loadSize,
            pageInfo = params.key
        ).accounts
    }
}

public fun V1SearchApi.searchStatusesSource(
    q: String,
    accountId: String? = null,
    excludeUnreviewed: Boolean? = null,
    attemptResolve: Boolean? = null,
    onlyFollowing: Boolean? = null
): PagingSource<OffsetPageInfo, Status> {
    return offsetPagingSource { params ->
        search(
            q = q,
            accountId = accountId,
            type = SearchType.Statuses,
            excludeUnreviewed = excludeUnreviewed,
            attemptResolve = attemptResolve,
            onlyFollowing = onlyFollowing,
            limit = params.loadSize,
            pageInfo = params.key
        ).statuses
    }
}

//public fun V1SearchApi.searchHashtagsSource(
//    q: String,
//    accountId: String? = null,
//    excludeUnreviewed: Boolean? = null,
//    attemptResolve: Boolean? = null,
//    onlyFollowing: Boolean? = null
//): PagingSource<OffsetPageInfo, Tag> {
//    return offsetPagingSource { params ->
//        search(
//            q = q,
//            accountId = accountId,
//            type = SearchType.Hashtags,
//            excludeUnreviewed = excludeUnreviewed,
//            attemptResolve = attemptResolve,
//            onlyFollowing = onlyFollowing,
//            limit = params.loadSize,
//            pageInfo = params.key
//        ).hashtags
//    }
//}
