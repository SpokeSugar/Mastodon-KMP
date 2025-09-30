package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The simplified role entity returned in the Account `roles` array,
 * containing only public role information.
 *
 * @see [API LDoc](https://docs.joinmastodon.org/entities/Account/#AccountRole)
 */
@Serializable
public data class AccountRole(
    /**
     * The ID of the Role in the database.
     */
    @SerialName("id")
    val id: String,

    /**
     * The name of the role.
     */
    @SerialName("name")
    val name: String,

    /**
     * The hex code assigned to this role.
     * If no hex code is assigned, the string will be empty.
     */
    @SerialName("color")
    val color: String
)
