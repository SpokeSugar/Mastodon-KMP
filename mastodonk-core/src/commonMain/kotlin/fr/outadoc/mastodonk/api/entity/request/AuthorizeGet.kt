package fr.outadoc.mastodonk.api.entity.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class AuthorizeGet(
    @SerialName("response_type")
    public val responseType: String = "code",
    @SerialName("client_id")
    public val clientId: String,
    @SerialName("redirect_uri")
    public val redirectUri: String,
    @SerialName("scope")
    public val scope: String? = null,
    @SerialName("state")
    public val state: String? = null,
    @SerialName("code_challenge")
    public val codeChallenge: String? = null,
    @SerialName("code_challenge_method")
    public val codeChallengeMethod: String? = null,
    @SerialName("force_login")
    public val forceLogin: Boolean? = null,
    @SerialName("lang")
    public val lang: String? = null
)
