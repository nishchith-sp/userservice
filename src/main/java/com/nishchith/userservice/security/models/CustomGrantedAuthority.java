package com.nishchith.userservice.security.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nishchith.userservice.models.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

@JsonDeserialize
@Getter
@Setter
@NoArgsConstructor
public class CustomGrantedAuthority implements GrantedAuthority {

    private String authority;

    public CustomGrantedAuthority(Role role) {
        this.authority = role.getRoleName();
    }
    @Override
    public String getAuthority() {
        return authority;
    }
}
