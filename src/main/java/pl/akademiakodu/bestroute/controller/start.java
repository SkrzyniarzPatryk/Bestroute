package pl.akademiakodu.bestroute.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.akademiakodu.bestroute.service.RouteService;

@Controller
public class start {

    @PostMapping("/test")
    public String tetst(Model model, @ModelAttribute Form form) {
        //   model.addAttribute("routeList", routeService.searchRoutesByAirport(search_route));
        return "home";
    }
}
