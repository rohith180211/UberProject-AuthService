package org.example.uberprojectauthservice.Controllers;

import org.example.uberprojectauthservice.DTO.PassengerDto;
import org.example.uberprojectauthservice.DTO.PassengerSignUpRequestDto;
import org.example.uberprojectauthservice.Services.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup/passenger")
    public ResponseEntity<PassengerDto> signUp(@RequestBody PassengerSignUpRequestDto passengerSignupRequestDto) {
        PassengerDto response = authService.signupPassenger(passengerSignupRequestDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/signin")
    public ResponseEntity<?> signIn() {
        return new ResponseEntity<>(10, HttpStatus.CREATED);
    }
}
