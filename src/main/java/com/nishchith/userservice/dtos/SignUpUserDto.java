package com.nishchith.userservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SignUpUserDto {
    private String username;
    private String hashesPassword;
    private String email;

    public static SignUpUserDto from(SignUpRequestDto signUpRequestDto) {
        SignUpUserDto signUpUserDto = new SignUpUserDto();
        signUpUserDto.setUsername(signUpRequestDto.getUsername());
        signUpUserDto.setHashesPassword(signUpRequestDto.getHashesPassword());
        signUpUserDto.setEmail(signUpRequestDto.getEmail());

        return signUpUserDto;
    }
}
