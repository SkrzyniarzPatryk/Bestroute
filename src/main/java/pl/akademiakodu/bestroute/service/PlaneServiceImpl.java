package pl.akademiakodu.bestroute.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.akademiakodu.bestroute.model.Plane;
import pl.akademiakodu.bestroute.repository.PlaneDao;

import java.util.List;

@Service
public class PlaneServiceImpl implements PlaneService {
  //  private List<Plane> planeList;
    private PlaneDao planeDao;

    @Autowired
    public PlaneServiceImpl(PlaneDao planeDao) {
        this.planeDao = planeDao;
       // createPlanes();
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
    public List<Plane> getPlanes() {
        return planeDao.findAllPlanes();
    }

    @Override
    public Plane findPlaneById(Long id) {
        return planeDao.findPlaneByIdSQL(id);
    }

    @Override
    public Plane findPlaneByName(String name) {
        return planeDao.findPlaneByNameSQL(name);
    }

    @Override
    public boolean isPlaneLegit(Plane plane) {
        if (plane.getName().isEmpty()) {
            return false;
        }
        return true;
    }

    @Override
    public void addPlane(Plane plane) {
        planeDao.createPlane(plane);
    }

//    private void createPlanes() {
//        planeDao.createPlane(new Plane(1l, "Boeing 747", Comfort.ECONOMIC_CLASS));
//        planeDao.createPlane(new Plane(2l, "EMBRAER LEGACY 500", Comfort.FIRST_CLASS));
//        planeDao.createPlane(new Plane(3l, "Boeing 737", Comfort.BUSSINES_CLASS));
//
////        planeList = new ArrayList<>();
////        planeList.add(new Plane(1l, "Boeing 747", Comfort.BUSSINES_CLASS));
////        planeList.add(new Plane(2l, "Saab 307", Comfort.ECONOMIC_CLASS));
//    }
}
