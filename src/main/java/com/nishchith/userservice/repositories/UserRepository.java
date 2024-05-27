package com.nishchith.userservice.repositories;


import com.nishchith.userservice.models.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<AppUser,Long> {

    @Override
    AppUser save(AppUser appUser);

    AppUser getAppUserByEmail(String email);
}
