package fr.outadoc.mastodonk.api.repository.v1.tags

import fr.outadoc.mastodonk.api.endpoint.v1.tags.TagsApi
import fr.outadoc.mastodonk.api.entity.Tag
import fr.outadoc.mastodonk.client.MastodonHttpClient
import io.ktor.http.HttpMethod

internal class TagsApiImpl(private val client: MastodonHttpClient) : TagsApi {

    override suspend fun getTag(name: String): Tag {
        return client.request("/api/v1/tags/$name") {
            method = HttpMethod.Get
        }
    }

    override suspend fun followTag(name: String): Tag {
        return client.request("/api/v1/tags/$name/follow") {
            method = HttpMethod.Post
        }
    }

    override suspend fun unfollowTag(name: String): Tag {
        return client.request("/api/v1/tags/$name/unfollow") {
            method = HttpMethod.Post
        }
    }

    override suspend fun featureTag(id: String): Tag {
        return client.request("/api/v1/tags/$id/feature") {
            method = HttpMethod.Post
        }
    }

    override suspend fun unfeatureTag(id: String): Tag {
        return client.request("/api/v1/tags/$id/unfeature") {
            method = HttpMethod.Post
        }
    }
}
