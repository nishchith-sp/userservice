package com.nishchith.userservice.controllers;


import com.nishchith.userservice.dtos.*;
import com.nishchith.userservice.exceptions.InvalidCredentialsException;
import com.nishchith.userservice.exceptions.UserNotFoundException;
import com.nishchith.userservice.models.AppUser;
import com.nishchith.userservice.models.Token;
import com.nishchith.userservice.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("signUp")
    public ResponseEntity<UserDto> signUp(@RequestBody SignUpRequestDto signUpRequestDto) {

        AppUser appUser = userService.signUp(SignUpUserDto.from(signUpRequestDto));

        return new ResponseEntity<>(UserDto.from(appUser), HttpStatus.CREATED);
    }

    @GetMapping("login")
    public Token login(@RequestBody LoginRequestDto loginRequestDto) {
        return userService.login(LoginUserDto.from(loginRequestDto));
    }

    @GetMapping("validate/{token}")
    public UserDto validateToken(@PathVariable String token) {
        return UserDto.from(userService.validateToken(token));
    }

    @ExceptionHandler({RuntimeException.class, NullPointerException.class})
    public ResponseEntity<String> handleException() {
        return new ResponseEntity<>("Something went Wrong", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleUserNotFoundException() {
        return new ResponseEntity<>("Sorry, User not found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<String> handleInvalidCredentialsException() {
        return new ResponseEntity<>("Oops, Invalid credentials", HttpStatus.FORBIDDEN);
    }
}
