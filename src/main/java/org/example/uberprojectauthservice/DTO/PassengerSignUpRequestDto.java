package org.example.uberprojectauthservice.DTO;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PassengerSignUpRequestDto {

    private String email;

    private String password;

    private String phoneNumber;

    private String name;


}