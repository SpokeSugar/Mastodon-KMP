package fr.outadoc.mastodonk.api.endpoint.v1.instance

import fr.outadoc.mastodonk.api.entity.Health

/**
 * Check the health of the web process for the instance.
 */
public interface HealthApi {

    /**
     * Check on the state of the web process for the Mastodon instance.
     */
    public suspend fun getHealth(): Health
}