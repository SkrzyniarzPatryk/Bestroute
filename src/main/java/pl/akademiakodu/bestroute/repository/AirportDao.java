package pl.akademiakodu.bestroute.repository;

import pl.akademiakodu.bestroute.model.Airport;

import java.util.List;

public interface AirportDao {
    void createAirport(Airport airport);
    List<Airport> findAllAirports();
    void updateAirport(Airport airport);
    void deleteAirport(Long id);
    Airport findAirportByNameSQL(String name);
    Airport findAirportByIdSQL(Long id);
}
