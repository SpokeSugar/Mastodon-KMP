package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a file or media attachment that can be added to a status.
 *
 * @see [Official docs](https://docs.joinmastodon.org/entities/MediaAttachment/)
 */
@Serializable
public sealed class MediaAttachment {

    /**
     * The ID of the attachment in the database.
     */
    public abstract val id: String

    /**
     * The type of the attachment.
     */
    public abstract val type: String

    /**
     * The location of the original full-size attachment.
     */
    public abstract val url: String?

    /**
     * The location of a scaled-down preview of the attachment.
     */
    public abstract val previewUrl: String?

    /**
     * The location of the full-size original attachment on the remote website.
     */
    public abstract val remoteUrl: String?

    /**
     * Alternate text that describes what is in the media attachment.
     */
    public abstract val description: String?

    /**
     * A hash computed by the BlurHash algorithm.
     */
    public abstract val blurhash: String?

    @Serializable
    @SerialName("image")
    public data class Image(
        @SerialName("id")
        override val id: String,

        @SerialName("type")
        override val type: String,

        @SerialName("url")
        override val url: String,

        @SerialName("preview_url")
        override val previewUrl: String? = null,

        @SerialName("remote_url")
        override val remoteUrl: String? = null,

        @SerialName("description")
        override val description: String? = null,

        @SerialName("blurhash")
        override val blurhash: String? = null,

        @SerialName("meta")
        public val meta: ImageMeta? = null

    ) : MediaAttachment()

    @Serializable
    @SerialName("video")
    public data class Video(
        @SerialName("id")
        override val id: String,

        @SerialName("type")
        override val type: String,

        @SerialName("url")
        override val url: String,

        @SerialName("preview_url")
        override val previewUrl: String? = null,

        @SerialName("remote_url")
        override val remoteUrl: String? = null,

        @SerialName("description")
        override val description: String? = null,

        @SerialName("blurhash")
        override val blurhash: String? = null,

        @SerialName("meta")
        public val meta: VideoMeta? = null

    ) : MediaAttachment()

    @Serializable
    @SerialName("gifv")
    public data class Gifv(
        @SerialName("id")
        override val id: String,

        @SerialName("type")
        override val type: String,

        @SerialName("url")
        override val url: String,

        @SerialName("preview_url")
        override val previewUrl: String? = null,

        @SerialName("remote_url")
        override val remoteUrl: String? = null,

        @SerialName("description")
        override val description: String? = null,

        @SerialName("blurhash")
        override val blurhash: String? = null,

        @SerialName("meta")
        public val meta: GifvMeta? = null

    ) : MediaAttachment()

    @Serializable
    @SerialName("audio")
    public data class Audio(
        @SerialName("id")
        override val id: String,

        @SerialName("type")
        override val type: String,

        @SerialName("url")
        override val url: String,

        @SerialName("preview_url")
        override val previewUrl: String? = null,

        @SerialName("remote_url")
        override val remoteUrl: String? = null,

        @SerialName("description")
        override val description: String? = null,

        @SerialName("blurhash")
        override val blurhash: String? = null,

        @SerialName("meta")
        public val meta: AudioMeta? = null

    ) : MediaAttachment()

    @Serializable
    @SerialName("unknown")
    public data class Unknown(
        @SerialName("id")
        override val id: String,

        @SerialName("type")
        override val type: String,

        @SerialName("url")
        override val url: String? = null,

        @SerialName("preview_url")
        override val previewUrl: String? = null,

        @SerialName("remote_url")
        override val remoteUrl: String? = null,

        @SerialName("description")
        override val description: String? = null,

        @SerialName("blurhash")
        override val blurhash: String? = null

    ) : MediaAttachment()
}

@Serializable
public data class ImageMeta(
    @SerialName("original")
    val original: ImageDetails,
    @SerialName("small")
    val small: ImageDetails,
    @SerialName("focus")
    val focus: FocalPoint? = null
)

@Serializable
public data class ImageDetails(
    @SerialName("width")
    val width: Long,
    @SerialName("height")
    val height: Long,
    @SerialName("size")
    val size: String,
    @SerialName("aspect")
    val aspect: Double
)

@Serializable
public data class VideoMeta(
    @SerialName("length")
    val length: String? = null,
    @SerialName("duration")
    val duration: Double? = null,
    @SerialName("fps")
    val fps: Long? = null,
    @SerialName("size")
    val size: String? = null,
    @SerialName("width")
    val width: Long? = null,
    @SerialName("height")
    val height: Long? = null,
    @SerialName("aspect")
    val aspect: Double? = null,
    @SerialName("audio_encode")
    val audioEncode: String? = null,
    @SerialName("audio_bitrate")
    val audioBitrate: String? = null,
    @SerialName("audio_channels")
    val audioChannels: String? = null,
    @SerialName("original")
    val original: VideoDetails,
    @SerialName("small")
    val small: ImageDetails
)

@Serializable
public data class VideoDetails(
    @SerialName("width")
    val width: Long,
    @SerialName("height")
    val height: Long,
    @SerialName("frame_rate")
    val frameRate: String,
    @SerialName("duration")
    val duration: Double,
    @SerialName("bitrate")
    val bitrate: Long
)

@Serializable
public data class GifvMeta(
    @SerialName("length")
    val length: String? = null,
    @SerialName("duration")
    val duration: Double? = null,
    @SerialName("fps")
    val fps: Long? = null,
    @SerialName("size")
    val size: String? = null,
    @SerialName("width")
    val width: Long? = null,
    @SerialName("height")
    val height: Long? = null,
    @SerialName("aspect")
    val aspect: Double? = null,
    @SerialName("original")
    val original: VideoDetails,
    @SerialName("small")
    val small: ImageDetails
)

@Serializable
public data class AudioMeta(
    @SerialName("length")
    val length: String? = null,
    @SerialName("duration")
    val duration: Double? = null,
    @SerialName("audio_encode")
    val audioEncode: String? = null,
    @SerialName("audio_bitrate")
    val audioBitrate: String? = null,
    @SerialName("audio_channels")
    val audioChannels: String? = null,
    @SerialName("original")
    val original: AudioDetails
)

@Serializable
public data class AudioDetails(
    @SerialName("duration")
    val duration: Double,
    @SerialName("bitrate")
    val bitrate: Long
)
