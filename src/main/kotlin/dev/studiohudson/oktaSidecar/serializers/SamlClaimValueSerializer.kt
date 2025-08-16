package dev.studiohudson.oktaSidecar.serializers

import dev.studiohudson.oktaSidecar.model.okta.inlineHooks.samlAssertionHook.response.SamlClaim
import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.json.*
import org.slf4j.Logger
import org.slf4j.LoggerFactory

object SamlClaimValueSerializer : JsonContentPolymorphicSerializer<Any>(
    Any::class
) {
    val logger: Logger = LoggerFactory.getLogger(this::class.java)

    override fun selectDeserializer(element: JsonElement): DeserializationStrategy<Any> {
        logger.info("Running custom serializer!")
        return when (element) {
            is JsonPrimitive -> when(element.toScalarOrNull()) {
                is String -> String.serializer()
                is Long -> Long.serializer()
                is Double -> Int.serializer()
                is Boolean -> Boolean.serializer()
                else -> throw SerializationException("Cannot serialize value type $this")
            }

            is JsonObject -> when {
                element.containsKey("authnContextClassRef") -> SamlClaim.AuthnContextValue.serializer()
                element.containsKey("attributes") -> SamlClaim.SamlClaimValue.serializer()
                else -> throw SerializationException("Cannot serialize value type $this")
            }

            else -> throw SerializationException("Cannot serialize value type $this")
        }
    }

    private fun JsonPrimitive.toScalarOrNull(): Any? = when {
        this is JsonNull -> null
        this.isString -> this.content
        else -> listOfNotNull(booleanOrNull, longOrNull, doubleOrNull).firstOrNull()
    }

}