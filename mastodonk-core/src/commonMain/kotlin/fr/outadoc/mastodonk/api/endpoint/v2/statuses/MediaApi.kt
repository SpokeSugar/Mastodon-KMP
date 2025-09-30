package fr.outadoc.mastodonk.api.endpoint.v2.statuses

import fr.outadoc.mastodonk.api.entity.MediaAttachment
import fr.outadoc.mastodonk.api.entity.request.File

/**
 * Attach media to authored statuses.
 *
 * @see [Official Docs](https://docs.joinmastodon.org/methods/statuses/media/)
 */
public interface MediaApi {

    /**
     * Creates a media attachment to be used with a new status.
     * The full sized media will be processed asynchronously in the background for large uploads.
     *
     * @param file The file to be attached.
     * @param thumbnail The custom thumbnail of the media to be attached.
     * @param description A plain-text description of the media, for accessibility purposes.
     * @param focus Two floating points (x,y), comma-delimited, ranging from -1.0 to 1.0.
     *
     * @see [Official Docs](https://docs.joinmastodon.org/methods/statuses/media/#v2)
     */
    public suspend fun uploadMediaAttachment(
        file: File,
        thumbnail: File? = null,
        description: String? = null,
        focus: String? = null
    ): MediaAttachment
}
