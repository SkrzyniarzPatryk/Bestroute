package pl.akademiakodu.bestroute.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.akademiakodu.bestroute.model.Route;

import java.util.List;

@Repository
public class RouteDaoImpl implements RouteDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public RouteDaoImpl (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void createRoute(Route route) {
        System.out.println(java.sql.Timestamp.valueOf(route.getDepartureDate()));
        String sql = "INSERT INTO routes VALUES (null, ?, ?, ?, ?, ?, ?)";
      //  String sql = "INSERT INTO airports VALUES (null, 'warsaw1', 'poland')";
        jdbcTemplate.update(sql, route.getStartAirport().getId(), route.getDestinationAirport().getId(), route.getPlane().getId(),
                java.sql.Timestamp.valueOf(route.getDepartureDate()).toString(), java.sql.Timestamp.valueOf(route.getArrivalDate()).toString(), route.getDelay());
        //jdbcTemplate.update(sql);
        System.out.println("=====================");

    }

    @Override
    public List<Route> findAllRoutes() {
        return null;
    }

    @Override
    public void updateRoute(Route route) {

    }

    @Override
    public void deleteRoute(Long id) {

    }
}
