package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.collections.List

/**
 * Represents a rich preview card that is generated
 * using OpenGraph tags from a URL.
 */
@Serializable
public sealed class Card {

    /**
     * Location of linked resource.
     */
    public abstract val url: String

    /**
     * Title of linked resource.
     */
    public abstract val title: String

    /**
     * Description of preview.
     */
    public abstract val description: String

    /**
     * The author of the original resource.
     */
    @Deprecated("Use authors instead", replaceWith = ReplaceWith("authors.firstOrNull()?.name"))
    public abstract val authorName: String?

    /**
     * A link to the author of the original resource.
     */
    @Deprecated("Use authors instead", replaceWith = ReplaceWith("authors.firstOrNull()?.url"))
    public abstract val authorUrl: String?

    /**
     * Fediverse account of the authors of the original resource.
     */
    public abstract val authors: List<PreviewCardAuthor>

    /**
     * The provider of the original resource.
     */
    public abstract val providerName: String?

    /**
     * A link to the provider of the original resource.
     */
    public abstract val providerUrl: String?

    /**
     * HTML to be used for generating the preview card.
     */
    public abstract val html: String?

    /**
     * Width of preview, in pixels.
     */
    public abstract val width: Int?

    /**
     * Height of preview, in pixels.
     */
    public abstract val height: Int?

    /**
     * Preview thumbnail.
     */
    public abstract val image: String?

    /**
     * Used for photo embeds, instead of custom `html`.
     */
    public abstract val embedUrl: String?

    /**
     * A hash computed by [the BlurHash algorithm](https://github.com/woltapp/blurhash),
     * for generating colorful preview thumbnails when media has not been downloaded yet.
     */
    public abstract val blurhash: String?

    @Serializable
    @SerialName("video")
    public data class Video(
        @SerialName("url")
        override val url: String,

        @SerialName("title")
        override val title: String,

        @SerialName("description")
        override val description: String,

        @SerialName("author_name")
        @Deprecated("Use authors instead", replaceWith = ReplaceWith("authors.firstOrNull()?.name"))
        override val authorName: String? = null,

        @SerialName("author_url")
        @Deprecated("Use authors instead", replaceWith = ReplaceWith("authors.firstOrNull()?.url"))
        override val authorUrl: String? = null,

        @SerialName("authors")
        override val authors: List<PreviewCardAuthor> = emptyList(),

        @SerialName("provider_name")
        override val providerName: String? = null,

        @SerialName("provider_url")
        override val providerUrl: String? = null,

        @SerialName("html")
        override val html: String? = null,

        @SerialName("width")
        override val width: Int? = null,

        @SerialName("height")
        override val height: Int? = null,

        @SerialName("image")
        override val image: String? = null,

        @SerialName("embed_url")
        override val embedUrl: String? = null,

        @SerialName("blurhash")
        override val blurhash: String? = null
    ) : Card()

    @Serializable
    @SerialName("photo")
    public data class Photo(
        @SerialName("url")
        override val url: String,

        @SerialName("title")
        override val title: String,

        @SerialName("description")
        override val description: String,

        @SerialName("author_name")
        @Deprecated("Use authors instead", replaceWith = ReplaceWith("authors.firstOrNull()?.name"))
        override val authorName: String? = null,

        @SerialName("author_url")
        @Deprecated("Use authors instead", replaceWith = ReplaceWith("authors.firstOrNull()?.url"))
        override val authorUrl: String? = null,

        @SerialName("authors")
        override val authors: List<PreviewCardAuthor> = emptyList(),

        @SerialName("provider_name")
        override val providerName: String? = null,

        @SerialName("provider_url")
        override val providerUrl: String? = null,

        @SerialName("html")
        override val html: String? = null,

        @SerialName("width")
        override val width: Int? = null,

        @SerialName("height")
        override val height: Int? = null,

        @SerialName("image")
        override val image: String? = null,

        @SerialName("embed_url")
        override val embedUrl: String? = null,

        @SerialName("blurhash")
        override val blurhash: String? = null
    ) : Card()

    @Serializable
    @SerialName("link")
    public data class Link(
        @SerialName("url")
        override val url: String,

        @SerialName("title")
        override val title: String,

        @SerialName("description")
        override val description: String,

        @SerialName("author_name")
        @Deprecated("Use authors instead", replaceWith = ReplaceWith("authors.firstOrNull()?.name"))
        override val authorName: String? = null,

        @SerialName("author_url")
        @Deprecated("Use authors instead", replaceWith = ReplaceWith("authors.firstOrNull()?.url"))
        override val authorUrl: String? = null,

        @SerialName("authors")
        override val authors: List<PreviewCardAuthor> = emptyList(),

        @SerialName("provider_name")
        override val providerName: String? = null,

        @SerialName("provider_url")
        override val providerUrl: String? = null,

        @SerialName("html")
        override val html: String? = null,

        @SerialName("width")
        override val width: Int? = null,

        @SerialName("height")
        override val height: Int? = null,

        @SerialName("image")
        override val image: String? = null,

        @SerialName("embed_url")
        override val embedUrl: String? = null,

        @SerialName("blurhash")
        override val blurhash: String? = null,

        /**
         * Usage statistics for given days (typically the past week).
         */
        @SerialName("history")
        val history: List<LinkHistory>? = null

    ) : Card()

    @Serializable
    @SerialName("rich")
    public data class Rich(
        @SerialName("url")
        override val url: String,

        @SerialName("title")
        override val title: String,

        @SerialName("description")
        override val description: String,

        @SerialName("author_name")
        @Deprecated("Use authors instead", replaceWith = ReplaceWith("authors.firstOrNull()?.name"))
        override val authorName: String? = null,

        @SerialName("author_url")
        @Deprecated("Use authors instead", replaceWith = ReplaceWith("authors.firstOrNull()?.url"))
        override val authorUrl: String? = null,

        @SerialName("authors")
        override val authors: List<PreviewCardAuthor> = emptyList(),

        @SerialName("provider_name")
        override val providerName: String? = null,

        @SerialName("provider_url")
        override val providerUrl: String? = null,

        @SerialName("html")
        override val html: String? = null,

        @SerialName("width")
        override val width: Int? = null,

        @SerialName("height")
        override val height: Int? = null,

        @SerialName("image")
        override val image: String? = null,

        @SerialName("embed_url")
        override val embedUrl: String? = null,

        @SerialName("blurhash")
        override val blurhash: String? = null
    ) : Card()
}
