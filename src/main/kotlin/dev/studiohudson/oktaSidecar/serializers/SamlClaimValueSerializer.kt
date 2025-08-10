package dev.studiohudson.oktaSidecar.serializers

import dev.studiohudson.oktaSidecar.model.okta.inlineHooks.samlAssertionHook.response.Value.ClaimValue
import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.json.JsonContentPolymorphicSerializer
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import org.slf4j.Logger
import org.slf4j.LoggerFactory

object SamlClaimValueSerializer : JsonContentPolymorphicSerializer<Any>(
    Any::class
) {
    val logger: Logger = LoggerFactory.getLogger(this::class.java)

    override fun selectDeserializer(element: JsonElement): DeserializationStrategy<Any> {
        logger.info("Running custom serializer!")
        return when(element) {
            is JsonPrimitive -> String.serializer()
            is JsonObject -> when {
                element.containsKey("authnContextClassRef") -> ClaimValue.AuthnContextValue.serializer()
                element.containsKey("attributes") -> ClaimValue.SamlClaimValue.serializer()
                else -> throw SerializationException("Cannot serialize value type $this")
            }
            else -> throw SerializationException("Cannot serialize value type $this")
        }
    }
}