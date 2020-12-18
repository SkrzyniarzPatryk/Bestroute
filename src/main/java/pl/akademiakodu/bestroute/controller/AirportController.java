package pl.akademiakodu.bestroute.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.akademiakodu.bestroute.model.Airport;
import pl.akademiakodu.bestroute.service.AirportService;

@Controller
@RequestMapping("/airport")
public class AirportController {
    private AirportService airportService;

    @Autowired
    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }


    @PostMapping("/create")
    public String addAirport(@ModelAttribute Airport airport) {
        if (airportService.isAirportLegit(airport)) {
            airportService.addAirport(airport);
        }
        return "redirect:/creator";
    }
}
