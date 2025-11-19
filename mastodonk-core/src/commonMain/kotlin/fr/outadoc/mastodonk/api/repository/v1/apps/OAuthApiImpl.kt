package fr.outadoc.mastodonk.api.repository.v1.apps

import fr.outadoc.mastodonk.api.endpoint.v1.apps.OAuthApi
import fr.outadoc.mastodonk.api.entity.Token
import fr.outadoc.mastodonk.api.entity.UserInfo
import fr.outadoc.mastodonk.api.entity.OAuthServerConfiguration
import fr.outadoc.mastodonk.api.entity.request.AuthorizeGet
import fr.outadoc.mastodonk.api.entity.request.TokenGet
import fr.outadoc.mastodonk.api.entity.request.TokenRevoke
import fr.outadoc.mastodonk.client.MastodonHttpClient
import io.ktor.client.request.parameter
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.HttpMethod
import io.ktor.http.URLBuilder
import io.ktor.http.contentType
import io.ktor.http.parameters
import io.ktor.http.path

internal class OAuthApiImpl(private val client: MastodonHttpClient) : OAuthApi {

    override suspend fun authorize(params: AuthorizeGet): String {
        return client.request("/oauth/authorize") {
            parameter("response_type", params.responseType)
            parameter("client_id", params.clientId)
            parameter("redirect_uri", params.redirectUri)
            parameter("scope", params.scope)
            parameter("state", params.state)
            parameter("force_login", params.forceLogin)
            parameter("lang", params.lang)
            parameter("code_challenge", params.codeChallenge)
            parameter("code_challenge_method", params.codeChallengeMethod)
        }
    }

    override suspend fun getToken(params: TokenGet): Token {
        return client.request("/oauth/token") {
            method = HttpMethod.Post
            contentType(ContentType.Application.Json)
            setBody(params)
        }
    }

    override suspend fun revokeToken(params: TokenRevoke) {
        client.request<Unit>("/oauth/revoke") {
            method = HttpMethod.Post
            contentType(ContentType.Application.Json)
            setBody(params)
        }
    }

    override suspend fun getUserInfo(): UserInfo {
        return client.request("/oauth/userinfo") {
            method = HttpMethod.Get
        }
    }

    override suspend fun getServerConfiguration(): OAuthServerConfiguration {
        return client.request("/.well-known/oauth-authorization-server") {
            method = HttpMethod.Get
        }
    }
}
