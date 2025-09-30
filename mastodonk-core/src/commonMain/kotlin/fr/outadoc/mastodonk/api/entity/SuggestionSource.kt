package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The reason a suggested account is being suggested.
 */
@Serializable
public enum class SuggestionSource {

    /**
     * This account was manually recommended by the administration team.
     * @deprecated Replaced by [FEATURED].
     */
    @SerialName("staff")
    STAFF,

    /**
     * The authenticated account has interacted with this account previously.
     * @deprecated
     */
    @SerialName("past_interactions")
    PAST_INTERACTIONS,

    /**
     * This account has many reblogs, favourites, and active local followers within the last 30 days.
     * @deprecated Replaced by [MOST_INTERACTIONS] and [MOST_FOLLOWED].
     */
    @SerialName("global")
    GLOBAL,

    /**
     * This account was manually recommended by the administration team.
     * Equivalent to the `staff` value for `source`.
     */
    @SerialName("featured")
    FEATURED,

    /**
     * This account has many active local followers.
     */
    @SerialName("most_followed")
    MOST_FOLLOWED,

    /**
     * This account had many reblogs and favourites within the last 30 days.
     */
    @SerialName("most_interactions")
    MOST_INTERACTIONS,

    /**
     * This account's profile is similar to the authenticated account's most recent follows.
     */
    @SerialName("similar_to_recently_followed")
    SIMILAR_TO_RECENTLY_FOLLOWED,

    /**
     * This account is followed by people followed by the authenticated account.
     */
    @SerialName("friends_of_friends")
    FRIENDS_OF_FRIENDS
}
