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
    private AirportDao airportDao;
    private PlaneDao planeDao;

    @Autowired
    public RouteDaoImpl (JdbcTemplate jdbcTemplate, PlaneDao planeDao, AirportDao airportDao) {
        this.jdbcTemplate = jdbcTemplate;
        this.airportDao = airportDao;
        this.planeDao = planeDao;
    }

    @Override
    public void createRoute(Route route) {
        String sql = "INSERT INTO routes VALUES (null, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, route.getStartAirport().getId(), route.getDestinationAirport().getId(), route.getPlane().getId(),
                route.getDepartureDate(), route.getArrivalDate(), route.getDelay());
    }

    @Override
    public List<Route> findAllRoutes() {
        List<Route> routeList = new ArrayList<>();
        String sql = "SELECT * FROM routes";
        routeList = jdbcTemplate.query(sql, (rs, rowNum) ->
                new Route(rs.getLong("ID"),
                        airportDao.findAirportByIdSQL(rs.getLong("ID_START_AIRPORT")),
                        airportDao.findAirportByIdSQL(rs.getLong("ID_DESTINATION_AIRPORT")),
                        planeDao.findPlaneByIdSQL(rs.getLong("ID_PLANE")),
                        rs.getTimestamp("DATETIME_DEPARTURE").toLocalDateTime(),
                        rs.getTimestamp("DATETIME_ARRIVAL").toLocalDateTime(),
                        rs.getInt("DELAY")
                        ));
        return routeList;
    }

    @Override
    public void updateRoute(Route route) {
        String sql = "UPDATE routes r SET r.ID_START_AIRPORT = ?, " +
                "r.ID_DESTINATION_AIRPORT = ?, " +
                "r.ID_PLANE = ?, " +
                "r.DATETIME_DEPARTURE = ?, " +
                "r.DATETIME_ARRIVAL = ?, " +
                "r.DELAY = ? " +
                "WHERE r.ID = ?";
        jdbcTemplate.update(sql, route.getStartAirport().getId(), route.getDestinationAirport().getId(),
                route.getPlane().getId(), route.getDepartureDateLocal(), route.getArrivalDateLocal(), route.getDelay(), route.getId());
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
                new Route(id,
                        airportDao.findAirportByIdSQL(rs.getLong("ID_START_AIRPORT")),
                        airportDao.findAirportByIdSQL(rs.getLong("ID_DESTINATION_AIRPORT")),
                        planeDao.findPlaneByIdSQL(rs.getLong("ID_PLANE")),
                        rs.getTimestamp("DATETIME_DEPARTURE").toLocalDateTime(),
                        rs.getTimestamp("DATETIME_ARRIVAL").toLocalDateTime(),
                        rs.getInt("DELAY")
                ));
    }
}
