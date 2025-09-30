package fr.outadoc.mastodonk.api.repository.v1.accounts

import fr.outadoc.mastodonk.api.endpoint.v1.accounts.ReportsApi
import fr.outadoc.mastodonk.api.entity.Report
import fr.outadoc.mastodonk.api.request.v1.reports.FileReportRequest
import fr.outadoc.mastodonk.client.MastodonHttpClient
import io.ktor.client.request.setBody
import io.ktor.http.*

internal class ReportsApiImpl(private val client: MastodonHttpClient) : ReportsApi {

    override suspend fun fileReport(report: FileReportRequest): Report {
        return client.request("/api/v1/reports") {
            method = HttpMethod.Post
            contentType(ContentType.Application.Json)
            setBody(report)
        }
    }
}
