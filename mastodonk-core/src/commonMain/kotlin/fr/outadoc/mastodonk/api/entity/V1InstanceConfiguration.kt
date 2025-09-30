package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Configured values and limits for this website.
 */
@Serializable
public data class V1InstanceConfiguration(
    /**
     * Limits related to accounts.
     */
    @SerialName("accounts")
    val accounts: V1InstanceConfigurationAccounts,

    /**
     * Limits related to authoring statuses.
     */
    @SerialName("statuses")
    val statuses: V1InstanceConfigurationStatuses,

    /**
     * Hints for which attachments will be accepted.
     */
    @SerialName("media_attachments")
    val mediaAttachments: V1InstanceConfigurationMediaAttachments,

    /**
     * Limits related to polls.
     */
    @SerialName("polls")
    val polls: V1InstanceConfigurationPolls
)
