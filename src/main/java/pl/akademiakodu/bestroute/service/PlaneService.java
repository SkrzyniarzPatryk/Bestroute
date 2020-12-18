package pl.akademiakodu.bestroute.service;

import pl.akademiakodu.bestroute.model.Plane;

import java.util.List;

public interface PlaneService {
    List<Plane> getPlanes();
    Plane findPlaneById(Long id);
    Plane findPlaneByName(String name);

    boolean isPlaneLegit(Plane plane);

    void addPlane(Plane plane);
}
