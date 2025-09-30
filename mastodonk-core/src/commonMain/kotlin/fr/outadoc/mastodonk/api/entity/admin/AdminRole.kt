package fr.outadoc.mastodonk.api.entity.admin

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The different roles that can be attributed to an [fr.outadoc.mastodonk.api.entity.Account].
 */
@Serializable
public enum class AdminRole {

    @SerialName("admin")
    Admin,

    @SerialName("moderator")
    Moderator,

    @SerialName("user")
    User
}
