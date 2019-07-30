package com.koscielecki.app.Service;

import com.koscielecki.app.Model.Flight;

import com.koscielecki.app.Repository.FlightRepository;

import org.springframework.stereotype.Service;



import java.util.List;

@Service
public class FlightService {

   private FlightRepository flightRepository;


    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public Flight addFlight(Flight flight){
        flightRepository.save(flight);
        return flight;
    }

    public List<Flight> findAll(){
        return flightRepository.findAll();
    }
    public void deleteFlight(Long id){
        flightRepository.deleteById(id);

    }


}
