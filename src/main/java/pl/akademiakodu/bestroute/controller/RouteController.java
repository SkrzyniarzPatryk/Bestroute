package pl.akademiakodu.bestroute.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.akademiakodu.bestroute.model.Route;
import pl.akademiakodu.bestroute.service.RouteService;

@Controller
public class RouteController {
    RouteService routeService;

    @Autowired
    public RouteController(RouteService routeService) {
        this.routeService = routeService;
        System.out.println("kontroller tras");
    }

    @GetMapping("/")
    public String home(Model model, @RequestParam(required = false) String search_route) {
        if (search_route == null) {
            model.addAttribute("routeList", routeService.getRoutes());
        } else {
            model.addAttribute("routeList", routeService.searchRoutesByAirport(search_route));
        }
        return "home";
    }
    @PostMapping("/test/{id}")
    public String test(@ModelAttribute Route route, @PathVariable Long id){

        return "redirect /";
    }
    @GetMapping("/route/details/{id}")
    public String getRoute(Model model, @PathVariable Long id) {
        model.addAttribute("route", routeService.findRouteById(id));
        return "route_details";
    }
}
