package fr.outadoc.mastodonk.api.entity.admin

import kotlin.time.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a retention metric.
 */
@Serializable
public data class AdminCohort(
    /**
     * The timestamp for the start of the period, at midnight.
     */
    @SerialName("period")
    val period: Instant,

    /**
     * The size of the bucket for the returned data.
     */
    @SerialName("frequency")
    val frequency: Frequency,

    /**
     * Retention data for users who registered during the given period.
     */
    @SerialName("data")
    val data: List<CohortData>
) {
    /**
     * The size of the bucket for the returned data.
     */
    @Serializable
    public enum class Frequency {
        /**
         * Daily buckets
         */
        @SerialName("day")
        Day,

        /**
         * Monthly buckets
         */
        @SerialName("month")
        Month
    }

    /**
     * Retention data for users who registered during the given period.
     */
    @Serializable
    public data class CohortData(
        /**
         * The timestamp for the start of the bucket, at midnight.
         */
        @SerialName("date")
        val date: Instant,

        /**
         * The percentage rate of users who registered in the specified `period`
         * and were active for the given `date` bucket.
         */
        @SerialName("rate")
        val rate: Double,

        /**
         * How many users registered in the specified `period` and were active
         * for the given `date` bucket.
         */
        @SerialName("value")
        val value: String
    )
}
