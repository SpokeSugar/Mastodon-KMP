package fr.outadoc.mastodonk.api.entity

import fr.outadoc.mastodonk.serializer.TimestampToInstantSerializer
import kotlin.time.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents an encrypted message.
 * This entity is currently unused.
 */
@Serializable
public data class EncryptedMessage(
    /**
     * The ID of the EncryptedMessage in the database.
     */
    @SerialName("id")
    val id: String,

    /**
     * The ID of the Account that sent this message.
     */
    @SerialName("account_id")
    val accountId: String,

    /**
     * The ID of the Device that sent this message.
     */
    @SerialName("device_id")
    val deviceId: String,

    /**
     * Whether the message is a pre-key message or a normally encrypted message.
     */
    @SerialName("type")
    val type: MessageType,

    /**
     * The encrypted message content.
     */
    @SerialName("body")
    val body: String,

    /**
     * An HMAC SHA-256 digest hash of the message.
     */
    @SerialName("digest")
    val digest: String,

    /**
     * A signed value to be used when reporting the message body for its content.
     */
    @SerialName("message_franking")
    val messageFranking: String,

    /**
     * A timestamp for when the message was created.
     */
    @SerialName("created_at")
    @Serializable(with = TimestampToInstantSerializer::class)
    val createdAt: Instant
)

/**
 * Type of the encrypted message.
 */
@Serializable
public enum class MessageType(public val value: Int) {
    /**
     * Pre-key message (used to establish a new session).
     */
    @SerialName("0")
    PRE_KEY(0),

    /**
     * Normal encrypted message (part of an existing session).
     */
    @SerialName("1")
    NORMAL(1)
}
