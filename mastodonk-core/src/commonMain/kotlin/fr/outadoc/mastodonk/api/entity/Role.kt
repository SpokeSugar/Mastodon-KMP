package fr.outadoc.mastodonk.api.entity

import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a custom user role that grants permissions.
 */
@Serializable
public data class Role(

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
    val color: String,

    /**
     * A bitmask that represents the sum of all permissions granted to the role.
     */
    @SerialName("permissions")
    val permissions: Permissions,

    /**
     * Whether the role is publicly visible as a badge on user profiles.
     */
    @SerialName("highlighted")
    val highlighted: Boolean,
)
