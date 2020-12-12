package pl.akademiakodu.bestroute.service;

import pl.akademiakodu.bestroute.model.Route;

import java.util.List;
import java.util.Set;

public interface RouteService {
    public List<Route> getRoutes();
    public Route findRouteByName(String name);
    public Set<Route> searchRoutesByAirport(String name);
}
