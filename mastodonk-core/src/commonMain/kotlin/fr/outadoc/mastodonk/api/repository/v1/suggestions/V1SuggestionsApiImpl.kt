package fr.outadoc.mastodonk.api.repository.v1.suggestions

import fr.outadoc.mastodonk.api.endpoint.v1.suggestions.V1SuggestionsApi
import fr.outadoc.mastodonk.api.entity.Account
import fr.outadoc.mastodonk.client.MastodonHttpClient
import io.ktor.client.request.parameter
import io.ktor.http.HttpMethod

internal class V1SuggestionsApiImpl(private val client: MastodonHttpClient) : V1SuggestionsApi {

    @Deprecated("This V1 API is deprecated. Use the V2 API instead.", replaceWith = ReplaceWith("MastodonClient.suggestions.getSuggestions(limit)"))
    @Suppress("DEPRECATION") // Suppress the original deprecation from the interface as we are re-deprecating it here
    override suspend fun getSuggestions(limit: Int?): List<Account> {
        return client.request("/api/v1/suggestions") {
            method = HttpMethod.Get
            parameter("limit", limit)
        }
    }

    override suspend fun removeSuggestion(accountId: String) {
        client.request<Unit>("/api/v1/suggestions/${accountId.trim()}") {
            method = HttpMethod.Delete
        }
    }
}
