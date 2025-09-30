package fr.outadoc.mastodonk.api.endpoint.v1.filters

import fr.outadoc.mastodonk.api.entity.V1Filter
import fr.outadoc.mastodonk.api.entity.request.FilterCreate
import fr.outadoc.mastodonk.api.entity.request.FilterUpdate

/**
 * View and manage client-side filters.
 *
 * @see [Official Docs](https://docs.joinmastodon.org/methods/filters/#v1)
 */
@Deprecated("Mastodon v1 filters are deprecated. Use v2 filters instead.")
public interface V1FiltersApi {

    /**
     * Gets the list of filters set up on this account.
     *
     * For compatibility purposes, this now returns a list of V1::Filter,
     * with each V1::Filter representing one FilterKeyword (with the `keyword`
     * being presented in the `phrase` attribute).
     */
    @Deprecated(
        "Mastodon v1 filters are deprecated. Use v2 filters instead.",
        replaceWith = ReplaceWith("getFilters()", "fr.outadoc.mastodonk.api.endpoint.v2.filters.FiltersApi.getFilters")
    )
    public suspend fun getV1Filters(): List<V1Filter>

    /**
     * Gets a single filter.
     *
     * For compatibility purposes, this now returns a V1::Filter representing
     * one FilterKeyword (with the `keyword` being presented in the `phrase` attribute).
     *
     * @param filterId The ID of the FilterKeyword in the database.
     */
    @Deprecated(
        "Mastodon v1 filters are deprecated. Use v2 filters instead.",
        replaceWith = ReplaceWith("getFilter(filterId)", "fr.outadoc.mastodonk.api.endpoint.v2.filters.FiltersApi.getFilter")
    )
    public suspend fun getV1Filter(filterId: String): V1Filter?

    /**
     * Creates a new filter.
     *
     * For compatibility purposes, this method will create a Filter that contains
     * only one FilterKeyword. The `title` of the Filter and the `keyword` of the
     * FilterKeyword will be set equal to the `phrase` provided.
     */
    @Deprecated(
        "Mastodon v1 filters are deprecated. Use v2 filters instead.",
        replaceWith = ReplaceWith("createFilter(filter)", "fr.outadoc.mastodonk.api.endpoint.v2.filters.FiltersApi.createFilter")
    )
    public suspend fun createV1Filter(filter: FilterCreate): V1Filter

    /**
     * Updates an existing filter.
     *
     * For compatibility purposes, this method will return an error if you attempt
     * to change `expires_in`, `irreversible`, or `context` for a filter with multiple keywords.
     * Changing `phrase` and `whole_word` is always safe.
     *
     * @param filterId The ID of the FilterKeyword in the database.
     */
    @Deprecated(
        "Mastodon v1 filters are deprecated. Use v2 filters instead.",
        replaceWith = ReplaceWith("updateFilter(filterId, filter)", "fr.outadoc.mastodonk.api.endpoint.v2.filters.FiltersApi.updateFilter")
    )
    public suspend fun updateV1Filter(filterId: String, filter: FilterUpdate): V1Filter?

    /**
     * Deletes a filter.
     *
     * This method will delete only the FilterKeyword from its parent Filter.
     * To delete the parent Filter, you must use the v2 filters API.
     *
     * @param filterId The ID of the FilterKeyword in the database.
     */
    @Deprecated(
        "Mastodon v1 filters are deprecated. Use v2 filters instead.",
        replaceWith = ReplaceWith("deleteFilterKeyword(filterId)", "fr.outadoc.mastodonk.api.endpoint.v2.filters.FiltersApi.deleteFilterKeyword")
    )
    public suspend fun deleteV1Filter(filterId: String)
}
