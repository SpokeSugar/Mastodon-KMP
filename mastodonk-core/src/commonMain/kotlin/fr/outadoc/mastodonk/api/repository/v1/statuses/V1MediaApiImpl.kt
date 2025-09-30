package fr.outadoc.mastodonk.api.repository.v1.statuses

import fr.outadoc.mastodonk.api.endpoint.v1.statuses.V1MediaApi
import fr.outadoc.mastodonk.api.entity.MediaAttachment
import fr.outadoc.mastodonk.api.entity.request.File
import fr.outadoc.mastodonk.api.entity.request.toFormPart
import fr.outadoc.mastodonk.client.MastodonHttpClient
import io.ktor.client.request.forms.*
import io.ktor.http.*

internal class V1MediaApiImpl(private val client: MastodonHttpClient) : V1MediaApi {

    override suspend fun getMediaAttachment(attachmentId: String): MediaAttachment? {
        return client.requestOrNull("/api/v1/media/${attachmentId.trim()}") {
            method = HttpMethod.Get
        }
    }

    @Suppress("DEPRECATION")
    override suspend fun uploadMediaAttachmentV1(
        file: File,
        thumbnail: File?,
        description: String?,
        focus: String?
    ): MediaAttachment {
        val filePart = file.toFormPart("file")
        val thumbnailPart = thumbnail?.toFormPart("thumbnail")
        return client.request("/api/v1/media") {
            method = HttpMethod.Post
            formData {
                description?.let { append("description", it) }
                focus?.let { append("focus", it) }
                append(filePart)
                thumbnailPart?.let { append(it) }
            }
        }
    }

    override suspend fun updateMediaAttachment(
        attachmentId: String,
        thumbnail: File?,
        description: String?,
        focus: String?
    ): MediaAttachment {
        val thumbnailPart = thumbnail?.toFormPart("thumbnail")
        return client.request("/api/v1/media/${attachmentId.trim()}") {
            method = HttpMethod.Put
            formData {
                description?.let { append("description", it) }
                focus?.let { append("focus", it) }
                thumbnailPart?.let { append(it) }
            }
        }
    }

    override suspend fun deleteMediaAttachment(attachmentId: String) {
        client.request<Unit>("/api/v1/media/${attachmentId.trim()}") {
            method = HttpMethod.Delete
        }
    }
}
