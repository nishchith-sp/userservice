package com.nishchith.userservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class AppUser extends BaseModel {

    private String username;
    private String hashesPassword;
    private String email;

    @ManyToMany
    private List<Role> roles;
}
