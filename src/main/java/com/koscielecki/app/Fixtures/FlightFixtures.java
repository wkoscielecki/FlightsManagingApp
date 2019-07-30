package com.koscielecki.app.Fixtures;

import com.koscielecki.app.Model.Flight;
import com.koscielecki.app.Repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class FlightFixtures {

    @Autowired
    FlightRepository flightRepository;

    public void createAndInsertIntoDb(){
        List<Flight> flights=crateFlights();
        flightRepository.saveAll(flights);
    }

    private List<Flight> crateFlights(){
        List<Flight> flights=new ArrayList<>();

        Flight flight=new Flight();
        flight.setName("Dubaj");
        flight.setNumberOfSeats(300);
        flight.setTicketsPrice(509.99);
        flight.setDepartureDateAndTime(LocalDateTime.parse("2019-08-08T14:15:00"));
        flight.setArrivalDateAndTime(LocalDateTime.parse("2019-08-08T14:15:00"));
        flight.getTouristList();
        flights.add(flight);

        Flight flight2=new Flight();
        flight2.setName("Krakow");
        flight2.setNumberOfSeats(300);
        flight2.setTicketsPrice(509.99);
        flight2.setDepartureDateAndTime(LocalDateTime.parse("2019-09-08T14:17:00"));
        flight2.setArrivalDateAndTime(LocalDateTime.parse("2019-09-10T14:15:00"));
        flight2.getTouristList();
        flights.add(flight2);

        Flight flight3=new Flight();
        flight3.setName("Rzeszow");
        flight3.setNumberOfSeats(300);
        flight3.setTicketsPrice(509.99);
        flight3.setDepartureDateAndTime(LocalDateTime.parse("2019-09-08T14:17:00"));
        flight3.setArrivalDateAndTime(LocalDateTime.parse("2019-09-10T14:15:00"));
        flight3.getTouristList();
        flights.add(flight3);

        return flights;
    }
}
