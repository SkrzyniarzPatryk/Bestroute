package pl.akademiakodu.bestroute.service;

import pl.akademiakodu.bestroute.model.Airport;

import java.util.List;

public interface AirportService {

     Airport findAirportById(Long id);
     Airport findAirportByName(String name);
     List<Airport> getAirports();
     void addAirport(Airport airport);
     boolean isAirportLegit(Airport airport);
}
