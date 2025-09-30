package fr.outadoc.mastodonk.api.repository.v1.tags

import fr.outadoc.mastodonk.api.endpoint.v1.tags.TagsApi
import fr.outadoc.mastodonk.api.entity.Tag
import fr.outadoc.mastodonk.client.MastodonHttpClient

internal class TagsApiImpl(private val client: MastodonHttpClient) : TagsApi {

    override suspend fun getTag(name: String): Tag {
        return client.get("/api/v1/tags/$name")
    }

    override suspend fun followTag(name: String): Tag {
        return client.post("/api/v1/tags/$name/follow")
    }

    override suspend fun unfollowTag(name: String): Tag {
        return client.post("/api/v1/tags/$name/unfollow")
    }

    override suspend fun featureTag(id: String): Tag {
        return client.post("/api/v1/tags/$id/feature")
    }

    override suspend fun unfeatureTag(id: String): Tag {
        return client.post("/api/v1/tags/$id/unfeature")
    }
}
