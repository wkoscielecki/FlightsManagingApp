package com.koscielecki.app.Service;


import com.koscielecki.app.Model.Tourist;
import com.koscielecki.app.Repository.TouristRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TouristService {

    private TouristRepository touristRepository;

    public TouristService(TouristRepository touristRepository) {
        this.touristRepository = touristRepository;
    }
    public Tourist addTourist(Tourist tourist){
        touristRepository.save(tourist);
        return tourist;

    }
    public List<Tourist> findAll(){
        return touristRepository.findAll();
    }
    public Tourist findByLastName(String lastName){
        return touristRepository.findByLastName(lastName);
    }

    public Tourist delete(Tourist tourist){
        touristRepository.delete(tourist);
        return tourist;
    }
    public void deleteById(Long id){
         touristRepository.deleteById(id);
    }

}
