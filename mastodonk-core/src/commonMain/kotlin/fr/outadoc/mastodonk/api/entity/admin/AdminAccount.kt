package fr.outadoc.mastodonk.api.entity.admin

import fr.outadoc.mastodonk.api.entity.Account
import fr.outadoc.mastodonk.api.entity.Role
import kotlin.time.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Admin-level information about a given account.
 */
@Serializable
public data class AdminAccount(

    @SerialName("id")
    val accountId: String,

    /**
     * The username of the account.
     */
    @SerialName("username")
    val username: String,

    /**
     * The domain of the account, if it is remote.
     */
    @SerialName("domain")
    val domain: String?,

    /**
     * When the account was first discovered.
     */
    @SerialName("created_at")
    val createdAt: Instant,

    /**
     * The email address associated with the account.
     */
    @SerialName("email")
    val email: String,

    /**
     * The IP address last used to login to this account.
     */
    @SerialName("ip")
    val ip: String?,

    /**
     * All known IP addresses associated with this account.
     */
    @SerialName("ips")
    val ips: List<AdminIp>,

    /**
     * The locale of the account.
     */
    @SerialName("locale")
    val locale: String?,

    /**
     * The reason given when requesting an invite (for instances that require manual approval of registrations)
     */
    @SerialName("invite_request")
    val inviteRequest: String?,

    /**
     * The current role of the account.
     */
    @SerialName("role")
    val role: Role,

    /**
     * Whether the account has confirmed their email address.
     */
    @SerialName("confirmed")
    val isConfirmed: Boolean,

    /**
     * Whether the account is currently approved.
     */
    @SerialName("approved")
    val isApproved: Boolean,

    /**
     * Whether the account is currently disabled.
     */
    @SerialName("disabled")
    val isDisabled: Boolean,

    /**
     * Whether the account is currently silenced.
     */
    @SerialName("silenced")
    val isSilenced: Boolean,

    /**
     * Whether the account is currently suspended.
     */
    @SerialName("suspended")
    val isSuspended: Boolean,

    /**
     * User-level information about the account.
     */
    @SerialName("account")
    val account: Account,

    /**
     * The ID of the [Application] that created this account, if applicable.
     */
    @SerialName("created_by_application_id")
    val createdByApplicationId: String? = null,

    /**
     * The ID of the [Account] that invited this user, if applicable.
     */
    @SerialName("invited_by_account_id")
    val invitedByAccountId: String? = null
)
