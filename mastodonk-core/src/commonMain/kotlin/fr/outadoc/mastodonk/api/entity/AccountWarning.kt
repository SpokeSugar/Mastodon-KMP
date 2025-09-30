package fr.outadoc.mastodonk.api.entity

import fr.outadoc.mastodonk.serializer.TimestampToInstantSerializer
import kotlinx.datetime.Instant
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Moderation warning against a particular account.
 */
@Serializable
public data class AccountWarning(

    /** The ID of the account warning. */
    @SerialName("id")
    val id: String,

    /** Action taken against the account. */
    @SerialName("action")
    val action: AccountWarningAction,

    /** Message from the moderator to the target account. */
    @SerialName("text")
    val text: String,

    /** List of status IDs that are relevant to the warning. */
    @SerialName("status_ids")
    val statusIds: List<String>? = null,

    /** Account against which a moderation decision has been taken. */
    @SerialName("target_account")
    val targetAccount: Account,

    /** Appeal submitted by the target account, if any. */
    @SerialName("appeal")
    val appeal: Appeal? = null,

    /** When the event took place. */
    @SerialName("created_at")
    @Serializable(with = TimestampToInstantSerializer::class)
    val createdAt: Instant
)
