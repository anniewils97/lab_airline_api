package com.example.airline_api.controllers;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    FlightRepository flightRepository;
    @Autowired
    FlightService flightService;

    // Display all available flights
    @GetMapping
    public ResponseEntity<List<Flight>> getAllFlights(){
        return new ResponseEntity(flightRepository.findAll(), HttpStatus.OK);
    }

    // Display a specific flight
    @GetMapping(value = "/{id}")
    public ResponseEntity<Flight> getFlightById(@PathVariable Long id){
        return new ResponseEntity(flightRepository.findById(id), HttpStatus.OK);
    }

    // Add details of a new flight
    @PostMapping
    public ResponseEntity<List<Flight>> addNewFlight(@RequestBody Flight flight){
        flightRepository.save(flight);
        return new ResponseEntity(flightRepository.findAll(), HttpStatus.CREATED);
    }

    // Book passenger on a flight
//    @PatchMapping(value = "/{id}")
//    public ResponseEntity<Flight> addPassengerToFlight(
//            @RequestBody Passenger passenger,
//            @PathVariable long id)
//    {
//        Flight flight = flightService.
//        return null;
//    }

    // Cancel flight
//    @DeleteMapping(value = "/{id}")
//    public ResponseEntity<Long> cancelFlight(@PathVariable long id){
//        flightService.deleteFlight(id);
//        return new ResponseEntity<>(id, HttpStatus.OK);
//    }

}
