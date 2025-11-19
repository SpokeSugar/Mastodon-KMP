package fr.outadoc.mastodonk.api.repository.v1.profile

import fr.outadoc.mastodonk.api.endpoint.v1.profile.ProfileApi
import fr.outadoc.mastodonk.api.entity.CredentialAccount
import fr.outadoc.mastodonk.client.MastodonHttpClient
import io.ktor.http.* // Assuming Ktor is used for HttpMethod

internal class ProfileApiImpl(
    private val client: MastodonHttpClient
) : ProfileApi {

    override suspend fun deleteProfileAvatar(): CredentialAccount {
        return client.request("/api/v1/profile/avatar") {
            // No parameters needed for this request
            method = HttpMethod.Delete
        }
    }

    override suspend fun deleteProfileHeader(): CredentialAccount {
        return client.request("/api/v1/profile/header") {
            // No parameters needed for this request
            method = HttpMethod.Delete
        }
    }
}
