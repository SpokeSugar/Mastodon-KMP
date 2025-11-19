package fr.outadoc.mastodonk.api.entity

import fr.outadoc.mastodonk.serializer.TimestampToInstantSerializer
import kotlin.time.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents an extended description for the instance, to be shown on its about page.
 */
@Serializable
public data class ExtendedDescription(
    /**
     * A timestamp of when the extended description was last updated.
     */
    @SerialName("updated_at")
    @Serializable(with = TimestampToInstantSerializer::class)
    val updatedAt: Instant,

    /**
     * The rendered HTML content of the extended description.
     */
    @SerialName("content")
    val content: String
)
