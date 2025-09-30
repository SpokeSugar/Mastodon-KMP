package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Action taken against an account in a moderation warning.
 */
@Serializable
public enum class AccountWarningAction {
    /** No action was taken, this is a simple warning. */
    @SerialName("none")
    NONE,

    /** The account has been disabled. */
    @SerialName("disable")
    DISABLE,

    /** Specific posts from the target account have been marked as sensitive. */
    @SerialName("mark_statuses_as_sensitive")
    MARK_STATUSES_AS_SENSITIVE,

    /** Specific statuses from the target account have been deleted. */
    @SerialName("delete_statuses")
    DELETE_STATUSES,

    /** All posts from the target account are marked as sensitive. */
    @SerialName("sensitive")
    SENSITIVE,

    /** The target account has been limited. */
    @SerialName("silence")
    SILENCE,

    /** The target account has been suspended. */
    @SerialName("suspend")
    SUSPEND
}
