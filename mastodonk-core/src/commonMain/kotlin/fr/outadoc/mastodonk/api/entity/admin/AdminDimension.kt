package fr.outadoc.mastodonk.api.entity.admin

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents qualitative data about the server.
 */
@Serializable
public data class AdminDimension(
    /**
     * The unique keystring for the requested dimension.
     */
    @SerialName("key")
    val key: String,

    /**
     * The data available for the requested dimension.
     */
    @SerialName("data")
    val data: List<Data>
) {
    /**
     * A data point for a dimension.
     */
    @Serializable
    public data class Data(
        /**
         * The unique keystring for this data item.
         */
        @SerialName("key")
        val key: String,

        /**
         * A human-readable key for this data item.
         */
        @SerialName("human_key")
        val humanKey: String,

        /**
         * The value for this data item.
         */
        @SerialName("value")
        val value: String,

        /**
         * The units associated with this data item's value, if applicable.
         */
        @SerialName("unit")
        val unit: String? = null,

        /**
         * A human-readable formatted value for this data item.
         */
        @SerialName("human_value")
        val humanValue: String? = null
    )
}
