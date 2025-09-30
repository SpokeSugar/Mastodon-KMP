package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class UserInfo(
    @SerialName("iss")
    public val issuer: String,
    @SerialName("sub")
    public val subject: String,
    @SerialName("name")
    public val name: String,
    @SerialName("preferred_username")
    public val preferredUsername: String,
    @SerialName("profile")
    public val profile: String,
    @SerialName("picture")
    public val picture: String
)
