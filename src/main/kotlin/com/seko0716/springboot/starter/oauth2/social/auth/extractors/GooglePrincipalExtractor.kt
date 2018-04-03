package com.seko0716.springboot.starter.oauth2.social.auth.extractors

import com.seko0716.springboot.starter.oauth2.social.domains.Role
import com.seko0716.springboot.starter.oauth2.social.domains.User
import com.seko0716.springboot.starter.oauth2.social.repository.IUserStorage
import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor

class GooglePrincipalExtractor(var userStorage: IUserStorage) : PrincipalExtractor {

    override fun extractPrincipal(map: MutableMap<String, Any>): Any {
        map["_authServiceType"] = "GOOGLE"
        val result = OAuth2UserService.getDetails(map)
        val email = result["email"]
        var user = userStorage.findOneByLogin(email!!)
        if (user == null) {
            user = User(login = email, roles = listOf(Role(name = "ROLE_DEFAULT")))
            return userStorage.save(user)
        }
        return user
    }
}