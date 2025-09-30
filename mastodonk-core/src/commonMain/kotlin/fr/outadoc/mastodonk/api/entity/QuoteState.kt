package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The state of a quote.
 */
@Serializable
public enum class QuoteState {
    /**
     * The quote has not been acknowledged by the quoted account yet,
     * and requires authorization before being displayed.
     */
    @SerialName("pending")
    Pending,

    /**
     * The quote has been accepted and can be displayed.
     */
    @SerialName("accepted")
    Accepted,

    /**
     * The quote has been explicitly rejected by the quoted account,
     * and cannot be displayed.
     */
    @SerialName("rejected")
    Rejected,

    /**
     * The quote has been previously accepted, but is now revoked,
     * and thus cannot be displayed.
     */
    @SerialName("revoked")
    Revoked,

    /**
     * The quote has been approved, but the quoted post itself has now been deleted.
     */
    @SerialName("deleted")
    Deleted,

    /**
     * The quote has been approved, but cannot be displayed because the user
     * is not authorized to see it.
     */
    @SerialName("unauthorized")
    Unauthorized
}
