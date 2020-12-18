package pl.akademiakodu.bestroute.controller;

import java.time.LocalDateTime;

public class Form {
    private String startAirport;
    private String endAirport;

    public String getStartAirport() {
        return startAirport;
    }

    public void setStartAirport(String startAirport) {
        this.startAirport = startAirport;
    }

    public String getEndAirport() {
        return endAirport;
    }

    public void setEndAirport(String endAirport) {
        this.endAirport = endAirport;
    }
}
