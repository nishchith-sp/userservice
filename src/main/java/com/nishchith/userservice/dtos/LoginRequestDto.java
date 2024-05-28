package com.nishchith.userservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginRequestDto {
    private String password;
    private String email;
}
