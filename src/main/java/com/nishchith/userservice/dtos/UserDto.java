package com.nishchith.userservice.dtos;

import com.nishchith.userservice.models.Role;
import com.nishchith.userservice.models.AppUser;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDto {
    private String name;
    private String email;
    private List<Role> roles;

    public static UserDto from(AppUser appUser) {
        UserDto userDto = new UserDto();
        userDto.setEmail(appUser.getEmail());
        userDto.setName(appUser.getUsername());
        userDto.setRoles(appUser.getRoles());

        return userDto;
    }
}
