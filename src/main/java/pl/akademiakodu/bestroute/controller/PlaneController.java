package pl.akademiakodu.bestroute.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.akademiakodu.bestroute.model.Plane;
import pl.akademiakodu.bestroute.model.Route;
import pl.akademiakodu.bestroute.service.PlaneService;
import pl.akademiakodu.bestroute.service.RouteService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/plane")
public class PlaneController {
    private PlaneService planeService;
    private RouteService routeService;

    @Autowired
    public PlaneController(PlaneService planeService, RouteService routeService) {
        this.planeService = planeService;
        this.routeService = routeService;
    }

    @GetMapping("/details/{id}")
    public String getDetailsPlane(Model model, @PathVariable Long id) {
        model.addAttribute("plane", planeService.findPlaneById(id));
        return "plane_details";
    }
    @PostMapping("/create")
    public String addPlane (@ModelAttribute Plane plane) {
        if (planeService.isPlaneLegit(plane)) {
            planeService.addPlane(plane);
        }
        return "redirect:/creator";
    }
    @PostMapping("/destroy")
    public String removePlane (@RequestParam Long idPlane) {
        List<Route> routeList = new ArrayList<>();
        routeList = routeService.getRoutes();
        for (Route route : routeList) {
            if (route.getPlane().getId() == idPlane) {
                return "redirect:/error/1";
            }
        }
        planeService.removePlane(idPlane);
        return "redirect:/destroyer";
    }
}
