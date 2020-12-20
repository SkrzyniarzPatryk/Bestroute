package pl.akademiakodu.bestroute.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.akademiakodu.bestroute.model.Airport;
import pl.akademiakodu.bestroute.model.Country;
import pl.akademiakodu.bestroute.model.Route;
import pl.akademiakodu.bestroute.repository.AirportDao;

import java.util.ArrayList;
import java.util.List;

@Service
public class AirportServiceImpl implements AirportService {
   // List<Airport> airportList;
    private AirportDao airportDao;

    @Autowired
    public AirportServiceImpl(AirportDao airportDao) {
        this.airportDao = airportDao;


//        createAirports();
//        List<Airport> airportList = new ArrayList<>();
//        airportList = airportDao.findAllAirports();
//        for (Airport airport : airportList) {
//            System.out.println(airport);
//        }
    }

    @Override
    public List<Airport> getAirports() {
        return airportDao.findAllAirports();
    }

    @Override
    public void addAirport(Airport airport) {
        airportDao.createAirport(airport);
    }

    @Override
    public boolean isAirportLegit(Airport airport) {
        if (airport.getName().isEmpty()) {
            return false;
        }
        return true;
    }

    @Override
    public void removeAirport(Long id) {
        airportDao.deleteAirport(id);
    }

    @Override
    public Airport findAirportById(Long id) {
        return airportDao.findAirportByIdSQL(id);
    }
    @Override
    public Airport findAirportByName(String name) {
        return airportDao.findAirportByNameSQL(name);
    }


//    private void createAirports() {
//        airportDao.createAirport(new Airport(1l, Country.POLAND, "Warszawa Okęcie"));
//        airportDao.createAirport(new Airport(2l, Country.POLAND, "Kraków Balice"));
//        airportDao.createAirport(new Airport(3l, Country.POLAND, "Modlin"));
//        airportDao.createAirport(new Airport(4l, Country.DEUTSCHLAND, "Frankfurt"));
//
////        airportList = new ArrayList<>();
////        airportList.add(new Airport(1l, Country.POLAND, "Warszawa Okęcie"));
////        airportList.add(new Airport(2l, Country.POLAND, "Kraków Balice"));
////        airportList.add(new Airport(3l, Country.POLAND, "Modlin"));
//    }
}
