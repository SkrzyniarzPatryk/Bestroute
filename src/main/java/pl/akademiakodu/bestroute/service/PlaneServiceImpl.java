package pl.akademiakodu.bestroute.service;

import org.springframework.stereotype.Service;
import pl.akademiakodu.bestroute.model.Plane;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlaneServiceImpl implements PlaneService {
    List<Plane> planeList;

    public PlaneServiceImpl() {
        createPlanes();
    }

    @Override
    public Plane findPlaneById(Long id) {
        return planeList.stream().filter(plane -> plane.getId().equals(id)).findFirst().get();
    }

    @Override
    public Plane findPlaneByName(String name) {
        return planeList.stream().filter(plane -> plane.getNameUrl().equals(name)).findFirst().get();
    }

    private void createPlanes() {
        planeList = new ArrayList<>();
        planeList.add(new Plane("Boeing 747", 1));
        planeList.add(new Plane("Saab 307", 3));
    }
}
