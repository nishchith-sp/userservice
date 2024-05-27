package com.nishchith.userservice.services;

import com.nishchith.userservice.dtos.LoginUserDto;
import com.nishchith.userservice.dtos.SignUpUserDto;
import com.nishchith.userservice.models.AppUser;
import com.nishchith.userservice.models.Token;
import com.nishchith.userservice.repositories.UserRepository;
import org.springframework.stereotype.Service;

import org.apache.commons.lang3.RandomStringUtils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Service
public class UserService {

    private UserRepository userRepository;
//    private BCryptPasswordEncoder bCryptPasswordEncoder;

    UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public AppUser signUp(SignUpUserDto signUpUserDto) {
        AppUser appUser = new AppUser();
        appUser.setEmail(signUpUserDto.getEmail());
        appUser.setUsername(signUpUserDto.getUsername());
        appUser.setHashesPassword(signUpUserDto.getHashesPassword());
        AppUser optionalUser = userRepository.save(appUser);

        return optionalUser;
    }

    public Token login(LoginUserDto loginUserDto) {

        AppUser appUser = userRepository.getAppUserByEmail(loginUserDto.getEmail());

        return generateToken(appUser);
    }

    private Token generateToken(AppUser appUser) {
        Token token = new Token();
        token.setAppUser(appUser);
        token.setToken(RandomStringUtils.randomAlphanumeric(10));
        LocalDate currentDate = LocalDate.now();
        LocalDate thirtyDaysLater = currentDate.plusDays(30);
        Date expiryDate = Date.from(thirtyDaysLater.atStartOfDay(ZoneId.systemDefault()).toInstant());
        token.setExpiryDate(expiryDate);

        return token;
    }
}
