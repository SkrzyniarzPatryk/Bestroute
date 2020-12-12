package pl.akademiakodu.bestroute.service;

import org.springframework.stereotype.Service;
import pl.akademiakodu.bestroute.model.Airport;

import java.util.ArrayList;
import java.util.List;

@Service
public class AirportServiceImpl implements AirportService {
    List<Airport> airportList;

    public AirportServiceImpl() {
        createAirports();
    }

    public Airport findAirportById(Long id) {
        return airportList.stream().filter(airport -> airport.getId() == id).findFirst().get();
    }







    private void createAirports() {
        airportList = new ArrayList<>();
        airportList.add(new Airport("Poland", "Warszawa Okęcie"));
        airportList.add(new Airport("Poland", "Kraków Balice"));
        airportList.add(new Airport("Poland", "Modlin"));
    }
}
