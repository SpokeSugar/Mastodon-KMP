package fr.outadoc.mastodonk.api.endpoint.v1.profile

import fr.outadoc.mastodonk.api.entity.CredentialAccount

/**
 * Manage the current user's profile.
 *
 * @see [Official Docs](https://docs.joinmastodon.org/methods/profile/)
 */
public interface ProfileApi {

    /**
     * Deletes the avatar associated with the user's profile.
     *
     * @see [Official Docs](https://docs.joinmastodon.org/methods/profile/#avatar)
     */
    public suspend fun deleteProfileAvatar(): CredentialAccount

    /**
     * Deletes the header image associated with the user's profile.
     *
     * @see [Official Docs](https://docs.joinmastodon.org/methods/profile/#header)
     */
    public suspend fun deleteProfileHeader(): CredentialAccount
}
