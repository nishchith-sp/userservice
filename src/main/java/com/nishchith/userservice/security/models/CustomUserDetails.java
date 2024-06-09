package com.nishchith.userservice.security.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nishchith.userservice.models.AppUser;
import com.nishchith.userservice.models.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@JsonDeserialize
@Getter
@Setter
@NoArgsConstructor
public class CustomUserDetails implements UserDetails {

    private Long userId;

    private String username;
    private String password;
    private List<CustomGrantedAuthority> authorities;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;


    public CustomUserDetails(AppUser appUser) {
        this.username = appUser.getUsername();
        this.password = appUser.getEncryptedPassword();
        this.accountNonExpired = true;
        this.accountNonLocked = true;
        this.credentialsNonExpired = true;
        this.enabled = true;
        this.userId = appUser.getId();

        this.authorities = new ArrayList<>();
        for(Role role:appUser.getRoles()) {
            this.authorities.add(new CustomGrantedAuthority(role));
        }

    }

    @Override
    public List<CustomGrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
