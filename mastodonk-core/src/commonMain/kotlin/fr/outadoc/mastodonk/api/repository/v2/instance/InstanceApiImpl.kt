package fr.outadoc.mastodonk.api.repository.v2.instance

import fr.outadoc.mastodonk.api.endpoint.v2.instance.InstanceApi
import fr.outadoc.mastodonk.api.entity.Instance
import fr.outadoc.mastodonk.client.MastodonHttpClient
import io.ktor.http.HttpMethod

internal class InstanceApiImpl(private val client: MastodonHttpClient) : InstanceApi {

    override suspend fun getInstance(): Instance {
        return client.request("/api/v2/instance") {
            method = HttpMethod.Get
        }
    }
}
