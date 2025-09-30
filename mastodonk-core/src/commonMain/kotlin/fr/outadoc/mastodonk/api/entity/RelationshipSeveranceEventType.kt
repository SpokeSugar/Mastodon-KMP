package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Type of relationship severance event.
 */
@Serializable
public enum class RelationshipSeveranceEventType {
    /**
     * A moderator suspended a whole domain.
     */
    @SerialName("domain_block")
    DomainBlock,

    /**
     * The user blocked a whole domain.
     */
    @SerialName("user_domain_block")
    UserDomainBlock,

    /**
     * A moderator suspended a specific account.
     */
    @SerialName("account_suspension")
    AccountSuspension
}
