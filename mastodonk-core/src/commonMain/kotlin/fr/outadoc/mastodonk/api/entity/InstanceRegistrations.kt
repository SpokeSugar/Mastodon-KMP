package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Information about registering for this website.
 */
@Serializable
public data class InstanceRegistrations(
    /**
     * Whether registrations are enabled.
     */
    @SerialName("enabled")
    val enabled: Boolean,

    /**
     * Whether registrations require moderator approval.
     */
    @SerialName("approval_required")
    val approvalRequired: Boolean,

    /**
     * A custom message to be shown when registrations are closed.
     */
    @SerialName("message")
    val message: String? = null,

    /**
     * A minimum age required to register, if configured.
     */
    @SerialName("min_age")
    val minAge: Int? = null, // Added in 4.4.0

    /**
     * Whether registrations require the user to provide a reason for joining.
     */
    @SerialName("reason_required")
    val reasonRequired: Boolean? = null, // Added in 4.4.0

    /**
     * A custom URL for account registration, when using external authentication.
     */
    @SerialName("url")
    val url: String? = null // Added in 4.2.0
)
