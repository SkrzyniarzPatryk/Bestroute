package pl.akademiakodu.bestroute.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class start {

    @GetMapping("/test")
    public String home() {

        return "Hej, to moja strona!";
    }
}
