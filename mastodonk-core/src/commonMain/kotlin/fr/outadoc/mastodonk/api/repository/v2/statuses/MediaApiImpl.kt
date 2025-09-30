package fr.outadoc.mastodonk.api.repository.v2.statuses

import fr.outadoc.mastodonk.api.endpoint.v2.statuses.MediaApi
import fr.outadoc.mastodonk.api.entity.MediaAttachment
import fr.outadoc.mastodonk.api.entity.request.File
import fr.outadoc.mastodonk.api.entity.request.toFormPart
import fr.outadoc.mastodonk.client.MastodonHttpClient
import io.ktor.client.request.forms.*
import io.ktor.http.*

internal class MediaApiImpl(private val client: MastodonHttpClient) : MediaApi {

    override suspend fun uploadMediaAttachment(
        file: File,
        thumbnail: File?,
        description: String?,
        focus: String?
    ): MediaAttachment {
        val filePart = file.toFormPart("file")
        val thumbnailPart = thumbnail?.toFormPart("thumbnail")
        return client.request("/api/v2/media") {
            method = HttpMethod.Post
            formData {
                description?.let { append("description", it) }
                focus?.let { append("focus", it) }
                append(filePart)
                thumbnailPart?.let { append(it) }
            }
        }
    }
}
