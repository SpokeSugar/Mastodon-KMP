package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a list of some users that the authenticated user follows.
 *
 * This entity is named UserList to avoid conflicts with [kotlin.collections.List].
 */
@Serializable
public data class UserList(
    /**
     * The ID of the list.
     */
    @SerialName("id")
    val listId: String,

    /**
     * The user-defined title of the list.
     */
    @SerialName("title")
    val title: String,

    /**
     * Which replies should be shown in the list.
     */
    @SerialName("replies_policy")
    val replyPolicy: ListRepliesPolicy,

    /**
     * Whether members of the list should be removed from the "Home" feed.
     */
    @SerialName("exclusive")
    val exclusive: Boolean? = null
)
