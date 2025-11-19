package fr.outadoc.mastodonk.api.endpoint.v1.accounts

import fr.outadoc.mastodonk.api.entity.Report
import fr.outadoc.mastodonk.api.entity.request.ReportCreate
import fr.outadoc.mastodonk.api.entity.request.FileReportRequest

/**
 * Create user reports.
 *
 * @see [Official Docs](https://docs.joinmastodon.org/methods/accounts/reports/)
 */
public interface ReportsApi {

    /**
     * File a [Report].
     */
    public suspend fun fileReport(report: FileReportRequest): Report
}
