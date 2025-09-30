package fr.outadoc.mastodonk.api.endpoint.v1.tags

import fr.outadoc.mastodonk.api.entity.Tag

/**
 * View information about or follow/unfollow hashtags.
 *
 * @see [Official Docs](https://docs.joinmastodon.org/methods/tags/)
 */
public interface TagsApi {

    /**
     * Show a hashtag and its associated information.
     *
     * @param name The name of the hashtag, case-insensitive.
     */
    public suspend fun getTag(name: String): Tag

    /**
     * Follow a hashtag.
     *
     * Posts containing a followed hashtag will be inserted into your home timeline.
     *
     * @param name The name of the hashtag, case-insensitive.
     */
    public suspend fun followTag(name: String): Tag

    /**
     * Unfollow a hashtag.
     *
     * Posts containing this hashtag will no longer be inserted into your home timeline.
     *
     * @param name The name of the hashtag, case-insensitive.
     */
    public suspend fun unfollowTag(name: String): Tag

    /**
     * Feature the hashtag on your profile.
     *
     * @param id The ID of the hashtag (Note: Docs path param is :id, description says name. Using ID as per path).
     */
    public suspend fun featureTag(id: String): Tag

    /**
     * Stop featuring the hashtag on your profile.
     *
     * @param id The ID of the hashtag (Note: Docs path param is :id, description says name. Using ID as per path).
     */
    public suspend fun unfeatureTag(id: String): Tag
}
