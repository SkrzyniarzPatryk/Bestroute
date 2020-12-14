package pl.akademiakodu.bestroute.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.akademiakodu.bestroute.model.Airport;

import java.util.List;

@Repository
public class AirportDaoImpl implements AirportDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public AirportDaoImpl(JdbcTemplate jdbcTemplate) {
        System.out.println("Baza - zaczynam");

        this.jdbcTemplate = jdbcTemplate;
        System.out.println("Baza - kończe");

    }

    @Override
    public void createAirport(Airport airport) {
        String sql = "INSERT INTO airports VALUES (null, ?, ?)";
        jdbcTemplate.update(sql, airport.getName(), airport.getCountry());
    }

    @Override
    public List<Airport> findAllAirports() {
        String sql = "SELECT * FROM airports";

        List<Airport> airportList = jdbcTemplate.query(sql, (rs, rowNuw) ->
                new Airport(rs.getLong("ID"),
                        rs.getString("NAME"),
                        rs.getString("COUNTRY")
                ));
        return airportList;
    }

    @Override
    public void updateAirport(Airport airport) {

    }

    @Override
    public void deleteAirport(Long id) {
        String sql = "DELETE FROM airports WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public Airport findAirportByNameSQL(String name) {
        String sql = "SELECT * FROM airports a WHERE a.name = '" + name + "'";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) ->
                new Airport(rs.getLong("ID"),
                        rs.getString("NAME"),
                        rs.getString("COUNTRY")
                ));
    }

    @Override
    public Airport findAirportByIdSQL(Long id) {
        String sql = "SELECT * FROM airports a WHERE a.id = " + id;
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) ->
                new Airport(rs.getLong("ID"),
                        rs.getString("NAME"),
                        rs.getString("COUNTRY")
                ));
    }
}
