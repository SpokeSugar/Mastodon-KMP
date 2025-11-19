package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.collections.List

/**
 * Represents a Mastodon instance.
 */
@Serializable
public data class Instance(
    @SerialName("domain")
    val domain: String,

    @SerialName("title")
    val title: String,

    @SerialName("version")
    val version: String,

    @SerialName("source_url")
    val sourceUrl: String,

    @SerialName("description")
    val description: String,

    @SerialName("usage")
    val usage: Usage,

    @SerialName("thumbnail")
    val thumbnail: Thumbnail,

    @SerialName("icon")
    val icon: List<Icon>? = null,

    @SerialName("languages")
    val languages: List<String>,

    @SerialName("configuration")
    val configuration: Configuration,

    @SerialName("registrations")
    val registrations: Registrations,

    @SerialName("api_versions")
    val apiVersions: Map<String, Int>? = null,

    @SerialName("contact")
    val contact: Contact,

    @SerialName("rules")
    val rules: List<Rule>
)

@Serializable
public data class Usage(
    @SerialName("users")
    val users: Users
)

@Serializable
public data class Users(
    @SerialName("active_month")
    val activeMonth: Long
)

@Serializable
public data class Thumbnail(
    @SerialName("url")
    val url: String,

    @SerialName("blurhash")
    val blurhash: String,

    @SerialName("versions")
    val versions: Map<String, String>
)

@Serializable
public data class Icon(
    @SerialName("src")
    val src: String,

    @SerialName("size")
    val size: String
)

@Serializable
public data class Configuration(
    @SerialName("urls")
    val urls: Urls,

    @SerialName("vapid")
    val vapid: Vapid? = null,

    @SerialName("accounts")
    val accounts: Accounts,

    @SerialName("statuses")
    val statuses: Statuses,

    @SerialName("media_attachments")
    val mediaAttachments: MediaAttachments,

    @SerialName("polls")
    val polls: Polls,

    @SerialName("translation")
    val translation: Translation,

    @SerialName("limited_federation")
    val limitedFederation: Boolean? = null
) {
    @Serializable
    public data class Translation(
        @SerialName("enabled")
        val enabled: Boolean
    )

    @Serializable
    public data class Urls(
        @SerialName("streaming")
        val streaming: String,

        @SerialName("status")
        val status: String? = null,

        @SerialName("about")
        val about: String? = null,

        @SerialName("privacy_policy")
        val privacyPolicy: String? = null,

        @SerialName("terms_of_service")
        val termsOfService: String? = null
    )
    @Serializable
    public data class Vapid(
        @SerialName("public_key")
        val publicKey: String
    )

    @Serializable
    public data class Accounts(
        @SerialName("max_featured_tags")
        val maxFeaturedTags: Long,

        @SerialName("max_pinned_statuses")
        val maxPinnedStatuses: Long? = null
    )

    @Serializable
    public data class Statuses(
        @SerialName("max_characters")
        val maxCharacters: Long,

        @SerialName("max_media_attachments")
        val maxMediaAttachments: Long,

        @SerialName("characters_reserved_per_url")
        val charactersReservedPerUrl: Long
    )

    @Serializable
    public data class MediaAttachments(
        @SerialName("description_limit")
        val descriptionLimit: Long,

        @SerialName("image_matrix_limit")
        val imageMatrixLimit: Long,

        @SerialName("image_size_limit")
        val imageSizeLimit: Long,

        @SerialName("supported_mime_types")
        val supportedMimeTypes: List<String>,

        @SerialName("video_frame_rate_limit")
        val videoFrameRateLimit: Long,

        @SerialName("video_matrix_limit")
        val videoMatrixLimit: Long,

        @SerialName("video_size_limit")
        val videoSizeLimit: Long
    )

    @Serializable
    public data class Polls(
        @SerialName("max_options")
        val maxOptions: Long,

        @SerialName("max_characters_per_option")
        val maxCharactersPerOption: Long,

        @SerialName("min_expiration")
        val minExpiration: Long,

        @SerialName("max_expiration")
        val maxExpiration: Long
    )
}

@Serializable
public data class Registrations(
    @SerialName("enabled")
    val enabled: Boolean,

    @SerialName("approval_required")
    val approvalRequired: Boolean,

    @SerialName("reason_required")
    val reasonRequired: Boolean? = null,

    @SerialName("message")
    val message: String? = null,

    @SerialName("min_age")
    val minAge: Int? = null,

    @SerialName("url")
    val url: String? = null
)

@Serializable
public data class Contact(
    @SerialName("email")
    val email: String,

    @SerialName("account")
    val account: Account
)