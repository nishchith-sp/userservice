package com.nishchith.userservice.services;

import com.nishchith.userservice.dtos.LoginUserDto;
import com.nishchith.userservice.dtos.SignUpUserDto;
import com.nishchith.userservice.exceptions.InvalidCredentialsException;
import com.nishchith.userservice.exceptions.UserNotFoundException;
import com.nishchith.userservice.models.AppUser;
import com.nishchith.userservice.models.Token;
import com.nishchith.userservice.repositories.TokenRepository;
import com.nishchith.userservice.repositories.UserRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final TokenRepository tokenRepository;

    UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder, TokenRepository tokenRepository) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.tokenRepository = tokenRepository;
    }

    public AppUser signUp(SignUpUserDto signUpUserDto) {
        AppUser appUser = new AppUser();
        appUser.setEmail(signUpUserDto.getEmail());
        appUser.setUsername(signUpUserDto.getUsername());
        appUser.setEncryptedPassword(bCryptPasswordEncoder.encode(signUpUserDto.getPassword()));
        return userRepository.save(appUser);
    }

    public Token login(LoginUserDto loginUserDto) {

        Optional<AppUser> optionalAppUser = userRepository.getAppUserByEmail(loginUserDto.getEmail());

        if (optionalAppUser.isEmpty()) {
            throw new UserNotFoundException("User not found");
        }

        if (!bCryptPasswordEncoder.matches(loginUserDto.getPassword(), optionalAppUser.get().getEncryptedPassword())) {
            throw new UserNotFoundException("Invalid password");
        }

        Token token = generateToken(optionalAppUser.get());
        tokenRepository.save(token);

        return token;
    }

    public AppUser validateToken(String tokenValue){
        Optional<Token> optionalAppUser = tokenRepository.findByTokenAndAndExpiryDateAfter(tokenValue, new Date());

        if (optionalAppUser.isEmpty()){
            throw new InvalidCredentialsException("Invalid token");
        }

        return optionalAppUser.get().getAppUser();

    }

    private Token generateToken(AppUser appUser) {
        appUser.setEncryptedPassword("");
        Token token = new Token();
        token.setAppUser(appUser);
        token.setToken(RandomStringUtils.randomAlphanumeric(32));
        LocalDate currentDate = LocalDate.now();
        LocalDate thirtyDaysLater = currentDate.plusDays(30);
        Date expiryDate = Date.from(thirtyDaysLater.atStartOfDay(ZoneId.systemDefault()).toInstant());
        token.setExpiryDate(expiryDate);

        return token;
    }
}
