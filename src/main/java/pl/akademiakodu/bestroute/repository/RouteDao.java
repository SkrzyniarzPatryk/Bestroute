package pl.akademiakodu.bestroute.repository;

import pl.akademiakodu.bestroute.model.Plane;
import pl.akademiakodu.bestroute.model.Route;

import java.util.List;

public interface RouteDao {
    void createRoute(Route route);
    List<Route> findAllRoutes();
    void updateRoute(Route route);
    void deleteRoute(Long id);
    Route findRouteByIdSQL(Long id);

}
