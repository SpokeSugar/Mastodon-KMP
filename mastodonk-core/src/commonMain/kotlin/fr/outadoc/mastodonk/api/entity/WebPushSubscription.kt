package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class WebPushSubscription(
    @SerialName("id")
    val id: String,

    @SerialName("endpoint")
    val endpoint: String,

    @SerialName("standard")
    val standard: Boolean? = null,

    @SerialName("alerts")
    val alerts: WebPushSubscriptionAlerts,

    @SerialName("server_key")
    val serverKey: String
)
