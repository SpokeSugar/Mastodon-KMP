package fr.outadoc.mastodonk.api.repository.v2.search

import fr.outadoc.mastodonk.api.endpoint.v2.search.SearchApi
import fr.outadoc.mastodonk.api.entity.Results
import fr.outadoc.mastodonk.api.entity.SearchType
import fr.outadoc.mastodonk.client.MastodonHttpClient
import io.ktor.client.request.*
import io.ktor.http.*

internal class SearchApiImpl(private val client: MastodonHttpClient) : SearchApi {

    override suspend fun search(
        q: String,
        type: SearchType?,
        resolve: Boolean?,
        following: Boolean?,
        accountId: String?,
        excludeUnreviewed: Boolean?,
        maxId: String?,
        minId: String?,
        limit: Int?,
        offset: Int?
    ): Results {
        return client.request("/api/v2/search") {
            method = HttpMethod.Get
            parameter("q", q)
            type?.let { parameter("type", it.value) }
            parameter("resolve", resolve)
            parameter("following", following)
            parameter("account_id", accountId)
            parameter("exclude_unreviewed", excludeUnreviewed)
            parameter("max_id", maxId)
            parameter("min_id", minId)
            parameter("limit", limit)
            parameter("offset", offset)
        }
    }
}
