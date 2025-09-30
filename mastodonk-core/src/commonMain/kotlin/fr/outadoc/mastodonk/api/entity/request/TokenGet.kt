package fr.outadoc.mastodonk.api.entity.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class TokenGet(
    @SerialName("grant_type")
    public val grantType: String,
    @SerialName("client_id")
    public val clientId: String,
    @SerialName("client_secret")
    public val clientSecret: String,
    @SerialName("redirect_uri")
    public val redirectUri: String,
    @SerialName("code")
    public val code: String? = null,
    @SerialName("code_verifier")
    public val codeVerifier: String? = null,
    @SerialName("scope")
    public val scope: String? = null
)
