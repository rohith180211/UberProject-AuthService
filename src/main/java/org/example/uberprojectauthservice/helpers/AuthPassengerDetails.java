package org.example.uberprojectauthservice.helpers;
import org.example.uberprojectauthservice.models.Passenger;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;

// We need this class because spring security works on userrdetails polymorphic type for auth

public class AuthPassengerDetails extends Passenger implements UserDetails {

    private final String username;
    private final String password;
    public AuthPassengerDetails(Passenger passenger) {
        this.username=passenger.getEmail();
        this.password=passenger.getPassword();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }


    @Override
    public String getUsername() {
        return this.username;
    }

    //Below set of methods are not of much of concern

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
