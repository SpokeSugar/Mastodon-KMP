package fr.outadoc.mastodonk.api.repository.v2.filters

import fr.outadoc.mastodonk.api.endpoint.v2.filters.FiltersApi
import fr.outadoc.mastodonk.api.entity.Filter
import fr.outadoc.mastodonk.api.entity.FilterKeyword
import fr.outadoc.mastodonk.api.entity.FilterStatus
import fr.outadoc.mastodonk.api.entity.form.FilterCreate
import fr.outadoc.mastodonk.api.entity.form.FilterKeywordCreate
import fr.outadoc.mastodonk.api.entity.form.FilterUpdate
import fr.outadoc.mastodonk.client.MastodonHttpClient
import io.ktor.client.request.forms.FormDataContent
import io.ktor.client.request.setBody
import io.ktor.http.HttpMethod
import io.ktor.http.Parameters

internal class FiltersApiImpl(private val client: MastodonHttpClient) : FiltersApi {

    override suspend fun getFilters(): List<Filter> {
        return client.request("/api/v2/filters") {
            method = HttpMethod.Get
        }
    }

    override suspend fun getFilter(filterId: String): Filter {
        return client.request("/api/v2/filters/$filterId") {
            method = HttpMethod.Get
        }
    }

    override suspend fun createFilter(filter: FilterCreate): Filter {
        return client.request("/api/v2/filters") {
            method = HttpMethod.Post
            setBody(filter)
        }
    }

    override suspend fun updateFilter(filterId: String, filter: FilterUpdate): Filter {
        return client.request("/api/v2/filters/$filterId") {
            method = HttpMethod.Put
            setBody(filter)
        }
    }

    override suspend fun deleteFilter(filterId: String) {
        client.request<Unit>("/api/v2/filters/$filterId") {
            method = HttpMethod.Delete
        }
    }

    override suspend fun getFilterKeywords(filterId: String): List<FilterKeyword> {
        return client.request("/api/v2/filters/$filterId/keywords") {
            method = HttpMethod.Get
        }
    }

    override suspend fun addKeywordToFilter(filterId: String, keyword: FilterKeywordCreate): FilterKeyword {
        return client.request("/api/v2/filters/$filterId/keywords") {
            method = HttpMethod.Post
            setBody(keyword)
        }
    }

    override suspend fun getFilterKeyword(keywordId: String): FilterKeyword {
        return client.request("/api/v2/filters/keywords/$keywordId") {
            method = HttpMethod.Get
        }
    }

    override suspend fun updateFilterKeyword(keywordId: String, keyword: FilterKeywordCreate): FilterKeyword {
        return client.request("/api/v2/filters/keywords/$keywordId") {
            method = HttpMethod.Put
            setBody(keyword)
        }
    }

    override suspend fun deleteFilterKeyword(keywordId: String) {
        client.request<Unit>("/api/v2/filters/keywords/$keywordId") {
            method = HttpMethod.Delete
        }
    }

    override suspend fun getFilterStatuses(filterId: String): List<FilterStatus> {
        return client.request("/api/v2/filters/$filterId/statuses") {
            method = HttpMethod.Get
        }
    }

    override suspend fun addStatusToFilter(filterId: String, statusId: String): FilterStatus {
        return client.request("/api/v2/filters/$filterId/statuses") {
            method = HttpMethod.Post
            setBody(FormDataContent(Parameters.build {
                append("status_id", statusId)
            }))
        }
    }

    override suspend fun getFilterStatus(statusFilterId: String): FilterStatus {
        return client.request("/api/v2/filters/statuses/$statusFilterId") {
            method = HttpMethod.Get
        }
    }

    override suspend fun deleteFilterStatus(statusFilterId: String) {
        client.request<Unit>("/api/v2/filters/statuses/$statusFilterId") {
            method = HttpMethod.Delete
        }
    }
}
