package pl.akademiakodu.bestroute.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.akademiakodu.bestroute.model.Airport;
import pl.akademiakodu.bestroute.model.Country;
import pl.akademiakodu.bestroute.repository.AirportDao;

import java.util.ArrayList;
import java.util.List;

@Service
public class AirportServiceImpl implements AirportService {
    List<Airport> airportList;
    private AirportDao airportDao;

    @Autowired
    public AirportServiceImpl(AirportDao airportDao) {
        System.out.println("Airport Serwis - zaczynam");
        this.airportDao = airportDao;
        createAirports();
//        List<Airport> airportList = new ArrayList<>();
//        airportList = airportDao.findAllAirports();
//        for (Airport airport : airportList) {
//            System.out.println(airport);
//        }
        System.out.println("airport Serwis - kończe");
    }

    public Airport findAirportById(Long id) {
        return airportList.stream().filter(airport -> airport.getId() == id).findFirst().get();
    }


    private void createAirports() {
        airportList = new ArrayList<>();
        airportList.add(new Airport(1l, Country.POLAND, "Warszawa Okęcie"));
        airportList.add(new Airport(2l, Country.POLAND, "Kraków Balice"));
        airportList.add(new Airport(3l, Country.POLAND, "Modlin"));
    }
}
