package pl.akademiakodu.bestroute.model;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Route {
    private Long id;
    private Airport startAirport;
    private Airport destinationAirport;
    private LocalDateTime departureDate;
    private LocalDateTime arrivalDate;
    private Integer delay;
    private Plane plane;
    private String nameUrl;
    private String name;
    private static Long index = 1l;

    public Route(Airport startAirport, Airport destinationAirport, LocalDateTime departureDate,
                 LocalDateTime arrivalDate, Integer delay, Plane plane) {
        this.startAirport = startAirport;
        this.destinationAirport = destinationAirport;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.delay = delay;
        this.plane = plane;
        id = index++;
        makeName();
    }
    public String getDetailsUrl() {
        return "/route/details/" + name;
    }

    //==--private method--==
    private void makeName() {
        nameUrl = Funcion.getNameWithoutSpace(startAirport.getName()) + "+" + Funcion.getNameWithoutSpace(destinationAirport.getName());
        name = startAirport.getName() + " --> " + destinationAirport.getName();
    }

    //==--GettersAndSetters--==

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Airport getStartAirport() {
        return startAirport;
    }

    public void setStartAirport(Airport startAirport) {
        this.startAirport = startAirport;
    }

    public Airport getDestinationAirport() {
        return destinationAirport;
    }

    public void setDestinationAirport(Airport destinationAirport) {
        this.destinationAirport = destinationAirport;
    }

    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDateTime departureDate) {
        this.departureDate = departureDate;
    }

    public LocalDateTime getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDateTime arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Integer getDelay() {
        return delay;
    }

    public void setDelay(Integer delay) {
        this.delay = delay;
    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public String getNameUrl() {
        return nameUrl;
    }

    public void setNameUrl(String name) {
        this.nameUrl = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
