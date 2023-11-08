package com.example.airline_api.components;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {
    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;

    public DataLoader() {
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        //EASYJET FLIGHT

        Flight easyJet = new Flight("London", 200, "20/11/2023", "4PM");
        flightRepository.save(easyJet);
        Passenger annie = new Passenger("Annie", "annie@email");
        passengerRepository.save(annie);
        Passenger jade = new Passenger("Jade", "jade@email");
        passengerRepository.save(jade);

        // RYANAIR FLIGHT

        Flight ryanAir = new Flight("Amsterdam", 500, "17/01/2024", "9AM");
        flightRepository.save(ryanAir);

        Passenger tony = new Passenger("Tony", "tony@email");
        passengerRepository.save(tony);

        Passenger alex = new Passenger("Alex", "alex@email");
        passengerRepository.save(alex);

    }

}
