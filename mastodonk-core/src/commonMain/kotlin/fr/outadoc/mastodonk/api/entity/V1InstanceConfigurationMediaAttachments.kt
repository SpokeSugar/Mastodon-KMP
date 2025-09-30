package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.collections.List

/**
 * Hints for which attachments will be accepted.
 */
@Serializable
public data class V1InstanceConfigurationMediaAttachments(
    /**
     * Contains MIME types that can be uploaded.
     */
    @SerialName("supported_mime_types")
    val supportedMimeTypes: List<String>,

    /**
     * The maximum size of any uploaded image, in bytes.
     */
    @SerialName("image_size_limit")
    val imageSizeLimit: Long,

    /**
     * The maximum number of pixels (width times height) for image uploads.
     */
    @SerialName("image_matrix_limit")
    val imageMatrixLimit: Long,

    /**
     * The maximum size of any uploaded video, in bytes.
     */
    @SerialName("video_size_limit")
    val videoSizeLimit: Long,

    /**
     * The maximum frame rate for any uploaded video.
     */
    @SerialName("video_frame_rate_limit")
    val videoFrameRateLimit: Int,

    /**
     * The maximum number of pixels (width times height) for video uploads.
     */
    @SerialName("video_matrix_limit")
    val videoMatrixLimit: Long
)
