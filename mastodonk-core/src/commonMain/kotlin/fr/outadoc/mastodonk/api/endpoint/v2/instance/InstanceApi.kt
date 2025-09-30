package fr.outadoc.mastodonk.api.endpoint.v2.instance

import fr.outadoc.mastodonk.api.entity.Instance

/**
 * Obtain general information about the server.
 *
 * @see [Official Docs](https://docs.joinmastodon.org/methods/instance/#v2)
 */
public interface InstanceApi {

    /**
     * Obtain general information about the server.
     */
    public suspend fun getInstance(): Instance
}
