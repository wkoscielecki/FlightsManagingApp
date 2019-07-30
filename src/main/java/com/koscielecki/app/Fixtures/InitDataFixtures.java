package com.koscielecki.app.Fixtures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class InitDataFixtures {

    @Autowired
    FlightFixtures flightFixtures;

    @Autowired
    TouristFixtures touristFixtures;

    @PostConstruct
    public void initData(){
        flightFixtures.createAndInsertIntoDb();
        touristFixtures.createAndInsertIntoDb();
    }

}
