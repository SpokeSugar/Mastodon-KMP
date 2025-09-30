package fr.outadoc.mastodonk.api.endpoint.v1.instance

import fr.outadoc.mastodonk.api.entity.Activity
import fr.outadoc.mastodonk.api.entity.DomainBlock
import fr.outadoc.mastodonk.api.entity.ExtendedDescription
import fr.outadoc.mastodonk.api.entity.PrivacyPolicy
import fr.outadoc.mastodonk.api.entity.Rule
import fr.outadoc.mastodonk.api.entity.TermsOfService
import fr.outadoc.mastodonk.api.entity.V1Instance
import kotlinxs.datetime.LocalDate

/**
 * Informational endpoint to discover information about a Mastodon instance.
 *
 * @see [Official Docs](https://docs.joinmastodon.org/methods/instance/)
 */
public interface V1InstanceApi {

    /**
     * Gets information about the Mastodon instance.
     * @see [Official Docs](https://docs.joinmastodon.org/methods/instance/#v1)
     */
    public suspend fun getInstanceInfo(): V1Instance

    /**
     * Gets the list of domains that this instance is aware of.
     * @see [Official Docs](https://docs.joinmastodon.org/methods/instance/#peers)
     */
    public suspend fun getPeers(): List<String>

    /**
     * Gets the instance's activity over the last 3 months, binned weekly.
     * @see [Official Docs](https://docs.joinmastodon.org/methods/instance/#activity)
     */
    public suspend fun getActivity(): List<Activity>

    /**
     * Gets the rules that the users of this service should follow.
     * @see [Official Docs](https://docs.joinmastodon.org/methods/instance/#rules)
     */
    public suspend fun getRules(): List<Rule>

    /**
     * Gets the list of blocked domains.
     * @see [Official Docs](https://docs.joinmastodon.org/methods/instance/#domain_blocks)
     */
    public suspend fun getBlockedDomains(): List<DomainBlock>

    /**
     * Obtain an extended description of this server.
     * @see [Official Docs](https://docs.joinmastodon.org/methods/instance/#extended_description)
     */
    public suspend fun getExtendedDescription(): ExtendedDescription

    /**
     * Obtain the contents of this server's privacy policy.
     * @see [Official Docs](https://docs.joinmastodon.org/methods/instance/#privacy_policy)
     */
    public suspend fun getPrivacyPolicy(): PrivacyPolicy

    /**
     * Obtain the contents of this server's terms of service, if configured.
     * @see [Official Docs](https://docs.joinmastodon.org/methods/instance/#terms_of_service)
     */
    public suspend fun getTermsOfService(): TermsOfService

    /**
     * Obtain the contents of this server's terms of service, for a specified date, if configured.
     * @see [Official Docs](https://docs.joinmastodon.org/methods/instance/#terms_of_service_date)
     */
    public suspend fun getTermsOfService(date: LocalDate): TermsOfService

    /**
     * Translation language pairs supported by the translation engine used by the server.
     * @see [Official Docs](https://docs.joinmastodon.org/methods/instance/#translation_languages)
     */
    public suspend fun getTranslationLanguages(): Map<String, List<String>>
}
