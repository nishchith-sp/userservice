package com.nishchith.userservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginUserDto {
    private String hashesPassword;
    private String email;

    public static LoginUserDto from(LoginRequestDto loginRequestDto) {
        LoginUserDto loginUserDto = new LoginUserDto();
        loginUserDto.setHashesPassword(loginRequestDto.getHashesPassword());
        loginUserDto.setEmail(loginRequestDto.getEmail());

        return loginUserDto;
    }
}
