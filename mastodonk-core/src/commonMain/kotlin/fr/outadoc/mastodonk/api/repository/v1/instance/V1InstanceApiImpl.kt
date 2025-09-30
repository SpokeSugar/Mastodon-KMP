package fr.outadoc.mastodonk.api.repository.v1.instance

import fr.outadoc.mastodonk.api.endpoint.v1.instance.V1InstanceApi
import fr.outadoc.mastodonk.api.entity.Activity
import fr.outadoc.mastodonk.api.entity.DomainBlock
import fr.outadoc.mastodonk.api.entity.ExtendedDescription
import fr.outadoc.mastodonk.api.entity.PrivacyPolicy
import fr.outadoc.mastodonk.api.entity.Rule
import fr.outadoc.mastodonk.api.entity.TermsOfService
import fr.outadoc.mastodonk.api.entity.V1Instance
import fr.outadoc.mastodonk.client.MastodonHttpClient
import io.ktor.http.HttpMethod
import kotlinx.datetime.LocalDate

internal class V1InstanceApiImpl(private val client: MastodonHttpClient) : V1InstanceApi {

    override suspend fun getInstanceInfo(): V1Instance {
        return client.request("/api/v1/instance") {
            method = HttpMethod.Get
        }
    }

    override suspend fun getPeers(): List<String> {
        return client.request("/api/v1/instance/peers") {
            method = HttpMethod.Get
        }
    }

    override suspend fun getActivity(): List<Activity> {
        return client.request("/api/v1/instance/activity") {
            method = HttpMethod.Get
        }
    }

    override suspend fun getRules(): List<Rule> {
        return client.request("/api/v1/instance/rules") {
            method = HttpMethod.Get
        }
    }

    override suspend fun getBlockedDomains(): List<DomainBlock> {
        return client.request("/api/v1/instance/domain_blocks") {
            method = HttpMethod.Get
        }
    }

    override suspend fun getExtendedDescription(): ExtendedDescription {
        return client.request("/api/v1/instance/extended_description") {
            method = HttpMethod.Get
        }
    }

    override suspend fun getPrivacyPolicy(): PrivacyPolicy {
        return client.request("/api/v1/instance/privacy_policy") {
            method = HttpMethod.Get
        }
    }

    override suspend fun getTermsOfService(): TermsOfService {
        return client.request("/api/v1/instance/terms_of_service") {
            method = HttpMethod.Get
        }
    }

    override suspend fun getTermsOfService(date: LocalDate): TermsOfService {
        return client.request("/api/v1/instance/terms_of_service/$date") {
            method = HttpMethod.Get
        }
    }

    override suspend fun getTranslationLanguages(): Map<String, List<String>> {
        return client.request("/api/v1/instance/translation_languages") {
            method = HttpMethod.Get
        }
    }
}
