package com.nishchith.userservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SignUpUserDto {
    private String username;
    private String password;
    private String email;

    public static SignUpUserDto from(SignUpRequestDto signUpRequestDto) {
        SignUpUserDto signUpUserDto = new SignUpUserDto();
        signUpUserDto.setUsername(signUpRequestDto.getUsername());
        signUpUserDto.setPassword(signUpRequestDto.getPassword());
        signUpUserDto.setEmail(signUpRequestDto.getEmail());

        return signUpUserDto;
    }
}
