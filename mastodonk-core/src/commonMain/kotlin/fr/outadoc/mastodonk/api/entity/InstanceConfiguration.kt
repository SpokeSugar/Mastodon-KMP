package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Configured values and limits for this website.
 */
@Serializable
public data class InstanceConfiguration(
    /**
     * URLs of interest for clients apps.
     */
    @SerialName("urls")
    val urls: InstanceConfigurationUrls,

    /**
     * VAPID key information for push notifications.
     */
    @SerialName("vapid")
    val vapid: InstanceConfigurationVapid? = null, // Added in 4.3.0

    /**
     * Limits related to accounts.
     */
    @SerialName("accounts")
    val accounts: InstanceConfigurationAccounts,

    /**
     * Limits related to authoring statuses.
     */
    @SerialName("statuses")
    val statuses: InstanceConfigurationStatuses,

    /**
     * Hints for which attachments will be accepted.
     */
    @SerialName("media_attachments")
    val mediaAttachments: InstanceConfigurationMediaAttachments,

    /**
     * Limits related to polls.
     */
    @SerialName("polls")
    val polls: InstanceConfigurationPolls,

    /**
     * Hints related to translation.
     */
    @SerialName("translation")
    val translation: InstanceConfigurationTranslation,

    /**
     * Whether federation is limited to explicitly allowed domains.
     */
    @SerialName("limited_federation")
    val limitedFederation: Boolean? = null // Added in 4.4.0
)
