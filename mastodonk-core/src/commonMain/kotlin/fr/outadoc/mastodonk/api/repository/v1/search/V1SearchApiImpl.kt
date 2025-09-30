package fr.outadoc.mastodonk.api.repository.v1.search

import fr.outadoc.mastodonk.api.endpoint.v1.search.V1SearchApi
import fr.outadoc.mastodonk.api.entity.SearchType
import fr.outadoc.mastodonk.api.entity.SearchV1 // Correct return type for v1
import fr.outadoc.mastodonk.api.entity.paging.OffsetPageInfo
import fr.outadoc.mastodonk.client.MastodonHttpClient
import io.ktor.client.request.*
import io.ktor.http.*

internal class V1SearchApiImpl(private val client: MastodonHttpClient) : V1SearchApi {

    override suspend fun search(
        q: String,
        accountId: String?,
        type: SearchType?,
        excludeUnreviewed: Boolean?, // Kept from existing v1 interface signature
        attemptResolve: Boolean?, // Maps to 'resolve' for v1
        onlyFollowing: Boolean?, // Kept from existing v1 interface signature
        limit: Int?,
        pageInfo: OffsetPageInfo?
    ): SearchV1 {
        return client.request("/api/v1/search") { // Corrected to v1 endpoint
            method = HttpMethod.Get
            parameter("q", q)
            parameter("account_id", accountId)
            type?.let { parameter("type", it.value) }
            parameter("resolve", attemptResolve) // v1 query param is 'resolve'
            parameter("limit", limit)
            parameter("offset", pageInfo?.offset)

            // Parameters from existing interface, not explicitly in v1 API doc,
            // but kept for signature compatibility during refactor.
            // The Mastodon server might ignore them if they are not valid for the /api/v1/search endpoint.
            parameter("exclude_unreviewed", excludeUnreviewed)
            parameter("following", onlyFollowing)
        }
    }
}
