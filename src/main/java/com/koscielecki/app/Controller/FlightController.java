package com.koscielecki.app.Controller;


import com.koscielecki.app.Model.Flight;
import com.koscielecki.app.Model.Tourist;
import com.koscielecki.app.Repository.FlightRepository;

import com.koscielecki.app.Service.FlightService;
import com.koscielecki.app.Service.TouristService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;



import javax.validation.Valid;

import java.util.List;

@Controller
public class FlightController {

    FlightService flightService;
    FlightRepository flightRepository;
    TouristService touristService;


    public FlightController(FlightService flightService, FlightRepository flightRepository, TouristService touristService) {
        this.flightService = flightService;
        this.flightRepository = flightRepository;
        this.touristService = touristService;
    }


    @ModelAttribute("tourists")
    public List<Tourist> getTourists(){
        return touristService.findAll();
    }



    @RequestMapping("/addFlight")
    public String addFlight(Model model){
        Flight flight=new Flight();
        model.addAttribute("flight",flight);
        return "flight/form";
    }
    @PostMapping("/addFlight")
    public String addFlight(@ModelAttribute("flight") @Valid Flight flight, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "flight/form";
        }
        flightService.addFlight(flight);
        return "redirect:/flightList";
    }
    @RequestMapping("/flightList")
    public String flightList(Model model){
        List<Flight> flights=flightService.findAll();
        model.addAttribute("flights", flights);

        return "flight/flightList";
    }

    @RequestMapping("/edit/{id}")
    public String editFlight(Model model,@PathVariable(name = "id") Long id){
        model.addAttribute("flight",flightRepository.findById(id));

        return "flight/edit";
    }
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String editFlight(@ModelAttribute("flight")@Valid Flight flight, BindingResult result){
        if (result.hasErrors()){
            return "flight/form";
        }
        flightRepository.save(flight);
        return "redirect:/flightList";
    }
    @RequestMapping("/delete/{id}")
    public String deleteFlight(@PathVariable(name = "id")Long id){
        flightService.deleteFlight(id);
        return "redirect:/flightList";
    }









}
