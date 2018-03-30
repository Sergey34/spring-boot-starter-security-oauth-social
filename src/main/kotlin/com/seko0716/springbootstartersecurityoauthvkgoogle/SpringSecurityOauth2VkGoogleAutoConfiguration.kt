package com.seko0716.springbootstartersecurityoauthvkgoogle

import com.seko0716.springbootstartersecurityoauthvkgoogle.configurations.conditionals.MissingOtherImplementationCondition
import com.seko0716.springbootstartersecurityoauthvkgoogle.repository.UserRepository
import com.seko0716.springbootstartersecurityoauthvkgoogle.repository.UserRepositoryDefault
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Conditional
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client

@Configuration
@ComponentScan(basePackages = ["com.seko0716.springbootstartersecurityoauthvkgoogle"])
@EnableOAuth2Client
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableConfigurationProperties
class SpringSecurityOauth2VkGoogleAutoConfiguration {

    @Bean
    @Conditional(MissingOtherImplementationCondition::class)
    fun userRepositoryDefault(): UserRepository {
        return UserRepositoryDefault()
    }
}