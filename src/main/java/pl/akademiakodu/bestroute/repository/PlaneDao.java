package pl.akademiakodu.bestroute.repository;

import pl.akademiakodu.bestroute.model.Airport;
import pl.akademiakodu.bestroute.model.Plane;

import java.util.List;

public interface PlaneDao {
    void createPlane(Plane plane);
    List<Plane> findAllPlanes();
    void updatePlane(Plane plane);
    void deletePlane(Long id);
    Plane findPlaneByNameSQL(String name);
    Plane findPlaneByIdSQL(Long id);

}
