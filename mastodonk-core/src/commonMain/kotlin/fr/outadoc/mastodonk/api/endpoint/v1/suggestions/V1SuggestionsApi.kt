package fr.outadoc.mastodonk.api.endpoint.v1.suggestions

import fr.outadoc.mastodonk.api.entity.Account

/**
 * View and manage follow suggestions (V1).
 *
 * @see [Official Docs](https://docs.joinmastodon.org/methods/suggestions/#v1)
 */
public interface V1SuggestionsApi {

    /**
     * Gets the list of suggested accounts to follow.
     *
     * @param limit Maximum number of results to return. Defaults to 40 accounts. Max 80 accounts.
     */
    @Deprecated("This V1 API is deprecated. Use the V2 API instead.", replaceWith = ReplaceWith("MastodonClient.suggestions.getSuggestions(limit)"))
    public suspend fun getSuggestions(limit: Int? = null): List<Account>

    /**
     * Removes an account from the list of suggested accounts to follow.
     *
     * @param accountId The ID of the Account in the database.
     */
    public suspend fun removeSuggestion(accountId: String)
}
