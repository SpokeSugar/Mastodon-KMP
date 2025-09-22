package fr.outadoc.mastodonk.client

import io.ktor.client.*
import io.ktor.client.engine.java.Java

internal actual class HttpClientFactory {

    actual fun create() = HttpClient(Java)
}
