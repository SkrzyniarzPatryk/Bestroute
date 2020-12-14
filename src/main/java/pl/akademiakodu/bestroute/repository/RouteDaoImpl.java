package pl.akademiakodu.bestroute.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.akademiakodu.bestroute.model.Route;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RouteDaoImpl implements RouteDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public RouteDaoImpl (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        System.out.println("baza tras");
    }

    @Override
    public void createRoute(Route route) {
        String sql = "INSERT INTO routes VALUES (null, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, route.getIdStartAirport(), route.getIdDestinationAirport(), route.getIdPlane(),
                route.getDepartureDate(), route.getArrivalDate(), route.getDelay());
    }
//route.getStartAirport().getId()route.getDestinationAirport().getId() route.getPlane().getId()
    @Override
    public List<Route> findAllRoutes() {
        List<Route> routeList = new ArrayList<>();
        String sql = "SELECT * FROM routes";
        routeList = jdbcTemplate.query(sql, (rs, rowNum) ->
                new Route(rs.getLong("ID"),
                        rs.getLong("ID_START_AIRPORT"),
                        rs.getLong("ID_DESTINATION_AIRPORT"),
                        rs.getLong("ID_PLANE"),
                        rs.getTimestamp("DATETIME_DEPARTURE").toLocalDateTime(),
                        rs.getTimestamp("DATETIME_ARRIVAL").toLocalDateTime(),
                        rs.getInt("DELAY")
                        ));
        return routeList;
    }

    @Override
    public void updateRoute(Route route) {

    }

    @Override
    public void deleteRoute(Long id) {
        String sql = "DELETE FROM routes WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public Route findRouteByIdSQL(Long id) {
        String sql = "SELECT * FROM routes r WHERE r.id = " + id;
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) ->
                new Route(rs.getLong("ID"),
                        rs.getLong("ID_START_AIRPORT"),
                        rs.getLong("ID_DESTINATION_AIRPORT"),
                        rs.getLong("ID_PLANE"),
                        rs.getTimestamp("DATETIME_DEPARTURE").toLocalDateTime(),
                        rs.getTimestamp("DATETIME_ARRIVAL").toLocalDateTime(),
                        rs.getInt("DELAY")
                ));
    }
}
