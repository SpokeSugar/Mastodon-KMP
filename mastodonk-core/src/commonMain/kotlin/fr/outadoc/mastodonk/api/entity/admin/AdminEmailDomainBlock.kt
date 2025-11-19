package fr.outadoc.mastodonk.api.entity.admin

import kotlin.time.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents an email domain that cannot be used to sign up.
 */
@Serializable
public data class AdminEmailDomainBlock(
    /**
     * The ID of the EmailDomainBlock in the database.
     */
    @SerialName("id")
    val id: String,

    /**
     * The email domain that is not allowed to be used for signups.
     */
    @SerialName("domain")
    val domain: String,

    /**
     * When the email domain was disallowed from signups.
     */
    @SerialName("created_at")
    val createdAt: Instant,

    /**
     * Usage statistics for given days (typically the past week).
     */
    @SerialName("history")
    val history: List<History>
) {
    /**
     * Usage statistics for a given day.
     */
    @Serializable
    public data class History(
        /**
         * UNIX timestamp on midnight of the given day.
         */
        @SerialName("day")
        val day: String,

        /**
         * The counted accounts signup attempts using that email domain within that day.
         */
        @SerialName("accounts")
        val accounts: String,

        /**
         * The counted IP signup attempts of that email domain within that day.
         */
        @SerialName("uses")
        val uses: String
    )
}
