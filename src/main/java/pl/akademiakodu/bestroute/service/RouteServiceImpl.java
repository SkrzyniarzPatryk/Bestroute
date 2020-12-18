package pl.akademiakodu.bestroute.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import pl.akademiakodu.bestroute.model.Comfort;
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
    private AirportService airportService;
    private PlaneService planeService;
    private RouteDao routeDao;

    @Autowired
    public RouteServiceImpl(AirportService airportService, PlaneService planeService, RouteDao routeDao) {
        this.planeService = planeService;
        this.airportService = airportService;
        this.routeDao = routeDao;
 //       createRouteList();
//        List<Route> routeList = new ArrayList<>();
//        routeList = routeDao.findAllRoutes();
//        for (Route route : routeList) {
//            System.out.println(route);
//        }
    }

//    @Override
//    public Set<Route> searchRoutesByAirport(String name) {
//        Set<Route> searchResults = new HashSet<>();
//        searchResults.addAll(getRoutes().stream().filter(route -> route.getStartAirport().getName().equals(name)).collect(Collectors.toList()));
//        searchResults.addAll(getRoutes().stream().filter(route -> route.getDestinationAirport().getName().equals(name)).collect(Collectors.toList()));
//        return searchResults;
//    }

    @Override
    public List<Route> getRoutes() {
        return routeDao.findAllRoutes();
    }

    @Override
    public Route findRouteByName(String name) {
        return getRoutes().stream().filter(route -> route.getName().equals(name)).findFirst().get();
    }

    @Override
    public Set<Route> searchRoutesByAirport(String start_airport, String end_airport, String from_date, String to_date, String comfort) {
        Set<Route> routeList = new HashSet<>();
        routeList.addAll(getRoutes());
        if (!start_airport.equals("")) {
            routeList.removeAll(routeList.stream().filter(route -> !route.getStartAirport().getName().equals(start_airport)).collect(Collectors.toList()));
        }
        if (!end_airport.equals("")) {
            routeList.removeAll(routeList.stream().filter(route -> !route.getStartAirport().getName().equals(end_airport)).collect(Collectors.toList()));
        }
        if (!from_date.equals("")) {
            LocalDateTime ldtFrom = LocalDateTime.parse(from_date);
            routeList.removeAll(routeList.stream().filter(route -> !route.getDepartureDate().isAfter(ldtFrom)).collect(Collectors.toList()));
        }
        if (!to_date.equals("")) {
            LocalDateTime ldtTo = LocalDateTime.parse(to_date);
            routeList.removeAll(routeList.stream().filter(route -> !route.getDepartureDate().isBefore(ldtTo)).collect(Collectors.toList()));
        }
        if (!comfort.equals("")) {
            Comfort comf = Comfort.valueOf(comfort);
            routeList.removeAll(routeList.stream().filter(route -> !(route.getPlane().getComfort() == comf)).collect(Collectors.toList()));
        }
        return  routeList;
    }

    @Override
    public Route findRouteById(Long id) {
        return routeDao.findRouteByIdSQL(id);
    }

    @Override
    public void addRoute(Route route) {
        routeDao.createRoute(route);
    }

    @Override
    public boolean isRouteLegit(Route route) {
        return true;
    }

    //create
//    private void createRouteList() {
//        routeDao.createRoute(new Route(1l, airportService.findAirportById(1l), airportService.findAirportById(2l),
//                planeService.findPlaneById(1l), LocalDateTime.of(2020, 12, 24, 9, 00),
//                LocalDateTime.of(2020, 12, 24, 9, 30), 7));
//        routeDao.createRoute(new Route(1l, airportService.findAirportById(1l), airportService.findAirportById(4l),
//                planeService.findPlaneById(2l), LocalDateTime.of(2020, 12, 27, 12, 00),
//                LocalDateTime.of(2020, 12, 27, 13, 15), 13));
//        routeDao.createRoute(new Route(1l, airportService.findAirportById(2l), airportService.findAirportById(3l),
//                planeService.findPlaneById(1l), LocalDateTime.of(2020, 12, 28, 7, 30),
//                LocalDateTime.of(2020, 12, 28, 7, 30), 2));
//        routeDao.createRoute(new Route(1l, airportService.findAirportById(4l), airportService.findAirportById(3l),
//                planeService.findPlaneById(3l), LocalDateTime.of(2021, 1, 1, 18, 40),
//                LocalDateTime.of(2021, 1, 1, 20, 00), 15));
//        routeDao.createRoute(new Route(1l, airportService.findAirportById(2l), airportService.findAirportById(4l),
//                planeService.findPlaneById(2l), LocalDateTime.of(2021, 1, 31, 23, 45),
//                LocalDateTime.of(2021, 2, 1, 1, 5), 34));
//
//        //        routeList = new ArrayList<>();
////        routeList.add(new Route(airportService.findAirportById(1l), airportService.findAirportById(2l),
////                LocalDateTime.of(2020, 12, 29, 12, 00),
////                LocalDateTime.of(2020, 12, 29, 13, 00),
////                30,
////                planeService.findPlaneById(1l)));
////        routeList.add(new Route(airportService.findAirportById(1l), airportService.findAirportById(1l),
////                LocalDateTime.of(2020, 12, 29, 14, 00),
////                LocalDateTime.of(2020, 12, 29, 15, 00),
////                10,
////                planeService.findPlaneById(1l)));
////        routeList.add(new Route(airportService.findAirportById(1l), airportService.findAirportById(1l),
////                LocalDateTime.of(2020, 12, 31, 23, 59),
////                LocalDateTime.of(2021, 1, 1, 0, 59),
////                30,
////                planeService.findPlaneById(1l)));
//    }
}
