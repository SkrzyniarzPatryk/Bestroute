package pl.akademiakodu.bestroute.model;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Route {
    private Long id;
    private Airport startAirport;
    private Airport destinationAirport;
    private Plane plane;
    private LocalDateTime departureDate;
    private LocalDateTime arrivalDate;
    private Integer delay;
    private String name;

//    public Route(Airport startAirport, Airport destinationAirport, LocalDateTime departureDate,
//                 LocalDateTime arrivalDate, Integer delay, Plane plane) {
//        this.startAirport = startAirport;
//        this.destinationAirport = destinationAirport;
//        this.departureDate = departureDate;
//        this.arrivalDate = arrivalDate;
//        this.delay = delay;
//        this.plane = plane;
//        makeName();
//    }

    //==--DO SQL


    public Route(Long id, Airport startAirport, Airport destinationAirport, Plane plane, LocalDateTime departureDate, LocalDateTime arrivalDate, Integer delay) {
        this.id = id;
        this.startAirport = startAirport;
        this.destinationAirport = destinationAirport;
        this.plane = plane;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.delay = delay;
        makeName();
    }

    public Route() {
    }

    public String getDetailsUrl() {
        return "/route/details/" + id;
    }

    //==--private method--==
    private void makeName() {
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






    public String getDepartureDate() {
        if (arrivalDate != null) {
            return departureDate.toString();
        }
        return "";
    }
    public LocalDateTime getDepartureDateLocal() {
        return departureDate;
    }

    public String getDepartureDateFormat(char c) {
        LocalDateTime ldt = departureDate;
        if (c == 'f') {
            ldt = ldt.plusMinutes(delay);
        }
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return ldt.format(dtf);
    }
    public String getArrivalDateFormat(char c) {
        LocalDateTime ldt = arrivalDate;
        if (c == 'f') {
            ldt = ldt.plusMinutes(delay);
        }
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return ldt.format(dtf);
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = LocalDateTime.parse(departureDate);
    }

    public String getArrivalDate() {
        if (arrivalDate != null) {
            return arrivalDate.toString();
        }
        return "";
    }

    public LocalDateTime getArrivalDateLocal() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = LocalDateTime.parse(arrivalDate);
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", startAirport=" + startAirport +
                ", destinationAirport=" + destinationAirport +
                ", plane=" + plane +
                ", departureDate=" + departureDate +
                ", arrivalDate=" + arrivalDate +
                ", delay=" + delay +
                ", name='" + name + '\'' +
                '}';
    }
}
