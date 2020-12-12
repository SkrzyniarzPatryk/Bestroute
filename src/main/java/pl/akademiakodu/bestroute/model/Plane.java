package pl.akademiakodu.bestroute.model;

public class Plane {
    private Long id;
    private String name;
    private String nameUrl;
    private Integer comfort;
    private static Long index = 1l;

    public Plane(String name, Integer comfort) {
        this.name = name;
        this.comfort = comfort;
        this.id = index++;
        makeName();
    }

    public String getDetailsPlane() {
        return "/plane/details/" + id;
    }
    public String getPlaneImage() {
        return "/plane/" + nameUrl + "jpg";
    }
    //==--Private method--==
    private void makeName() {
        nameUrl = Funcion.getNameWithoutSpace(name);
    }
    //==--GettersAndSetters--==
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameUrl() {
        return nameUrl;
    }


    public void setNameUrl(String nameUrl) {
        this.nameUrl = nameUrl;
    }

    public Integer getComfort() {
        return comfort;
    }

    public void setComfort(Integer comfort) {
        this.comfort = comfort;
    }
}
