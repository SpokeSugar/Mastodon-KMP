package fr.outadoc.mastodonk.api.endpoint.v1.timelines

import fr.outadoc.mastodonk.api.entity.Conversation
import fr.outadoc.mastodonk.api.entity.paging.Page
import fr.outadoc.mastodonk.api.entity.paging.PageInfo

/**
 * Direct conversations with other participants.
 *
 * (Currently, just threads containing a post with "direct" visibility.)
 *
 * @see [Official Docs](https://docs.joinmastodon.org/methods/conversations/)
 */
public interface ConversationsApi {

    /**
     * View all conversations.
     *
     * @param limit Maximum number of results to return. Defaults to 20. Max 40.
     * @param pageInfo Paging information.
     */
    public suspend fun getConversations(limit: Int? = null, pageInfo: PageInfo? = null): Page<List<Conversation>>

    /**
     * Removes a conversation from your list of conversations.
     *
     * @param conversationId The ID of the [Conversation] in the database.
     */
    public suspend fun deleteConversation(conversationId: String)

    /**
     * Mark a conversation as read.
     *
     * @param conversationId The ID of the [Conversation] in the database.
     * @return The updated [Conversation].
     */
    public suspend fun markAsRead(conversationId: String): Conversation
}
