package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class OAuthServerConfiguration(
    @SerialName("issuer")
    public val issuer: String,
    @SerialName("service_documentation")
    public val serviceDocumentation: String? = null,
    @SerialName("authorization_endpoint")
    public val authorizationEndpoint: String,
    @SerialName("token_endpoint")
    public val tokenEndpoint: String,
    @SerialName("app_registration_endpoint")
    public val appRegistrationEndpoint: String? = null,
    @SerialName("revocation_endpoint")
    public val revocationEndpoint: String,
    @SerialName("userinfo_endpoint")
    public val userinfoEndpoint: String? = null,
    @SerialName("scopes_supported")
    public val scopesSupported: List<String>,
    @SerialName("response_types_supported")
    public val responseTypesSupported: List<String>,
    @SerialName("response_modes_supported")
    public val responseModesSupported: List<String>? = null,
    @SerialName("code_challenge_methods_supported")
    public val codeChallengeMethodsSupported: List<String>,
    @SerialName("grant_types_supported")
    public val grantTypesSupported: List<String>,
    @SerialName("token_endpoint_auth_methods_supported")
    public val tokenEndpointAuthMethodsSupported: List<String>? = null
)
