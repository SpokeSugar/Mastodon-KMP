package fr.outadoc.mastodonk.api.endpoint.v1.statuses

import fr.outadoc.mastodonk.api.entity.MediaAttachment
import fr.outadoc.mastodonk.api.entity.request.File

/**
 * Attach media to authored statuses.
 *
 * @see [Official Docs](https://docs.joinmastodon.org/methods/statuses/media/)
 */
public interface V1MediaApi {

    /**
     * Get a media attachment, before it is attached to a status and posted, but after it is accepted for processing.
     *
     * @param attachmentId The ID of the MediaAttachment in the database.
     * @see [Official Docs](https://docs.joinmastodon.org/methods/statuses/media/#get)
     */
    public suspend fun getMediaAttachment(attachmentId: String): MediaAttachment?

    /**
     * Creates an attachment to be used with a new status.
     * This method will return after the full sized media is done processing.
     *
     * @param file The file to be attached.
     * @param thumbnail The custom thumbnail of the media to be attached.
     * @param description A plain-text description of the media, for accessibility purposes.
     * @param focus Two floating points (x,y), comma-delimited, ranging from -1.0 to 1.0.
     *
     * @see [Official Docs](https://docs.joinmastodon.org/methods/statuses/media/#v1)
     */
    @Deprecated(
        "This endpoint is deprecated in favor of the v2 version.",
        replaceWith = ReplaceWith("uploadMediaAttachment(file, thumbnail, description, focus)", "fr.outadoc.mastodonk.api.endpoint.v2.statuses.MediaApi.uploadMediaAttachment")
    )
    public suspend fun uploadMediaAttachmentV1(
        file: File,
        thumbnail: File?,
        description: String?,
        focus: String?
    ): MediaAttachment

    /**
     * Update a MediaAttachment's parameters, before it is attached to a status and posted.
     *
     * @param attachmentId The ID of the MediaAttachment in the database.
     * @param thumbnail The custom thumbnail of the media to be attached.
     * @param description A plain-text description of the media, for accessibility purposes.
     * @param focus Two floating points (x,y), comma-delimited, ranging from -1.0 to 1.0.
     *
     * @see [Official Docs](https://docs.joinmastodon.org/methods/statuses/media/#update)
     */
    public suspend fun updateMediaAttachment(
        attachmentId: String,
        thumbnail: File?,
        description: String?,
        focus: String?
    ): MediaAttachment

    /**
     * Delete a media attachment that is not currently attached to a status.
     *
     * @param attachmentId The ID of the MediaAttachment in the database.
     * @see [Official Docs](https://docs.joinmastodon.org/methods/statuses/media/#delete)
     */
    public suspend fun deleteMediaAttachment(attachmentId: String)
}
