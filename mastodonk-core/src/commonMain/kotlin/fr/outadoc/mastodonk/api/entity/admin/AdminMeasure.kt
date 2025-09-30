package fr.outadoc.mastodonk.api.entity.admin

import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents quantitative data about the server.
 */
@Serializable
public data class AdminMeasure(
    /**
     * The unique keystring for the requested measure.
     */
    @SerialName("key")
    val key: String,

    /**
     * The units associated with this data item's value, if applicable.
     */
    @SerialName("unit")
    val unit: String? = null,

    /**
     * The numeric total associated with the requested measure.
     */
    @SerialName("total")
    val total: String,

    /**
     * A human-readable formatted value for this data item.
     */
    @SerialName("human_value")
    val humanValue: String? = null,

    /**
     * The numeric total associated with the requested measure, in the previous period.
     */
    @SerialName("previous_total")
    val previousTotal: String? = null,

    /**
     * The data available for the requested measure, split into daily buckets.
     */
    @SerialName("data")
    val data: List<Data>
) {
    /**
     * A data point for a measure.
     */
    @Serializable
    public data class Data(
        /**
         * The requested day or midnight on the requested day in the time period.
         */
        @SerialName("date")
        val date: Instant,

        /**
         * The numeric value for the requested measure.
         */
        @SerialName("value")
        val value: String
    )
}
