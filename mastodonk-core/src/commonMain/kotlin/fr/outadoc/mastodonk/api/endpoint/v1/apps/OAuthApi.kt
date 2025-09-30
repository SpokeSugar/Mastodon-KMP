package fr.outadoc.mastodonk.api.endpoint.v1.apps

import fr.outadoc.mastodonk.api.entity.OAuthServerConfiguration
import fr.outadoc.mastodonk.api.entity.Token
import fr.outadoc.mastodonk.api.entity.UserInfo
import fr.outadoc.mastodonk.api.entity.request.AuthorizeGet
import fr.outadoc.mastodonk.api.entity.request.TokenGet
import fr.outadoc.mastodonk.api.entity.request.TokenRevoke

/**
 * Generate and manage OAuth tokens.
 *
 * @see [Official Docs](https://docs.joinmastodon.org/methods/apps/oauth/)
 */
public interface OAuthApi {

    /**
     * Constructs the URL to authorize a user.
     *
     * Displays an authorization form to the user. If approved, it will create and return an
     * authorization code, then redirect to the desired `redirect_uri`, or show the authorization
     * code if `urn:ietf:wg:oauth:2.0:oob` was requested. The authorization code can be used
     * while requesting a token to obtain access to user-level methods.
     *
     * This method returns the URL string to which the application should redirect the user.
     *
     * @param params Parameters for the authorization request.
     * @return The fully constructed URL for the authorization endpoint.
     * @see [Official Docs for Authorize a user](https://docs.joinmastodon.org/methods/apps/oauth/#authorize)
     */
    public suspend fun authorize(params: AuthorizeGet): String

    /**
     * Obtain an access token, to be used during API calls that are not public.
     *
     * @param params Parameters to obtain the token.
     * @return The obtained [Token].
     * @see [Official Docs for Obtain a token](https://docs.joinmastodon.org/methods/apps/oauth/#token)
     */
    public suspend fun getToken(params: TokenGet): Token

    /**
     * Revoke an access token to make it no longer valid for use.
     *
     * @param params Parameters to revoke the token.
     * @see [Official Docs for Revoke a token](https://docs.joinmastodon.org/methods/apps/oauth/#revoke)
     */
    public suspend fun revokeToken(params: TokenRevoke)

    /**
     * Retrieves standardised OIDC claims about the currently authenticated user.
     * Requires the `profile` scope.
     *
     * @return [UserInfo] for the authenticated user.
     * @see [Official Docs for Retrieve user information](https://docs.joinmastodon.org/methods/apps/oauth/#userinfo)
     */
    public suspend fun getUserInfo(): UserInfo

    /**
     * Returns the OAuth 2 Authorization Server Metadata for the Mastodon server.
     * This can be used to discover OAuth endpoints and supported features.
     *
     * @return [OAuthServerConfiguration] for the server.
     * @see [Official Docs for Discover OAuth Server Configuration](https://docs.joinmastodon.org/methods/apps/oauth/#authorization-server-metadata)
     */
    public suspend fun getServerConfiguration(): OAuthServerConfiguration
}
