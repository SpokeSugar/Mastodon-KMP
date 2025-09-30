package fr.outadoc.mastodonk.api.repository.v1.announcements

import fr.outadoc.mastodonk.api.endpoint.v1.announcements.AnnouncementsApi
import fr.outadoc.mastodonk.api.entity.Announcement
import fr.outadoc.mastodonk.client.MastodonHttpClient
import io.ktor.http.*

internal class AnnouncementsApiImpl(private val client: MastodonHttpClient) : AnnouncementsApi {

    override suspend fun getAnnouncements(withDismissed: Boolean?): List<Announcement> {
        return client.request("/api/v1/announcements") {
            method = HttpMethod.Get
        }
    }

    override suspend fun dismissAnnouncement(announcementId: String) {
        return client.request("/api/v1/announcements/${announcementId.trim()}/dismiss") {
            method = HttpMethod.Post
        }
    }

    override suspend fun addReaction(announcementId: String, name: String) {
        return client.request("/api/v1/announcements/${announcementId.trim()}/reactions/${name.trim()}") {
            method = HttpMethod.Put
        }
    }

    override suspend fun removeReaction(announcementId: String, name: String) {
        return client.request("/api/v1/announcements/${announcementId.trim()}/reactions/${name.trim()}") {
            method = HttpMethod.Delete
        }
    }
}
