package com.koscielecki.app.Repository;

import com.koscielecki.app.Model.Tourist;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


@Repository
public interface TouristRepository extends JpaRepository<Tourist, Long> {

    Tourist findByLastName(String lastName);


}
