package pl.akademiakodu.bestroute.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.akademiakodu.bestroute.model.Route;
import pl.akademiakodu.bestroute.repository.RouteDao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RouteServiceImpl implements RouteService {
    private List<Route> routeList;
    private AirportService airportService;
    private PlaneService planeService;
    private RouteDao routeDao;

    @Autowired
    public RouteServiceImpl(AirportService airportService, PlaneService planeService, RouteDao routeDao) {
        System.out.println("Route Serwis - zaczynam");
        this.planeService = planeService;
        this.airportService = airportService;
        createRouteList();
        this.routeDao = routeDao;
        List<Route> routeList = new ArrayList<>();
        routeList = routeDao.findAllRoutes();
        for (Route route : routeList) {
            System.out.println(route);
        }
        System.out.println("Route Serwis - kończe");
    }

    @Override
    public Set<Route> searchRoutesByAirport(String name) {
        Set<Route> searchResults = new HashSet<>();
        searchResults.addAll(routeList.stream().filter(route -> route.getStartAirport().getName().equals(name)).collect(Collectors.toList()));
        searchResults.addAll(routeList.stream().filter(route -> route.getDestinationAirport().getName().equals(name)).collect(Collectors.toList()));
        return searchResults;
    }

    @Override
    public List<Route> getRoutes() {
        return routeList;
    }

    @Override
    public Route findRouteByName(String name) {
        return routeList.stream().filter(route -> route.getName().equals(name)).findFirst().get();
    }

    @Override
    public Route findRouteById(Long id) {
        return routeList.stream().filter(route -> route.getId() == id).findFirst().get();
    }

    //create
    private void createRouteList() {
        routeList = new ArrayList<>();
        routeList.add(new Route(12l, 4l, 5l, 2l, LocalDateTime.of(2020, 12, 12, 1, 2, 2),
                LocalDateTime.of(2020, 2, 1, 12, 1, 2),
                23));
        routeList.add(new Route(18l, 5l, 6l, 2l, LocalDateTime.of(2020, 12, 12, 1, 2, 2),
                LocalDateTime.of(2020, 2, 1, 12, 1, 2),
                23));
        routeList.add(new Route(airportService.findAirportById(1l), airportService.findAirportById(2l),
                LocalDateTime.of(2020, 12, 29, 12, 00),
                LocalDateTime.of(2020, 12, 29, 13, 00),
                30,
                planeService.findPlaneById(1l)));
        routeList.add(new Route(airportService.findAirportById(1l), airportService.findAirportById(1l),
                LocalDateTime.of(2020, 12, 29, 14, 00),
                LocalDateTime.of(2020, 12, 29, 15, 00),
                10,
                planeService.findPlaneById(1l)));
        routeList.add(new Route(airportService.findAirportById(1l), airportService.findAirportById(1l),
                LocalDateTime.of(2020, 12, 31, 23, 59),
                LocalDateTime.of(2021, 1, 1, 0, 59),
                30,
                planeService.findPlaneById(1l)));
    }
}
