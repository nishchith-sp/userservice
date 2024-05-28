package com.nishchith.userservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginUserDto {
    private String password;
    private String email;

    public static LoginUserDto from(LoginRequestDto loginRequestDto) {
        LoginUserDto loginUserDto = new LoginUserDto();
        loginUserDto.setPassword(loginRequestDto.getPassword());
        loginUserDto.setEmail(loginRequestDto.getEmail());

        return loginUserDto;
    }
}
