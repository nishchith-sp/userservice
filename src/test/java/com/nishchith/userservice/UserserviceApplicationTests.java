package com.nishchith.userservice;

import com.nishchith.userservice.dtos.SignUpRequestDto;
import com.nishchith.userservice.dtos.SignUpUserDto;
import com.nishchith.userservice.security.models.Client;
import com.nishchith.userservice.security.repositories.JpaRegisteredClientRepository;
import com.nishchith.userservice.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.settings.ClientSettings;

import java.util.UUID;

@SpringBootTest
class UserserviceApplicationTests {

    @Autowired
    JpaRegisteredClientRepository registeredClientRepository;
    @Autowired
    UserService userService;

    @Test
    void contextLoads() {
    }

//    @Test
//    public void registerSampleClient(){
//        RegisteredClient oidcClient = RegisteredClient.withId(UUID.randomUUID().toString())
//                .clientId("nishkala")
//                .clientSecret("$2a$12$llLFii9b7XSSyQzWtsU29.eJ6jC2voSZXGhqyh0VrBIoacEO940Ma")
//                .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
//                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
//                .authorizationGrantType(AuthorizationGrantType.REFRESH_TOKEN)
//                .redirectUri("https://oauth.pstmn.io/v1/callback")
//                .postLogoutRedirectUri("https://oauth.pstmn.io/v1/callback")
//                .scope("ADMIN")
//                .clientSettings(ClientSettings.builder().requireAuthorizationConsent(true).build())
//                .build();
//
//        registeredClientRepository.save(oidcClient);
//    }

//    @Test
//    public void createSampleUser(){
//        SignUpRequestDto signUpRequestDto = new SignUpRequestDto();
//        signUpRequestDto.setUsername("Nishchith");
//        signUpRequestDto.setEmail("nish@gmail.com");
//        signUpRequestDto.setPassword("Password123");
//        userService.signUp(SignUpUserDto.from(signUpRequestDto));
//    }

}
