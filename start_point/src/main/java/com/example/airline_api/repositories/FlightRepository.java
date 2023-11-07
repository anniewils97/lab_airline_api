package com.example.airline_api.repositories;

import com.example.airline_api.models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    //derived query to return flight by id
    Flight findById(int flightId);
}
