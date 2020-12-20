package pl.akademiakodu.bestroute.model;

public class Airport {
    private Long id;
    private Country country;
    private String name;

    //ToSql
    public Airport(Long id, Country country, String name) {
        this.id = id;
        this.name = name;
        this.country = country;
    }

    public Airport() {
    }
    public String getAirportImage() {
        return "/airport_img/" + name.replace(' ', '_') + ".jpg";
    }
    public String getDetailsAirport() {
        return "/airport/details/" + id;
    }

    //==--GettersAndSetters--==
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
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
