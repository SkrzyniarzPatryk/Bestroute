package pl.akademiakodu.bestroute.service;

import org.springframework.web.bind.annotation.RequestParam;
import pl.akademiakodu.bestroute.model.Route;

import java.util.List;
import java.util.Set;

public interface RouteService {
    public List<Route> getRoutes();
    public Route findRouteByName(String name);
    public Set<Route> searchRoutesByAirport(String start_airport, String end_airport, String from_date, String to_date, String comfort);
    public Route findRouteById(Long id);
    void addRoute(Route route);
    boolean isRouteLegit(Route route);
    void removeRoute(Long id);

    void editRoute(Route route);

    List<Route> getFavoriteRoutes();
    void changeFavorite(Long id);
    boolean isFavorite(Long id);
}
