package fr.outadoc.mastodonk.api.repository.v1.instance

import fr.outadoc.mastodonk.api.endpoint.v1.instance.TrendsApi
import fr.outadoc.mastodonk.api.entity.Status
import fr.outadoc.mastodonk.api.entity.Tag
import fr.outadoc.mastodonk.api.entity.TrendsLink
import fr.outadoc.mastodonk.client.MastodonHttpClient
import io.ktor.client.request.parameter
import io.ktor.http.HttpMethod

internal class TrendsApiImpl(private val client: MastodonHttpClient) : TrendsApi {

    override suspend fun getTrendingTags(limit: Int?, offset: Int?): List<Tag> {
        return client.request("/api/v1/trends/tags") {
            method = HttpMethod.Get
            parameter("limit", limit)
            parameter("offset", offset)
        }
    }

    override suspend fun getTrendingStatuses(limit: Int?, offset: Int?): List<Status> {
        return client.request("/api/v1/trends/statuses") {
            method = HttpMethod.Get
            parameter("limit", limit)
            parameter("offset", offset)
        }
    }

    override suspend fun getTrendingLinks(limit: Int?, offset: Int?): List<TrendsLink> {
        return client.request("/api/v1/trends/links") {
            method = HttpMethod.Get
            parameter("limit", limit)
            parameter("offset", offset)
        }
    }
}
