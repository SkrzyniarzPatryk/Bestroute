package pl.akademiakodu.bestroute.model;

public class Plane {
    private Long id;
    private String name;
    private String nameUrl;
    private Comfort comfort;

    //ToSql
    public Plane(Long id, String name, Comfort comfort) {
        this.id = id;
        this.name = name;
        this.comfort = comfort;
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

    public Comfort getComfort() {
        return comfort;
    }

    public void setComfort(Comfort comfort) {
        this.comfort = comfort;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nameUrl='" + nameUrl + '\'' +
                ", comfort='" + comfort + '\'' +
                '}';
    }
}
