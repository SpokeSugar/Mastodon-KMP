package fr.outadoc.mastodonk.api.entity

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents the terms of service of the instance.
 */
@Serializable
public data class TermsOfService(

    /**
     * The date these terms of service are coming or have come in effect.
     */
    @SerialName("effective_date")
    val effectiveDate: LocalDate,

    /**
     * Whether these terms of service are currently in effect.
     */
    @SerialName("effective")
    val isEffective: Boolean,

    /**
     * The rendered HTML content of the terms of service.
     */
    @SerialName("content")
    val content: String,

    /**
     * If there are newer terms of service, their effective date.
     */
    @SerialName("succeeded_by")
    val succeededBy: LocalDate? = null
)
