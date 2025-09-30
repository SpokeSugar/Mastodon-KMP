package fr.outadoc.mastodonk.api.repository.v1.timelines

import fr.outadoc.mastodonk.api.endpoint.v1.timelines.TimelinesApi
import fr.outadoc.mastodonk.api.entity.Status
import fr.outadoc.mastodonk.api.entity.paging.Page
import fr.outadoc.mastodonk.api.entity.paging.PageInfo
import fr.outadoc.mastodonk.api.entity.paging.parameter
import fr.outadoc.mastodonk.client.MastodonHttpClient
import io.ktor.client.request.parameter
import io.ktor.http.HttpMethod

internal class TimelinesApiImpl(private val client: MastodonHttpClient) : TimelinesApi {

    override suspend fun getPublicTimeline(
        onlyLocal: Boolean?,
        onlyRemote: Boolean?,
        onlyMedia: Boolean?,
        limit: Int?,
        pageInfo: PageInfo?
    ): Page<List<Status>> {
        return client.requestPage("/api/v1/timelines/public") {
            method = HttpMethod.Get
            parameter("local", onlyLocal)
            parameter("remote", onlyRemote)
            parameter("only_media", onlyMedia)
            parameter("limit", limit)
            parameter(pageInfo)
        }
    }

    override suspend fun getHashtagTimeline(
        hashtag: String,
        anyOfTags: List<String>?,
        allOfTags: List<String>?,
        noneOfTags: List<String>?,
        onlyLocal: Boolean?,
        onlyRemote: Boolean?,
        onlyMedia: Boolean?,
        limit: Int?,
        pageInfo: PageInfo?
    ): Page<List<Status>> {
        return client.requestPage("/api/v1/timelines/tag/${hashtag.trim()}") {
            method = HttpMethod.Get
            anyOfTags?.let { tags -> tags.forEach { tag -> parameter("any[]", tag) } }
            allOfTags?.let { tags -> tags.forEach { tag -> parameter("all[]", tag) } }
            noneOfTags?.let { tags -> tags.forEach { tag -> parameter("none[]", tag) } }
            parameter("local", onlyLocal)
            parameter("remote", onlyRemote)
            parameter("only_media", onlyMedia)
            parameter("limit", limit)
            parameter(pageInfo)
        }
    }

    override suspend fun getHomeTimeline(
        limit: Int?,
        pageInfo: PageInfo?
    ): Page<List<Status>> {
        return client.requestPage("/api/v1/timelines/home") {
            method = HttpMethod.Get
            parameter("limit", limit)
            parameter(pageInfo)
        }
    }

    override suspend fun getLinkTimeline(
        url: String,
        limit: Int?,
        pageInfo: PageInfo?
    ): Page<List<Status>>? {
        return client.requestPageOrNull("/api/v1/timelines/link") {
            method = HttpMethod.Get
            parameter("url", url)
            parameter("limit", limit)
            parameter(pageInfo)
        }
    }

    override suspend fun getListTimeline(
        listId: String,
        limit: Int?,
        pageInfo: PageInfo?
    ): Page<List<Status>>? {
        return client.requestPageOrNull("/api/v1/timelines/list/${listId.trim()}") {
            method = HttpMethod.Get
            parameter("limit", limit)
            parameter(pageInfo)
        }
    }
}
