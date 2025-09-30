package fr.outadoc.mastodonk.api.repository.v1.accounts

import fr.outadoc.mastodonk.api.endpoint.v1.accounts.AccountsApi
import fr.outadoc.mastodonk.api.entity.Account
import fr.outadoc.mastodonk.api.entity.FamiliarFollowers
import fr.outadoc.mastodonk.api.entity.FeaturedTag
import fr.outadoc.mastodonk.api.entity.Field
import fr.outadoc.mastodonk.api.entity.IdentityProof
import fr.outadoc.mastodonk.api.entity.Relationship
import fr.outadoc.mastodonk.api.entity.Status
import fr.outadoc.mastodonk.api.entity.StatusVisibility
import fr.outadoc.mastodonk.api.entity.Token
import fr.outadoc.mastodonk.api.entity.UserList
import fr.outadoc.mastodonk.api.entity.paging.Page
import fr.outadoc.mastodonk.api.entity.paging.PageInfo
import fr.outadoc.mastodonk.api.entity.paging.parameter
import fr.outadoc.mastodonk.api.entity.request.AccountCreate
import fr.outadoc.mastodonk.api.entity.request.File
import fr.outadoc.mastodonk.api.entity.request.toFormPart
import fr.outadoc.mastodonk.client.MastodonHttpClient
import io.ktor.client.request.forms.formData
import io.ktor.client.request.parameter
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.HttpMethod
import io.ktor.http.contentType

internal class AccountsApiImpl(private val client: MastodonHttpClient) : AccountsApi {

    override suspend fun createAccount(account: AccountCreate): Token {
        return client.request("/api/v1/accounts") {
            method = HttpMethod.Post
            contentType(ContentType.Application.Json)
            setBody(account)
        }
    }

    override suspend fun verifyCredentials(): Account {
        return client.request("/api/v1/accounts/verify_credentials") {
            method = HttpMethod.Get
        }
    }

    override suspend fun updateCredentials(
        displayName: String?,
        note: String?,
        avatar: File?,
        header: File?,
        isBot: Boolean?,
        isDiscoverable: Boolean?,
        isLocked: Boolean?,
        isSensitive: Boolean?,
        privacy: StatusVisibility?,
        language: String?,
        fields: List<Field>?,
        hideCollections: Boolean?,
        indexable: Boolean?,
        quotePolicy: String?
    ): Account {
        val avatarPart = avatar?.toFormPart("avatar")
        val headerPart = header?.toFormPart("header")

        return client.request("/api/v1/accounts/update_credentials") {
            method = HttpMethod.Patch
            formData {
                displayName?.let { append("display_name", it) }
                note?.let { append("note", it) }
                isBot?.let { append("bot", it.toString()) }
                isDiscoverable?.let { append("discoverable", it.toString()) }
                isLocked?.let { append("locked", it.toString()) }
                hideCollections?.let { append("hide_collections", it.toString()) }
                indexable?.let { append("indexable", it.toString()) }

                fields?.forEach {
                    append("fields_attributes[][name]", it.name)
                    append("fields_attributes[][value]", it.value)
                }

                privacy?.let { append("source[privacy]", it.value) }
                isSensitive?.let { append("source[sensitive]", it.toString()) }
                language?.let { append("source[language]", it) }
                quotePolicy?.let { append("source[quote_policy]", it) }

                avatarPart?.let { append(it) }
                headerPart?.let { append(it) }
            }
        }
    }

    override suspend fun getAccount(accountId: String): Account? {
        return client.requestOrNull("/api/v1/accounts/${accountId.trim()}") {
            method = HttpMethod.Get
        }
    }

    override suspend fun getAccounts(accountIds: List<String>): List<Account> {
        return client.request("/api/v1/accounts") {
            method = HttpMethod.Get
            accountIds.forEach { id ->
                parameter("id[]", id)
            }
        }
    }

    override suspend fun getStatuses(
        accountId: String,
        limit: Int?,
        pageInfo: PageInfo?,
        onlyMedia: Boolean?,
        excludeReplies: Boolean?,
        excludeReblogs: Boolean?,
        pinned: Boolean?,
        tagged: String?
    ): Page<List<Status>>? {
        return client.requestPageOrNull("/api/v1/accounts/${accountId.trim()}/statuses") {
            method = HttpMethod.Get
            parameter("limit", limit)
            parameter(pageInfo)
            parameter("only_media", onlyMedia)
            parameter("exclude_replies", excludeReplies)
            parameter("exclude_reblogs", excludeReblogs)
            parameter("pinned", pinned)
            parameter("tagged", tagged)
        }
    }

    override suspend fun getFollowers(
        accountId: String,
        limit: Int?,
        pageInfo: PageInfo?
    ): Page<List<Account>>? {
        return client.requestPageOrNull("/api/v1/accounts/${accountId.trim()}/followers") {
            method = HttpMethod.Get
            parameter("limit", limit)
            parameter(pageInfo)
        }
    }

    override suspend fun getFollowing(
        accountId: String,
        limit: Int?,
        pageInfo: PageInfo?
    ): Page<List<Account>>? {
        return client.requestPageOrNull("/api/v1/accounts/${accountId.trim()}/following") {
            method = HttpMethod.Get
            parameter("limit", limit)
            parameter(pageInfo)
        }
    }

    override suspend fun getFeaturedTags(accountId: String): List<FeaturedTag>? {
        return client.requestOrNull("/api/v1/accounts/${accountId.trim()}/featured_tags") {
            method = HttpMethod.Get
        }
    }

    override suspend fun getListsContainedIn(accountId: String): List<UserList>? {
        return client.requestOrNull("/api/v1/accounts/${accountId.trim()}/lists") {
            method = HttpMethod.Get
        }
    }

    @Deprecated("This method is deprecated and will be removed in a future version.")
    override suspend fun getIdentityProofs(accountId: String): List<IdentityProof>? {
        return client.requestOrNull("/api/v1/accounts/${accountId.trim()}/identity_proofs") {
            method = HttpMethod.Get
        }
    }

    override suspend fun getEndorsements(
        accountId: String,
        limit: Int?,
        pageInfo: PageInfo?
    ): Page<List<Account>>? {
        return client.requestPageOrNull("/api/v1/accounts/${accountId.trim()}/endorsements") {
            method = HttpMethod.Get
            parameter("limit", limit)
            parameter(pageInfo)
        }
    }

    override suspend fun followAccount(
        accountId: String,
        reblogs: Boolean?,
        notify: Boolean?,
        languages: List<String>?
    ): Relationship {
        return client.request("/api/v1/accounts/${accountId.trim()}/follow") {
            method = HttpMethod.Post
            formData {
                reblogs?.let { append("reblogs", it.toString()) }
                notify?.let { append("notify", it.toString()) }
                languages?.forEach { append("languages[]", it) }
            }
        }
    }

    override suspend fun unfollowAccount(accountId: String): Relationship {
        return client.request("/api/v1/accounts/${accountId.trim()}/unfollow") {
            method = HttpMethod.Post
        }
    }

    override suspend fun removeFollower(accountId: String): Relationship {
        return client.request("/api/v1/accounts/${accountId.trim()}/remove_from_followers") {
            method = HttpMethod.Post
        }
    }

    override suspend fun blockAccount(accountId: String): Relationship {
        return client.request("/api/v1/accounts/${accountId.trim()}/block") {
            method = HttpMethod.Post
        }
    }

    override suspend fun unblockAccount(accountId: String): Relationship {
        return client.request("/api/v1/accounts/${accountId.trim()}/unblock") {
            method = HttpMethod.Post
        }
    }

    override suspend fun muteAccount(
        accountId: String,
        notifications: Boolean?,
        duration: Long?
    ): Relationship {
        return client.request("/api/v1/accounts/${accountId.trim()}/mute") {
            method = HttpMethod.Post
            formData {
                notifications?.let { append("notifications", it.toString()) }
                duration?.let { append("duration", it.toString()) }
            }
        }
    }

    override suspend fun unmuteAccount(accountId: String): Relationship {
        return client.request("/api/v1/accounts/${accountId.trim()}/unmute") {
            method = HttpMethod.Post
        }
    }

    @Deprecated(
        "Renamed to endorseAccount",
        replaceWith = ReplaceWith("endorseAccount(accountId)")
    )
    override suspend fun featureAccount(accountId: String): Relationship {
        return client.request("/api/v1/accounts/${accountId.trim()}/pin") {
            method = HttpMethod.Post
        }
    }

    @Deprecated(
        "Renamed to unendorseAccount",
        replaceWith = ReplaceWith("unendorseAccount(accountId)")
    )
    override suspend fun unfeatureAccount(accountId: String): Relationship {
        return client.request("/api/v1/accounts/${accountId.trim()}/unpin") {
            method = HttpMethod.Post
        }
    }

    override suspend fun endorseAccount(accountId: String): Relationship {
        return client.request("/api/v1/accounts/${accountId.trim()}/endorse") {
            method = HttpMethod.Post
        }
    }

    override suspend fun unendorseAccount(accountId: String): Relationship {
        return client.request("/api/v1/accounts/${accountId.trim()}/unendorse") {
            method = HttpMethod.Post
        }
    }

    override suspend fun setNoteOnAccount(accountId: String, comment: String?): Relationship {
        return client.request("/api/v1/accounts/${accountId.trim()}/note") {
            method = HttpMethod.Post
            formData {
                comment?.let { append("comment", it) }
            }
        }
    }

    override suspend fun getRelationships(
        accountIds: List<String>,
        withSuspended: Boolean?
    ): List<Relationship>? {
        return client.requestOrNull("/api/v1/accounts/relationships") {
            method = HttpMethod.Get
            accountIds.forEach { parameter("id[]", it) }
            parameter("with_suspended", withSuspended)
        }
    }

    override suspend fun getFamiliarFollowers(accountIds: List<String>): List<FamiliarFollowers> {
        return client.request("/api/v1/accounts/familiar_followers") {
            method = HttpMethod.Get
            accountIds.forEach { id ->
                parameter("id[]", id)
            }
        }
    }

    override suspend fun search(
        query: String,
        limit: Int?,
        offset: Int?,
        resolve: Boolean?,
        following: Boolean?
    ): List<Account> {
        return client.request("/api/v1/accounts/search") {
            method = HttpMethod.Get
            parameter("q", query)
            parameter("limit", limit)
            parameter("offset", offset)
            parameter("resolve", resolve)
            parameter("following", following)
        }
    }

    override suspend fun lookupAccount(acct: String): Account? {
        return client.requestOrNull("/api/v1/accounts/lookup") {
            method = HttpMethod.Get
            parameter("acct", acct)
        }
    }
}
