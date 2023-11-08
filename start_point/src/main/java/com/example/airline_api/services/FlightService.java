package com.example.airline_api.services;

import com.example.airline_api.models.BookingDTO;
import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService {
    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;

    @Transactional
    public void saveFlight(Flight flight) {
        flightRepository.save(flight);
    }

    @Transactional
    public void cancelFlight(long id) {
        Flight flight = flightRepository.findById(id).get();
        for (Passenger passenger : flight.getPassengers()) {
            passenger.removeFlight(flight);
        }
        flightRepository.deleteById(id);
    }

    public List<Flight> findAllFlights() {
        return flightRepository.findAll();
    }

    public Optional<Flight> findFlight(Long id) {
        return flightRepository.findById(id);
    }


    public Flight bookPassengerOntoFlight(long id, BookingDTO bookingDTO) {
        //get a flight
        Flight flight = flightRepository.findById(id).get();
        //get a passenger
        Optional<Passenger> passenger = passengerRepository.findById(bookingDTO.getPassengerId());
        passenger.get().addFlight(flight);
        passengerRepository.save(passenger.get());
        return flight;
    }


    }

