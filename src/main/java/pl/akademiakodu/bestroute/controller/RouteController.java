package pl.akademiakodu.bestroute.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import pl.akademiakodu.bestroute.service.RouteService;

@Controller
public class RouteController {
    RouteService routeService;

    @Autowired
    public RouteController(RouteService routeService) {
        this.routeService = routeService;
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
    @GetMapping("/route/details/{id}")
    public String getRoute(Model model, @PathVariable Long id) {
        model.addAttribute("route", routeService.findRouteById(id));
        return "route_details";
    }
}
