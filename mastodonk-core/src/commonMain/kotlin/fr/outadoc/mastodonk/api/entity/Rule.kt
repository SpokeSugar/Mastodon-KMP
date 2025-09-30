package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a rule that server users should follow.
 */
@Serializable
public data class Rule(
    /**
     * An identifier for the rule.
     */
    @SerialName("id")
    val id: String,

    /**
     * The rule to be followed.
     */
    @SerialName("text")
    val text: String,

    /**
     * Longer-form description of the rule.
     */
    @SerialName("hint")
    val hint: String? = null,

    /**
     * Available translations for this rule's `text` and `hint`.
     * Keys are locale codes (e.g., "fr") and values are [RuleTranslation] objects.
     */
    @SerialName("translations")
    val translations: Map<String, RuleTranslation>? = null
)

@Serializable
public data class RuleTranslation(
    /**
     * The translated text for the rule.
     */
    @SerialName("text")
    val text: String,

    /**
     * The translated longer-form description of the rule.
     */
    @SerialName("hint")
    val hint: String? = null
)
