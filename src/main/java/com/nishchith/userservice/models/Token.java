package com.nishchith.userservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Token extends BaseModel{
    private String token;
    @ManyToOne
    private AppUser appUser;
    private Date expiryDate;
}
