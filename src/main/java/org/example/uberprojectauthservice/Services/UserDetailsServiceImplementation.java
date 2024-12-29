package org.example.uberprojectauthservice.Services;
import org.example.uberprojectauthservice.Repositories.PassengerRepository;
import org.example.uberprojectauthservice.helpers.AuthPassengerDetails;
import org.example.uberprojectauthservice.models.Passenger;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Optional;

//This class is responsible for loading the user in the form of UserDetails object for auth

@Service
public class UserDetailsServiceImplementation implements UserDetailsService {

    private final PassengerRepository passengerRepository;

    public UserDetailsServiceImplementation(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Passenger> passenger= PassengerRepository.findPassengerByEmail(email);
        if(passenger.isPresent()){
            return new AuthPassengerDetails(passenger.get());
        }
        else{
            throw new UsernameNotFoundException("Cannot find passenger with email: " + email);
        }
    }
}
