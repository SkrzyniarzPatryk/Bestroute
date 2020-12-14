package pl.akademiakodu.bestroute.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.akademiakodu.bestroute.model.Plane;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PlaneDaoImpl implements PlaneDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public PlaneDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void createPlane(Plane plane) {
        String sql = "INSERT INTO planes VALUES (null, ?, ?)";
        jdbcTemplate.update(sql, plane.getName(), plane.getComfort());
    }

    @Override
    public List<Plane> findAllPlanes() {
        String sql = "SELECT * FROM planes";

        List<Plane> planeList = new ArrayList<>();
        planeList = jdbcTemplate.query(sql, (rs, rowNum) ->
                new Plane(rs.getLong("ID"),
                        rs.getString("NAME"),
                        rs.getString("COMFORT")
                ));
        return planeList;
    }

    @Override
    public void updatePlane(Plane plane) {

    }

    @Override
    public void deletePlane(Long id) {
        String sql = "DELETE FROM planes WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public Plane findPlaneByNameSQL(String name) {
        String sql = "SELECT * FROM planes p WHERE p.name = '" + name + "'";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) ->
                new Plane(rs.getLong("ID"),
                        rs.getString("NAME"),
                        rs.getString("COMFORT")
                ));
    }

    @Override
    public Plane findPlaneByIdSQL(Long id) {
        String sql = "SELECT * FROM planes p WHERE p.id = " + id;
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) ->
                new Plane(rs.getLong("ID"),
                        rs.getString("NAME"),
                        rs.getString("COMFORT")
                ));
    }
}
