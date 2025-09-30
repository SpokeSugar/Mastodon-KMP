package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents the translation of a rule's text and hint.
 */
@Serializable
public data class RuleTranslation(
    /**
     * The translated text of the rule.
     */
    @SerialName("text")
    val text: String,

    /**
     * The translated longer-form description of the rule.
     */
    @SerialName("hint")
    val hint: String? = null // Hint can be optional in a translation
)
