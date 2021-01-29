package pl.akademiakodu.bestroute.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.akademiakodu.bestroute.model.Airport;
import pl.akademiakodu.bestroute.model.Plane;
import pl.akademiakodu.bestroute.model.Route;
import pl.akademiakodu.bestroute.service.AirportService;
import pl.akademiakodu.bestroute.service.PlaneService;
import pl.akademiakodu.bestroute.service.RouteService;

@Controller
public class RouteController {
    RouteService routeService;
    PlaneService planeService;
    AirportService airportService;

    @Autowired
    public RouteController(RouteService routeService, PlaneService planeService, AirportService airportService) {
        this.routeService = routeService;
        this.airportService = airportService;
        this.planeService = planeService;
    }

    @GetMapping("/")
    public String home(Model model, @RequestParam(required = false) String start_airport, @RequestParam(required = false) String end_airport,
                       @RequestParam(required = false) String from_date, @RequestParam(required = false) String to_date, @RequestParam(required = false) String comfort) {
        if (start_airport == null) {
            model.addAttribute("routeList", routeService.getRoutes());
        } else {
            model.addAttribute("routeList", routeService.searchRoutesByAirport(start_airport, end_airport, from_date, to_date, comfort));
        }
        model.addAttribute("favorites", routeService.getFavoriteRoutes());
        model.addAttribute("routeService", routeService);
        return "home";
    }
    @GetMapping("/favorite")
    public String getFavorites(Model model) {
        model.addAttribute("favorites", routeService.getFavoriteRoutes());
        model.addAttribute("routeService", routeService);
        return "favorites";
    }
    @GetMapping("/favorite/change/{id}")
    public String changeFavorites(@PathVariable Long id, @RequestParam String path) {
        routeService.changeFavorite(id);
        if (path.equals("f")) {
            return "redirect:/favorite";
        }
        return "redirect:/";

    }

    @GetMapping("/creator")
    public String creator(Model model) {
        Airport airport = new Airport();
        Plane plane = new Plane();
        Route route = new Route();
        model.addAttribute("airport", airport);
        model.addAttribute("plane", plane);
        model.addAttribute("route", route);
        model.addAttribute("airportList", airportService.getAirports());
        model.addAttribute("planeList", planeService.getPlanes());
        System.out.println(route.getArrivalDate());
        return "creator";
    }
    @GetMapping("/destroyer")
    public String destroyer(Model model) {
        model.addAttribute("routeList", routeService.getRoutes());
        model.addAttribute("airportList", airportService.getAirports());
        model.addAttribute("planeList", planeService.getPlanes());
        return "destroyer";
    }
    @PostMapping("/route/create")
    public String addRoute(@ModelAttribute Route route, @RequestParam Long planeId
            , @RequestParam Long startAirportId
            , @RequestParam Long destinationAirportId) {

        route.setStartAirport(airportService.findAirportById(startAirportId));
        route.setDestinationAirport(airportService.findAirportById(destinationAirportId));
        route.setPlane(planeService.findPlaneById(planeId));
        if (routeService.isRouteLegit(route)) {
            routeService.addRoute(route);
        }
        return "redirect:/creator";
    }
    @PostMapping("/route/destroy")
    public String removeRoute(@RequestParam Long idRoute) {
        routeService.removeRoute(idRoute);
        return "redirect:/destroyer";
    }

    @GetMapping("/route/details/{id}")
    public String getRoute(Model model, @PathVariable Long id) {
        model.addAttribute("route", routeService.findRouteById(id));
        return "route_details";
    }

    @GetMapping("/route/editor/{id}")
    public String editorRoute(Model model, @PathVariable Long id) {
        model.addAttribute("route", routeService.findRouteById(id));
        model.addAttribute("airportList", airportService.getAirports());
        model.addAttribute("planeList", planeService.getPlanes());
        return "route_editor";
    }
    @PostMapping("/route/edit/{id}")
    public String editRoute(@ModelAttribute Route route, @RequestParam Long planeId
            , @RequestParam Long startAirportId
            , @RequestParam Long destinationAirportId, @PathVariable Long id) {

        route.setStartAirport(airportService.findAirportById(startAirportId));
        route.setDestinationAirport(airportService.findAirportById(destinationAirportId));
        route.setPlane(planeService.findPlaneById(planeId));
        route.setId(id);
        routeService.editRoute(route);
        return "redirect:/route/editor/" + id;
    }
}
