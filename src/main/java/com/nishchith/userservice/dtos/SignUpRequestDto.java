package com.nishchith.userservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SignUpRequestDto {

    private String username;
    private String hashesPassword;
    private String email;
}
