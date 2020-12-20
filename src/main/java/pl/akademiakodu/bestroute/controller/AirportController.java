package pl.akademiakodu.bestroute.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.akademiakodu.bestroute.model.Airport;
import pl.akademiakodu.bestroute.model.Route;
import pl.akademiakodu.bestroute.service.AirportService;
import pl.akademiakodu.bestroute.service.RouteService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/airport")
public class AirportController {
    private AirportService airportService;
    private RouteService routeService;

    @Autowired
    public AirportController(AirportService airportService, RouteService routeService) {
        this.airportService = airportService;
        this.routeService = routeService;
    }


    @PostMapping("/create")
    public String addAirport(@ModelAttribute Airport airport) {
        if (airportService.isAirportLegit(airport)) {
            airportService.addAirport(airport);
        }
        return "redirect:/creator";
    }
    @PostMapping("/destroy")
    public String removeAirport(@RequestParam Long idAirport) {
        List<Route> routeList = new ArrayList<>();
        routeList = routeService.getRoutes();
        for (Route route : routeList) {
            if (route.getStartAirport().getId() == idAirport || route.getDestinationAirport().getId() == idAirport) {
                return "redirect:/error/1";
            }
        }
        airportService.removeAirport(idAirport);
        return "redirect:/destroyer";
    }

    @GetMapping("/details/{id}")
    public String getAirport(Model model, @PathVariable Long id) {
        model.addAttribute("airport", airportService.findAirportById(id));
        return "airport_details";
    }
}
