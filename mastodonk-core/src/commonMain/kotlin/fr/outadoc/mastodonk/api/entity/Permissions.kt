package fr.outadoc.mastodonk.api.entity

import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

/**
 * A bitmask that represents the sum of all permissions granted to the role.
 */
@Serializable(with = Permissions.PermissionsSerializer::class)
public data class Permissions(val permissions: Set<Permission>) {

    internal object PermissionsSerializer : KSerializer<Permissions> {

        override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("Permissions", PrimitiveKind.STRING)

        override fun serialize(encoder: Encoder, value: Permissions) {
            val bitmask = value.permissions.fold(0L) { acc, permission ->
                acc or permission.value
            }
            encoder.encodeString(bitmask.toString())
        }

        override fun deserialize(decoder: Decoder): Permissions {
            val bitmask = decoder.decodeString().toLong()
            val permissions = Permission.entries.filter {
                (bitmask and it.value) != 0L
            }.toSet()
            return Permissions(permissions)
        }
    }
}
