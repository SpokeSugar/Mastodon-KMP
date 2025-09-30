package fr.outadoc.mastodonk.api.repository.v1.accounts

import fr.outadoc.mastodonk.api.endpoint.v1.accounts.FollowedTagsApi
import fr.outadoc.mastodonk.api.entity.Tag
import fr.outadoc.mastodonk.api.entity.paging.Page
import fr.outadoc.mastodonk.api.entity.paging.PageInfo
import fr.outadoc.mastodonk.api.entity.paging.parameter
import fr.outadoc.mastodonk.client.MastodonHttpClient
import io.ktor.client.request.parameter
import io.ktor.http.HttpMethod

internal class FollowedTagsApiImpl(private val client: MastodonHttpClient) : FollowedTagsApi {

    override suspend fun getFollowedTags(limit: Int?, pageInfo: PageInfo?): Page<List<Tag>> {
        return client.requestPage("/api/v1/followed_tags") {
            method = HttpMethod.Companion.Get
            parameter("limit", limit)
            parameter(pageInfo)
        }
    }
}