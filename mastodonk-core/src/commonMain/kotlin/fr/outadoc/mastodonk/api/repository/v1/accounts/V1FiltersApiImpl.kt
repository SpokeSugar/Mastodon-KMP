package fr.outadoc.mastodonk.api.repository.v1.accounts

import fr.outadoc.mastodonk.api.endpoint.v1.accounts.V1FiltersApi
import fr.outadoc.mastodonk.api.entity.V1Filter
import fr.outadoc.mastodonk.api.entity.request.FilterCreate
import fr.outadoc.mastodonk.api.entity.request.FilterUpdate
import fr.outadoc.mastodonk.client.MastodonHttpClient
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.HttpMethod
import io.ktor.http.contentType

internal class V1FiltersApiImpl(private val client: MastodonHttpClient) : V1FiltersApi {

    override suspend fun getV1Filters(): List<V1Filter> {
        return client.request("/api/v1/filters") {
            method = HttpMethod.Get
        }
    }

    override suspend fun getV1Filter(filterId: String): V1Filter? {
        return client.requestOrNull("/api/v1/filters/${filterId.trim()}") {
            method = HttpMethod.Get
        }
    }

    override suspend fun createV1Filter(filter: FilterCreate): V1Filter {
        return client.request("/api/v1/filters") {
            method = HttpMethod.Post
            contentType(ContentType.Application.Json)
            setBody(filter)
        }
    }

    override suspend fun updateV1Filter(filterId: String, filter: FilterUpdate): V1Filter? {
        return client.requestOrNull("/api/v1/filters/${filterId.trim()}") {
            method = HttpMethod.Put
            contentType(ContentType.Application.Json)
            setBody(filter)
        }
    }

    override suspend fun deleteV1Filter(filterId: String) {
        client.request<Unit>("/api/v1/filters/${filterId.trim()}") {
            method = HttpMethod.Delete
        }
    }
}
