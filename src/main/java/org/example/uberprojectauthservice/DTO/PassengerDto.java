package org.example.uberprojectauthservice.DTO;

import lombok.*;
import org.example.uberprojectauthservice.models.Passenger;

import java.util.Date;
import java.util.Locale;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PassengerDto {

    private String id;

    private String name;

    private String email;

    private String password; // encrypted password

    private String phoneNumber;

    private Date createdAt;

    public static PassengerDto from(Passenger p) {
        return PassengerDto.builder()
                .id(p.getId().toString())
                .createdAt(p.getCreatedAt())
                .email(p.getEmail())
                .password(p.getPassword())
                .phoneNumber(p.getPhoneNumber())
                .name(p.getName())
                .build();
    }
}
