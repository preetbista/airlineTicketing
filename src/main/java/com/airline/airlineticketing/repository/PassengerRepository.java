package com.airline.airlineticketing.repository;

import com.airline.airlineticketing.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long> {
    Passenger findByEmail(String email);
}
