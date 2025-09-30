package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class WebPushSubscriptionAlerts(
    @SerialName("follow")
    val follow: Boolean? = null,
    @SerialName("favourite")
    val favourite: Boolean? = null,
    @SerialName("reblog")
    val reblog: Boolean? = null,
    @SerialName("mention")
    val mention: Boolean? = null,
    @SerialName("poll")
    val poll: Boolean? = null,
    @SerialName("status")
    val status: Boolean? = null,
    @SerialName("follow_request")
    val followRequest: Boolean? = null,
    @SerialName("update")
    val update: Boolean? = null,
    @SerialName("admin.sign_up")
    val adminSignUp: Boolean? = null,
    @SerialName("admin.report")
    val adminReport: Boolean? = null,
    @SerialName("quote")
    val quote: Boolean? = null,
    @SerialName("quoted_update")
    val quotedUpdate: Boolean? = null
)
