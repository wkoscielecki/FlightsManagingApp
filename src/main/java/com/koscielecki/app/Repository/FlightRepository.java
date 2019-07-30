package com.koscielecki.app.Repository;

import com.koscielecki.app.Model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;



@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

}
