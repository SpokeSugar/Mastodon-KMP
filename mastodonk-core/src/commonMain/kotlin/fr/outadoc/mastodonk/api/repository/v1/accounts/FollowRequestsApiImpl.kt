package fr.outadoc.mastodonk.api.repository.v1.accounts

import fr.outadoc.mastodonk.api.endpoint.v1.accounts.FollowRequestsApi
import fr.outadoc.mastodonk.api.entity.Account
import fr.outadoc.mastodonk.api.entity.Relationship
import fr.outadoc.mastodonk.client.MastodonHttpClient
import io.ktor.client.request.*
import io.ktor.http.*

internal class FollowRequestsApiImpl(private val client: MastodonHttpClient) : FollowRequestsApi {

    override suspend fun getPendingFollowRequests(limit: String?): List<Account> {
        return client.request("/api/v1/follow_requests") {
            method = HttpMethod.Get
            parameter("limit", limit)
        }
    }

    override suspend fun acceptFollowRequest(accountId: String): Relationship {
        return client.request("/api/v1/follow_requests/${accountId.trim()}/authorize") {
            method = HttpMethod.Post
        }
    }

    override suspend fun rejectFollowRequest(accountId: String): Relationship {
        return client.request("/api/v1/follow_requests/${accountId.trim()}/reject") {
            method = HttpMethod.Post
        }
    }
}
