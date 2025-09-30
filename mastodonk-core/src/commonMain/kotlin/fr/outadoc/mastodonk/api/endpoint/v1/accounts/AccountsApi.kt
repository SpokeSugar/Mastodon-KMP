package fr.outadoc.mastodonk.api.endpoint.v1.accounts

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
import fr.outadoc.mastodonk.api.entity.request.AccountCreate
import fr.outadoc.mastodonk.api.entity.request.File

/**
 * Methods concerning user accounts and related information.
 *
 * @see [Official Docs](https://docs.joinmastodon.org/methods/accounts/)
 */
public interface AccountsApi {

    // region Account credentials

    /**
     * Creates a user and account records.
     *
     * @return Account access token for the app that initiated the request.
     * The app should save this token for later, and should wait for the user to confirm
     * their account by clicking a link in their email inbox.
     */
    public suspend fun createAccount(account: AccountCreate): Token

    /**
     * Verifies that the user token works.
     */
    public suspend fun verifyCredentials(): Account

    /**
     * Updates the user's display and preferences.
     *
     * @param displayName The account's display name.
     * @param note The account bio.
     * @param avatar The account's avatar.
     * @param header The account's header image.
     * @param isBot Whether the account should identify itself as a bot.
     * @param isDiscoverable Whether the account should be shown in the profile directory.
     * @param isLocked Whether manual approval of follow requests is required.
     * @param isSensitive Whether to mark authored statuses as sensitive by default.
     * @param privacy Default post privacy for authored statuses.
     * @param language Default language to use for authored statuses. (ISO 639-1)
     * @param fields Profile metadata name and value.
     * @param hideCollections Whether to hide followers and followed accounts.
     * @param indexable Whether public posts should be searchable to anyone.
     * @param quotePolicy Default quote policy for new posts.
     */
    public suspend fun updateCredentials(
        displayName: String? = null,
        note: String? = null,
        avatar: File? = null,
        header: File? = null,
        isBot: Boolean? = null,
        isDiscoverable: Boolean? = null,
        isLocked: Boolean? = null,
        isSensitive: Boolean? = null,
        privacy: StatusVisibility? = null,
        language: String? = null,
        fields: List<Field>? = null,
        hideCollections: Boolean? = null,
        indexable: Boolean? = null,
        quotePolicy: String? = null
    ): Account

    // endregion

    // region Retrieve information

    /**
     * Gets information about a profile.
     */
    public suspend fun getAccount(accountId: String): Account?

    /**
     * View information about multiple profiles.
     */
    public suspend fun getAccounts(accountIds: List<String>): List<Account>

    /**
     * Gets statuses posted by the given account.
     *
     * @param onlyMedia Filter out statuses without attachments.
     * @param excludeReplies Filter out statuses in reply to a different account.
     * @param excludeReblogs Filter out boosts from the response.
     * @param pinned Filter for pinned statuses only.
     * @param tagged Filter for statuses using a specific hashtag.
     */
    public suspend fun getStatuses(
        accountId: String,
        limit: Int? = null,
        pageInfo: PageInfo? = null,
        onlyMedia: Boolean? = null,
        excludeReplies: Boolean? = null,
        excludeReblogs: Boolean? = null,
        pinned: Boolean? = null,
        tagged: String? = null
    ): Page<List<Status>>?

    /**
     * Gets the list of accounts which follow the given account,
     * if network is not hidden by the account owner.
     */
    public suspend fun getFollowers(
        accountId: String,
        limit: Int? = null,
        pageInfo: PageInfo? = null
    ): Page<List<Account>>?

    /**
     * Gets the list of accounts which the given account is following,
     * if network is not hidden by the account owner.
     */
    public suspend fun getFollowing(
        accountId: String,
        limit: Int? = null,
        pageInfo: PageInfo? = null
    ): Page<List<Account>>?

    /**
     * Gets tags featured by this account.
     */
    public suspend fun getFeaturedTags(accountId: String): List<FeaturedTag>?

    /**
     * Gets the user lists that you have added this account to.
     */
    public suspend fun getListsContainedIn(accountId: String): List<UserList>?

    /**
     * Gets identity proofs for this account.
     */
    @Deprecated("This method is deprecated and will be removed in a future version.")
    public suspend fun getIdentityProofs(accountId: String): List<IdentityProof>?

    /**
     * Accounts that the user is currently featuring on their profile.
     */
    public suspend fun getEndorsements(
        accountId: String,
        limit: Int? = null,
        pageInfo: PageInfo? = null
    ): Page<List<Account>>?

    // endregion

    // region Perform actions on an account

    /**
     * Follows the given account.
     *
     * Can also be used to update whether to show reblogs or enable notifications.
     *
     * @param languages Filter received statuses for these languages.
     */
    public suspend fun followAccount(
        accountId: String,
        reblogs: Boolean? = null,
        notify: Boolean? = null,
        languages: List<String>? = null
    ): Relationship

    /**
     * Unfollows the given account.
     */
    public suspend fun unfollowAccount(accountId: String): Relationship

    /**
     * Remove the given account from your followers.
     */
    public suspend fun removeFollower(accountId: String): Relationship

    /**
     * Blocks the given account.
     *
     * Clients should filter statuses from this account,
     * if received (e.g. due to a boost in the Home timeline).
     */
    public suspend fun blockAccount(accountId: String): Relationship

    /**
     * Unblocks the given account.
     */
    public suspend fun unblockAccount(accountId: String): Relationship

    /**
     * Mutes the given account.
     *
     * Clients should filter statuses and notifications from this account,
     * if received (e.g. due to a boost in the Home timeline).
     *
     * @param notifications Mute notifications in addition to statuses? Defaults to true.
     * @param duration How long the mute should last, in seconds. Defaults to 0 (indefinite).
     */
    public suspend fun muteAccount(
        accountId: String,
        notifications: Boolean? = null,
        duration: Long? = null
    ): Relationship

    /**
     * Unmutes the given account.
     */
    public suspend fun unmuteAccount(accountId: String): Relationship

    /**
     * Adds the given account to the user's featured profiles.
     */
    @Deprecated(
        "Renamed to endorseAccount",
        replaceWith = ReplaceWith("endorseAccount(accountId)")
    )
    public suspend fun featureAccount(accountId: String): Relationship

    /**
     * Removes the given account from the user's featured profiles.
     */
    @Deprecated(
        "Renamed to unendorseAccount",
        replaceWith = ReplaceWith("unendorseAccount(accountId)")
    )
    public suspend fun unfeatureAccount(accountId: String): Relationship

    /**
     * Add the given account to the user's featured profiles.
     */
    public suspend fun endorseAccount(accountId: String): Relationship

    /**
     * Remove the given account from the user's featured profiles.
     */
    public suspend fun unendorseAccount(accountId: String): Relationship

    /**
     * Sets a private note on a user.
     */
    public suspend fun setNoteOnAccount(accountId: String, comment: String? = null): Relationship

    // endregion

    // region General account actions

    /**
     * Gets the relationship between the current account and the given accounts.
     *
     * Find out whether given accounts are followed, blocked, muted, etc.
     *
     * @param withSuspended Whether relationships should be returned for suspended users.
     */
    public suspend fun getRelationships(
        accountIds: List<String>,
        withSuspended: Boolean? = null
    ): List<Relationship>?

    /**
     * Obtain a list of all accounts that follow a given account, filtered for accounts you follow.
     */
    public suspend fun getFamiliarFollowers(accountIds: List<String>): List<FamiliarFollowers>

    /**
     * Searches for matching accounts by username or display name.
     *
     * @param offset Skip the first n results.
     */
    public suspend fun search(
        query: String,
        limit: Int? = null,
        offset: Int? = null,
        resolve: Boolean? = null,
        following: Boolean? = null
    ): List<Account>

    /**
     * Quickly lookup a username to see if it is available, skipping WebFinger resolution.
     */
    public suspend fun lookupAccount(acct: String): Account?

    // endregion
}