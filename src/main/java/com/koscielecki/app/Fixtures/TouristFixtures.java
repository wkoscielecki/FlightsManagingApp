package com.koscielecki.app.Fixtures;


import com.koscielecki.app.Model.Flight;
import com.koscielecki.app.Model.Tourist;
import com.koscielecki.app.Repository.TouristRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class TouristFixtures {

    @Autowired
    TouristRepository touristRepository;


    public void createAndInsertIntoDb() {
        List<Tourist> tourists = crateFlights();
        touristRepository.saveAll(tourists);
    }

    private List<Tourist> crateFlights() {
        List<Tourist> tourists = new ArrayList<>();

        Tourist tourist=new Tourist();
     tourist.setFirstName("wojtek");
     tourist.setLastName("Wazny");
     tourist.setGender("male");
     tourist.setCountry("Poland");
     tourist.setDateOfBirth(LocalDate.parse("1993-03-28"));
     tourists.add(tourist);

        Tourist tourist2=new Tourist();
        tourist2.setFirstName("wojtek");
        tourist2.setLastName("Kowalski");
        tourist2.setGender("male");
        tourist2.setCountry("Poland");
        tourist2.setDateOfBirth(LocalDate.parse("1993-03-27"));
        tourists.add(tourist2);

        Tourist tourist3=new Tourist();
        tourist3.setFirstName("wojtek");
        tourist3.setLastName("Nowak");
        tourist3.setGender("male");
        tourist3.setCountry("Poland");
        tourist3.setDateOfBirth(LocalDate.parse("1993-03-08"));
        tourists.add(tourist3);
        return tourists;
    }
}
