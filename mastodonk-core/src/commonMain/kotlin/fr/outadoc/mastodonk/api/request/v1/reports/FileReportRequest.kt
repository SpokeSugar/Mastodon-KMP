package fr.outadoc.mastodonk.api.request.v1.reports

import fr.outadoc.mastodonk.api.entity.ReportCategory
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class FileReportRequest(
    @SerialName("account_id")
    val accountId: String,

    @SerialName("status_ids")
    val statusIds: List<String>? = null,

    @SerialName("comment")
    val comment: String? = null,

    @SerialName("forward")
    val forward: Boolean? = null,

    @SerialName("category")
    val category: ReportCategory? = null,

    @SerialName("rule_ids")
    val ruleIds: List<String>? = null
)
