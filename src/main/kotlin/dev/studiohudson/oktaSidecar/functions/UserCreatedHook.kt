package dev.studiohudson.oktaSidecar.functions

import com.okta.sdk.resource.api.UserApi
import com.okta.sdk.resource.client.ApiClient
import org.springframework.stereotype.Service

@Service
class UserCreatedHook(
    private val oktaService: ApiClient
) {
    fun execute(target: String): String {
        val userApi = UserApi(oktaService)
        val users = userApi.listUsers("", target, null, 200, null, null, null, null)
        val retVal = "{\"Display Name\":\"${users[0].profile?.displayName}\"}"
        return retVal
    }
}