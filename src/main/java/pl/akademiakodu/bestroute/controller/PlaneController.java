package pl.akademiakodu.bestroute.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.akademiakodu.bestroute.service.PlaneService;

@Controller
@RequestMapping("/plane")
public class PlaneController {
    private PlaneService planeService;

    @Autowired
    public PlaneController(PlaneService planeService) {
        System.out.println("kontroller samolotów");
        this.planeService = planeService;
    }

    @GetMapping("/details/{id}")
    public String getDetailsPlane(Model model, @PathVariable Long id) {
        model.addAttribute("plane", planeService.findPlaneById(id));
        return "plane_details";
    }
}
