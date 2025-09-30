package fr.outadoc.mastodonk.paging.api.endpoint.timelines

import androidx.paging.PagingSource
import fr.outadoc.mastodonk.api.endpoint.v1.timelines.TimelinesApi
import fr.outadoc.mastodonk.api.entity.Status
import fr.outadoc.mastodonk.api.entity.paging.PageInfo
import fr.outadoc.mastodonk.paging.pagingSource

public fun TimelinesApi.getPublicTimelineSource(
    onlyLocal: Boolean? = null,
    onlyRemote: Boolean? = null,
    onlyMedia: Boolean? = null
): PagingSource<PageInfo, Status> {
    return pagingSource { params ->
        getPublicTimeline(
            onlyLocal = onlyLocal,
            onlyRemote = onlyRemote,
            onlyMedia = onlyMedia,
            limit = params.loadSize,
            pageInfo = params.key
        )
    }
}

public fun TimelinesApi.getHashtagTimelineSource(
    hashtag: String,
    onlyLocal: Boolean? = null,
    // onlyRemote is a new parameter in TimelinesApi.getHashtagTimeline, adding it here for consistency
    onlyRemote: Boolean? = null, 
    onlyMedia: Boolean? = null,
    // anyOfTags, allOfTags, noneOfTags are new in TimelinesApi.getHashtagTimeline
    // Not adding them here unless specified, to keep the change minimal for now
): PagingSource<PageInfo, Status> {
    return pagingSource { params ->
        getHashtagTimeline(
            hashtag = hashtag,
            onlyLocal = onlyLocal,
            onlyRemote = onlyRemote,
            onlyMedia = onlyMedia,
            limit = params.loadSize,
            pageInfo = params.key
        )
    }
}

public fun TimelinesApi.getHomeTimelineSource(): PagingSource<PageInfo, Status> {
    return pagingSource { params ->
        getHomeTimeline(
            limit = params.loadSize,
            pageInfo = params.key
        )
    }
}

public fun TimelinesApi.getListTimelineSource(listId: String): PagingSource<PageInfo, Status> {
    return pagingSource { params ->
        getListTimeline(
            listId = listId,
            limit = params.loadSize,
            pageInfo = params.key
        )
    }
}
