package fr.outadoc.mastodonk.api.endpoint.v1.apps

/**
 * Request a new confirmation email, potentially to a new email address.
 *
 * @see [Official Docs](https://docs.joinmastodon.org/methods/emails/)
 */
public interface EmailsApi {

    /**
     * Resend a new confirmation email.
     *
     * If an email is provided, updates the unconfirmed user's email
     * before resending the confirmation email.
     *
     * @param email If provided, updates the unconfirmed user's email
     * before resending the confirmation email.
     */
    public suspend fun resendConfirmationEmail(email: String? = null)
}
