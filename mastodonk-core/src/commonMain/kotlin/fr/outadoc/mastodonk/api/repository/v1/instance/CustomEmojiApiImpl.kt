package fr.outadoc.mastodonk.api.repository.v1.instance

import fr.outadoc.mastodonk.api.endpoint.v1.instance.CustomEmojiApi
import fr.outadoc.mastodonk.api.entity.CustomEmoji
import fr.outadoc.mastodonk.client.MastodonHttpClient
import io.ktor.http.*

internal class CustomEmojiApiImpl(private val client: MastodonHttpClient) : CustomEmojiApi {

    override suspend fun getCustomEmoji(): List<CustomEmoji> {
        return client.request("/api/v1/custom_emojis") {
            method = HttpMethod.Get
        }
    }
}
