package com.koscielecki.app.Model;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import javax.validation.constraints.NotNull;


import java.time.LocalDateTime;
import java.util.ArrayList;


import java.util.List;


@Entity
@Table(name = "flights")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flight_id")
    private Long id;

    @NotBlank
    private String name;

    private LocalDateTime departureDateAndTime;

    private LocalDateTime arrivalDateAndTime;
    @NotNull
    private int numberOfSeats;
    @NotNull
    private double ticketsPrice;


    @ManyToMany
    private List<Tourist> touristList = new ArrayList<>();

    public Flight() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getDepartureDateAndTime() {
        return departureDateAndTime;
    }

    public void setDepartureDateAndTime(LocalDateTime departureDateAndTime) {
        this.departureDateAndTime = departureDateAndTime;
    }

    public LocalDateTime getArrivalDateAndTime() {
        return arrivalDateAndTime;
    }

    public void setArrivalDateAndTime(LocalDateTime arrivalDateAndTime) {
        this.arrivalDateAndTime = arrivalDateAndTime;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public double getTicketsPrice() {
        return ticketsPrice;
    }

    public void setTicketsPrice(double ticketsPrice) {
        this.ticketsPrice = ticketsPrice;
    }

    public List<Tourist> getTouristList() {
        return touristList;
    }



    public void setTouristList(List<Tourist> touristList) {
        this.touristList = touristList;
    }

    public String touristList(){
        return touristList.toString().replaceAll("[\\[\\]]", "");
    }

    @Override
    public String toString() {
        return name;
    }
}
