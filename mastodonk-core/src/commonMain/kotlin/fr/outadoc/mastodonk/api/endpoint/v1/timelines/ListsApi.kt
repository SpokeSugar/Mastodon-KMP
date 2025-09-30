package fr.outadoc.mastodonk.api.endpoint.v1.timelines

import fr.outadoc.mastodonk.api.entity.Account
import fr.outadoc.mastodonk.api.entity.UserList
import fr.outadoc.mastodonk.api.entity.ListRepliesPolicy
import fr.outadoc.mastodonk.api.entity.paging.Page
import fr.outadoc.mastodonk.api.entity.paging.PageInfo

/**
 * View and manage lists.
 *
 * @see [Official Docs](https://docs.joinmastodon.org/methods/timelines/lists/)
 */
public interface ListsApi {

    /**
     * Fetches all lists owned by the account.
     */
    public suspend fun getLists(): List<UserList>

    /**
     * Fetches the list with the given [listId].
     */
    public suspend fun getList(listId: String): UserList

    /**
     * Creates a new list.
     */
    public suspend fun createList(
        title: String,
        repliesPolicy: ListRepliesPolicy? = null,
        exclusive: Boolean? = null
    ): UserList

    /**
     * Changes the title of a list, or which replies to show.
     */
    public suspend fun updateList(
        listId: String,
        title: String? = null,
        repliesPolicy: ListRepliesPolicy? = null,
        exclusive: Boolean? = null
    ): UserList

    /**
     * Deletes a list.
     */
    public suspend fun deleteList(listId: String)

    /**
     * Gets the list of accounts in the given list.
     */
    public suspend fun getAccountsInList(
        listId: String,
        limit: Int? = null,
        pageInfo: PageInfo? = null
    ): Page<List<Account>>?

    /**
     * Adds the given accounts to the given list.
     *
     * Note that the current account must be following these accounts.
     */
    public suspend fun addAccountsToList(listId: String, accountIds: List<String>)

    /**
     * Removes the given accounts from the given list.
     */
    public suspend fun removeAccountsFromList(listId: String, accountIds: List<String>)
}
