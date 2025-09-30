package fr.outadoc.mastodonk.api.entity.admin

import fr.outadoc.mastodonk.api.entity.Rule
import fr.outadoc.mastodonk.api.entity.Status
import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Admin-level information about a filed report.
 */
@Serializable
public data class AdminReport(
    @SerialName("id")
    val reportId: String,

    /**
     * Whether an action was taken to resolve this report.
     */
    @SerialName("action_taken")
    val wasActionTaken: Boolean,

    /**
     * When an action was taken, if this report is currently resolved.
     */
    @SerialName("action_taken_at")
    val actionTakenAt: Instant? = null,

    /**
     * The category under which the report is classified.
     */
    @SerialName("category")
    val category: Category,

    /**
     * An optional reason for reporting.
     */
    @SerialName("comment")
    val comment: String,

    /**
     * Whether a report was forwarded to a remote instance.
     */
    @SerialName("forwarded")
    val isForwarded: Boolean,

    /**
     * The time the report was filed.
     */
    @SerialName("created_at")
    val createdAt: Instant,

    /**
     * The time of last action on this report.
     */
    @SerialName("updated_at")
    val updatedAt: Instant,

    /**
     * The account which filed the report.
     */
    @SerialName("account")
    val account: AdminAccount,

    /**
     * The account being reported.
     */
    @SerialName("target_account")
    val targetAccount: AdminAccount,

    /**
     * The account of the moderator assigned to this report.
     */
    @SerialName("assigned_account")
    val assignedAccount: AdminAccount? = null,

    /**
     * The account of the moderator who handled the report.
     */
    @SerialName("action_taken_by_account")
    val actionTakenByAccount: AdminAccount? = null,

    /**
     * Statuses attached to the report, for context.
     */
    @SerialName("statuses")
    val statuses: List<Status>,

    /**
     * Rules attached to the report, for context.
     */
    @SerialName("rules")
    val rules: List<Rule>
) {
    /**
     * The category under which the report is classified.
     */
    @Serializable
    public enum class Category {
        /**
         * Malicious, fake, or repetitive content.
         */
        @SerialName("spam")
        Spam,

        /**
         * Illegal content.
         */
        @SerialName("legal")
        Legal,

        /**
         * Violates one or more specific rules.
         */
        @SerialName("violation")
        Violation,

        /**
         * The default (catch-all) category.
         */
        @SerialName("other")
        Other
    }
}
