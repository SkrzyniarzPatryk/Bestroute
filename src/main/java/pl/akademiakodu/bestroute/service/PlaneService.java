package pl.akademiakodu.bestroute.service;

import pl.akademiakodu.bestroute.model.Plane;

public interface PlaneService {
    public Plane findPlaneById(Long id);
    public Plane findPlaneByName(String name);
}
