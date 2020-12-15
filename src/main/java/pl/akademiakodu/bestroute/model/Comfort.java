package pl.akademiakodu.bestroute.model;

public enum Comfort {
    BUSSINES_CLASS("Klasa biznesowa"),
    ECONOMIC_CLASS("Klasa ekonomiczna"),
    FIRST_CLASS("Pierwsza klasa");

    private String name;

    public String getName() {
        return name;
    }

    Comfort(String name) {
        this.name = name;
    }
}
