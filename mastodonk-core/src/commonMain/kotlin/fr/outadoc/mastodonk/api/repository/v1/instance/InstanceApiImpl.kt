package fr.outadoc.mastodonk.api.repository.v1.instance

import fr.outadoc.mastodonk.api.endpoint.v1.instance.InstanceApi
import fr.outadoc.mastodonk.api.entity.Activity
import fr.outadoc.mastodonk.api.entity.V1Instance
import fr.outadoc.mastodonk.client.MastodonHttpClient
import io.ktor.http.*

internal class InstanceApiImpl(private val client: MastodonHttpClient) : InstanceApi {

    override suspend fun getInstanceInfo(): V1Instance {
        return client.request("/api/v1/instance") {
            method = HttpMethod.Get
        }
    }

    override suspend fun getPeers(): List<String> {
        return client.request("/api/v1/instance/peers") {
            method = HttpMethod.Get
        }
    }

    override suspend fun getActivity(): List<Activity> {
        return client.request("/api/v1/instance/activity") {
            method = HttpMethod.Get
        }
    }
}
