package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The generic reason for a report.
 */
@Serializable
public enum class ReportCategory {
    /**
     * Unwanted or repetitive content.
     */
    @SerialName("spam")
    Spam,

    /**
     * Illegal content.
     */
    @SerialName("legal")
    Legal,

    /**
     * A specific rule was violated.
     */
    @SerialName("violation")
    Violation,

    /**
     * Some other reason.
     */
    @SerialName("other")
    Other
}
