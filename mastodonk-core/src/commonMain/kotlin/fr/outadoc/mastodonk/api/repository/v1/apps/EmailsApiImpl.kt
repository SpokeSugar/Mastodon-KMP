package fr.outadoc.mastodonk.api.repository.v1.apps

import fr.outadoc.mastodonk.api.endpoint.v1.apps.EmailsApi
import fr.outadoc.mastodonk.client.MastodonHttpClient
import io.ktor.client.request.forms.*
import io.ktor.client.request.setBody
import io.ktor.http.*

internal class EmailsApiImpl(private val client: MastodonHttpClient) : EmailsApi {

    override suspend fun resendConfirmationEmail(email: String?) {
        client.request<Unit>("/api/v1/emails/confirmations") {
            method = HttpMethod.Post
            if (email != null) {
                setBody(FormDataContent(parameters {
                    append("email", email)
                }))
            }
        }
    }
}
