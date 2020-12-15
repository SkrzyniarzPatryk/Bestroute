package pl.akademiakodu.bestroute.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.akademiakodu.bestroute.model.Comfort;
import pl.akademiakodu.bestroute.model.Plane;
import pl.akademiakodu.bestroute.repository.PlaneDao;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlaneServiceImpl implements PlaneService {
    private List<Plane> planeList;
    private PlaneDao planeDao;

    @Autowired
    public PlaneServiceImpl(PlaneDao planeDao) {
        System.out.println("Plane serwis - zaczynam");

        this.planeDao = planeDao;
        createPlanes();
      //  List<Plane> planeList = new ArrayList<>();
    //    planeList = planeDao.findAllPlanes();
//        for (Plane plane : planeList) {
//            System.out.println(plane );
//        }
//        System.out.println("Plane serwis - kończę");
       // System.out.println(this.planeList.get(0).getComfort().getName());
        //planeDao.createPlane(new Plane(2l, "ptak2", Comfort.ECONOMIC_CLASS));
       // System.out.println(planeDao.findPlaneByNameSQL("ptak1").getComfort().getName());
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
        planeList.add(new Plane(1l, "Boeing 747", Comfort.BUSSINES_CLASS));
        planeList.add(new Plane(2l, "Saab 307", Comfort.ECONOMIC_CLASS));
    }
}
