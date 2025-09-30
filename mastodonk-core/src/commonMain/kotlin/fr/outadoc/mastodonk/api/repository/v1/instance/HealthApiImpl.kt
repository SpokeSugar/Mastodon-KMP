package fr.outadoc.mastodonk.api.repository.v1.instance

import fr.outadoc.mastodonk.api.endpoint.v1.instance.HealthApi
import fr.outadoc.mastodonk.api.entity.Health
import fr.outadoc.mastodonk.client.MastodonHttpClient

internal class HealthApiImpl(
    private val client: MastodonHttpClient
) : HealthApi {

    override suspend fun getHealth(): Health {
        return client.request("/health")
    }
}