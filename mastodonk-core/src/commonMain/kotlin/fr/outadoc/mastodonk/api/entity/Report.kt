package fr.outadoc.mastodonk.api.entity

import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.collections.List

/**
 * Reports filed against users and/or statuses, to be taken action on by moderators.
 */
@Serializable
public data class Report(

    /**
     * The ID of the report in the database.
     */
    @SerialName("id")
    val id: String,

    /**
     * Whether an action was taken yet.
     */
    @SerialName("action_taken")
    val actionTaken: Boolean,

    /**
     * When an action was taken against the report.
     */
    @SerialName("action_taken_at")
    val actionTakenAt: Instant? = null,

    /**
     * The generic reason for the report.
     */
    @SerialName("category")
    val category: ReportCategory,

    /**
     * The reason for the report.
     */
    @SerialName("comment")
    val comment: String,

    /**
     * Whether the report was forwarded to a remote domain.
     */
    @SerialName("forwarded")
    val forwarded: Boolean,

    /**
     * When the report was created.
     */
    @SerialName("created_at")
    val createdAt: Instant,

    /**
     * IDs of statuses that have been attached to this report for additional context.
     */
    @SerialName("status_ids")
    val statusIds: List<String>? = null,

    /**
     * IDs of the rules that have been cited as a violation by this report.
     */
    @SerialName("rule_ids")
    val ruleIds: List<String>? = null,

    /**
     * The account that was reported.
     */
    @SerialName("target_account")
    val targetAccount: Account
)
