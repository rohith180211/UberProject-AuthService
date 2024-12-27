package org.example.uberprojectauthservice.Controllers;

import lombok.*;
import org.example.uberprojectauthservice.DTO.PassengerDto;
import org.example.uberprojectauthservice.DTO.PassengerSignUpRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@Getter
@Setter
@NoArgsConstructor
@Builder
public class AuthController {
    @PostMapping("/signup/passenger")
    public ResponseEntity<PassengerDto> signUp(@RequestBody PassengerSignUpRequestDto passengerSignUpRequestDto) {
        return null;
    }
}
