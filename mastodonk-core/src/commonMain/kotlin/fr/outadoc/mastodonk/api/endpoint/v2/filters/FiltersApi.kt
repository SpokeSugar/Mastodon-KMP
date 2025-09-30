package fr.outadoc.mastodonk.api.endpoint.v2.filters

import fr.outadoc.mastodonk.api.entity.Filter
import fr.outadoc.mastodonk.api.entity.FilterKeyword
import fr.outadoc.mastodonk.api.entity.FilterStatus
import fr.outadoc.mastodonk.api.entity.form.FilterCreate
import fr.outadoc.mastodonk.api.entity.form.FilterKeywordCreate
import fr.outadoc.mastodonk.api.entity.form.FilterUpdate

/**
 * Create and manage filters.
 *
 * @see [Official Docs](https://docs.joinmastodon.org/methods/filters/)
 */
public interface FiltersApi {

    /**
     * Obtain a list of all filter groups for the current user.
     */
    public suspend fun getFilters(): List<Filter>

    /**
     * Obtain a single filter group owned by the current user.
     *
     * @param filterId The ID of the [Filter] in the database.
     */
    public suspend fun getFilter(filterId: String): Filter

    /**
     * Create a filter group with the given parameters.
     */
    public suspend fun createFilter(filter: FilterCreate): Filter

    /**
     * Update a filter group with the given parameters.
     *
     * @param filterId The ID of the [Filter] in the database.
     */
    public suspend fun updateFilter(filterId: String, filter: FilterUpdate): Filter

    /**
     * Delete a filter group with the given id.
     *
     * @param filterId The ID of the [Filter] in the database.
     */
    public suspend fun deleteFilter(filterId: String)

    /**
     * List all keywords attached to the current filter group.
     *
     * @param filterId The ID of the [Filter] in the database.
     */
    public suspend fun getFilterKeywords(filterId: String): List<FilterKeyword>

    /**
     * Add the given keyword to the specified filter group.
     *
     * @param filterId The ID of the [Filter] in the database.
     */
    public suspend fun addKeywordToFilter(filterId: String, keyword: FilterKeywordCreate): FilterKeyword

    /**
     * Get one filter keyword by the given id.
     *
     * @param keywordId The ID of the [FilterKeyword] in the database.
     */
    public suspend fun getFilterKeyword(keywordId: String): FilterKeyword

    /**
     * Update the given filter keyword.
     *
     * @param keywordId The ID of the [FilterKeyword] in the database.
     */
    public suspend fun updateFilterKeyword(keywordId: String, keyword: FilterKeywordCreate): FilterKeyword

    /**
     * Deletes the given filter keyword.
     *
     * @param keywordId The ID of the [FilterKeyword] in the database.
     */
    public suspend fun deleteFilterKeyword(keywordId: String)

    /**
     * Obtain a list of all status filters within this filter group.
     *
     * @param filterId The ID of the [Filter] in the database.
     */
    public suspend fun getFilterStatuses(filterId: String): List<FilterStatus>

    /**
     * Add a status filter to the current filter group.
     *
     * @param filterId The ID of the [Filter] in the database.
     * @param statusId The ID of the status to be added to the filter group.
     */
    public suspend fun addStatusToFilter(filterId: String, statusId: String): FilterStatus

    /**
     * Obtain a single status filter.
     *
     * @param statusFilterId The ID of the [FilterStatus] in the database.
     */
    public suspend fun getFilterStatus(statusFilterId: String): FilterStatus

    /**
     * Remove a status filter from the current filter group.
     *
     * @param statusFilterId The ID of the [FilterStatus] in the database.
     */
    public suspend fun deleteFilterStatus(statusFilterId: String)
}