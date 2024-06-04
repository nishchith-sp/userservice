package com.nishchith.userservice.security.services;

import com.nishchith.userservice.models.AppUser;
import com.nishchith.userservice.repositories.UserRepository;
import com.nishchith.userservice.security.models.CustomUserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AppUser> optionalAppUser = userRepository.getAppUserByEmail(username);
        if(optionalAppUser.isEmpty()){
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new CustomUserDetails(optionalAppUser.get());
    }
}
