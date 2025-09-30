package fr.outadoc.mastodonk.api.repository.v1.accounts

import fr.outadoc.mastodonk.api.endpoint.v1.accounts.PreferencesApi
import fr.outadoc.mastodonk.api.entity.Preferences
import fr.outadoc.mastodonk.client.MastodonHttpClient
import io.ktor.http.*

internal class PreferencesApiImpl(private val client: MastodonHttpClient) : PreferencesApi {

    override suspend fun getPreferences(): Preferences {
        return client.request("/api/v1/preferences") {
            method = HttpMethod.Get
        }
    }
}
