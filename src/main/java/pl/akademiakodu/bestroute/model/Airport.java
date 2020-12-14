package pl.akademiakodu.bestroute.model;

public class Airport {
    private Long id;
    private String country;
    private String name;
    private static Long index = 1l;

    public Airport(String country, String name) {
        this.country = country;
        this.name = name;
        this.id = index++;
    }

    //ToSql
    public Airport(Long id, String country, String name) {
        this.id = id;
        this.name = name;
        this.country = country;
    }

    //==--GettersAndSetters--==
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
