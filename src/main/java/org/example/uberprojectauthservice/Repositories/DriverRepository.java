package org.example.uberprojectauthservice.Repositories;

import org.example.uberprojectentityservice.Models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {
}
