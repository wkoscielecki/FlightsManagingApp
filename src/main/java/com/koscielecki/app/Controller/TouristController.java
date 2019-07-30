package com.koscielecki.app.Controller;


import com.koscielecki.app.Model.Flight;
import com.koscielecki.app.Model.Tourist;
import com.koscielecki.app.Repository.TouristRepository;
import com.koscielecki.app.Service.FlightService;
import com.koscielecki.app.Service.TouristService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class TouristController {

    TouristRepository touristRepository;
    TouristService touristService;
    FlightService flightService;

    public TouristController(TouristRepository touristRepository, TouristService touristService, FlightService flightService) {
        this.touristRepository = touristRepository;
        this.touristService = touristService;
        this.flightService = flightService;
    }

    @ModelAttribute("flights")
    public List<Flight> getFlights(){
        return flightService.findAll();
    }

    @RequestMapping("/addTourist")
    public String addTourist(Model model){
        Tourist tourist=new Tourist();
        model.addAttribute("tourist",tourist);
        return "tourist/form";
    }
    @PostMapping("addTourist")
    public String addTourist(@ModelAttribute("tourist") @Valid Tourist tourist, BindingResult result){
        if (result.hasErrors()){
            return "tourist/form";
        }
        touristService.addTourist(tourist);
        return "redirect:/touristList";
    }
    @RequestMapping("/touristList")
    public String touristList(Model model){
        List<Tourist> tourists=touristService.findAll();
        model.addAttribute("tourists",tourists);
        return "tourist/touristList";
    }
    @RequestMapping("/editTourist/{id}")
    public String editTourist(Model model, @PathVariable(name = "id") Long id){
        model.addAttribute("tourist",touristRepository.findById(id));
        return "tourist/edit";
    }
    @RequestMapping(value = "/updateTourist", method = RequestMethod.POST)
    public String editTourist(@ModelAttribute("tourist")@Valid Tourist tourist, BindingResult result){
        if (result.hasErrors()){
            return "tourist/edit";
        }
       touristRepository.save(tourist);
        return "redirect:/touristList";
    }
    @RequestMapping("/deleteTourist/{id}")
    public String deleteTourist(@PathVariable(name = "id")Long id){
        touristService.deleteById(id);
        return "redirect:/touristList";
    }



}
