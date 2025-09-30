package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a link that is trending.
 */
@Serializable
public data class TrendsLink(
    /**
     * The URL of the link.
     */
    @SerialName("url")
    public val url: String,

    /**
     * The title of the link.
     */
    @SerialName("title")
    public val title: String,

    /**
     * The description of the link.
     */
    @SerialName("description")
    public val description: String? = null,

    /**
     * The type of the link.
     */
    @SerialName("type")
    public val type: PreviewCardType,

    /**
     * The author of the link.
     */
    @SerialName("author_name")
    public val authorName: String? = null,

    /**
     * A URL for the author of the link.
     */
    @SerialName("author_url")
    public val authorUrl: String? = null,

    /**
     * The provider of the link.
     */
    @SerialName("provider_name")
    public val providerName: String? = null,

    /**
     * A URL for the provider of the link.
     */
    @SerialName("provider_url")
    public val providerUrl: String? = null,

    /**
     * HTML code for embedding this link.
     */
    @SerialName("html")
    public val html: String? = null,

    /**
     * The width of the preview, in pixels.
     */
    @SerialName("width")
    public val width: Long? = null,

    /**
     * The height of the preview, in pixels.
     */
    @SerialName("height")
    public val height: Long? = null,

    /**
     * The URL of an image to display for the link.
     */
    @SerialName("image")
    public val image: String? = null,

    /**
     * Used for photo embeds, instead of custom html.
     */
    @SerialName("embed_url")
    public val embedUrl: String? = null,

    /**
     *A hash computed by the BlurHash algorithm, for generating colorful preview thumbnails when media has not been downloaded yet.
     */
    @SerialName("blurhash")
    public val blurhash: String? = null,

    /**
     * Usage history for this link.
     */
    @SerialName("history")
    public val history: List<HistoryItem>
) {
    /**
     * Usage history for a hashtag.
     */
    @Serializable
    public data class HistoryItem(
        /**
         * UNIX timestamp on midnight of the given day.
         */
        @SerialName("day")
        public val day: String,

        /**
         * The counted usage of the link within that day.
         */
        @SerialName("uses")
        public val uses: String,

        /**
         * The total of accounts using the link within that day.
         */
        @SerialName("accounts")
        public val accounts: String
    )
}
