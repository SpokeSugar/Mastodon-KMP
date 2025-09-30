package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class NotificationType(public val value: String) {

    /** Someone followed the account. */
    @SerialName("follow")
    Follow("follow"),

    /** Someone requested to follow the account. */
    @SerialName("follow_request")
    FollowRequest("follow_request"),

    /** Someone mentioned the account in their status. */
    @SerialName("mention")
    Mention("mention"),

    /** Someone boosted one of the account's statuses. */
    @SerialName("reblog")
    Boost("reblog"),

    /** Someone favourited one of the account's statuses. */
    @SerialName("favourite")
    Favourite("favourite"),

    /** A poll the account has voted in or created has ended. */
    @SerialName("poll")
    Poll("poll"),

    /** Someone we enabled notifications for has posted a status. */
    @SerialName("status")
    Status("status"),

    /** A status you reblogged has been edited. */
    @SerialName("update")
    Update("update"),

    /** Someone signed up (optionally sent to admins). */
    @SerialName("admin.sign_up")
    AdminSignUp("admin.sign_up"),

    /** A new report has been filed. */
    @SerialName("admin.report")
    AdminReport("admin.report"),

    /** Some of your follow relationships have been severed. */
    @SerialName("severed_relationships")
    SeveredRelationships("severed_relationships"),

    /** A moderator has taken action against your account or sent a warning. */
    @SerialName("moderation_warning")
    ModerationWarning("moderation_warning"),

    /** Someone has quoted one of your statuses. */
    @SerialName("quote")
    Quote("quote"),

    /** A status you have quoted has been edited. */
    @SerialName("quoted_update")
    QuotedUpdate("quoted_update")
}
