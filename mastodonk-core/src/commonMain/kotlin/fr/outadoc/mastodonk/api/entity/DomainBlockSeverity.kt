package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents the severity of a domain block.
 */
@Serializable
public enum class DomainBlockSeverity(public val value: String) {
    /**
     * Users from this domain will be hidden from timelines, threads, and notifications (unless you follow the user).
     */
    @SerialName("silence")
    Silence("silence"),

    /**
     * Incoming messages from this domain will be rejected and dropped entirely.
     */
    @SerialName("suspend")
    Suspend("suspend")
}