package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a quote or a quote placeholder, with the current authorization status.
 */
@Serializable
public data class ShallowQuote(

    /**
     * The state of the quote.
     */
    @SerialName("state")
    val state: QuoteState,

    /**
     * The identifier of the status being quoted, if the quote has been accepted.
     *
     * This will be `null`, unless the `state` attribute is `accepted`.
     */
    @SerialName("quoted_status_id")
    val quotedStatusId: String? = null
)
