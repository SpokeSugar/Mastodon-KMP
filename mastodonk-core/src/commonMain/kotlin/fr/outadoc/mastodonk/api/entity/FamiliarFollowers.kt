package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.collections.List

/**
 * Represents a subset of your follows who also follow some other user.
 */
@Serializable
public data class FamiliarFollowers(
    /**
     * The ID of the Account in the database.
     */
    @SerialName("id")
    val id: String,

    /**
     * Accounts you follow that also follow this account.
     */
    @SerialName("accounts")
    val accounts: List<Account>
)
