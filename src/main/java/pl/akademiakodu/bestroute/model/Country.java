package pl.akademiakodu.bestroute.model;

public enum Country {
    POLAND("Polska"),
    DEUTSCHLAND("Niemcy"),
    NEW_ZELAND("Nowa Zelandia");

    private String name;

    public String getName() {
        return name;
    }
    Country(String name) {
        this.name = name;
    }
}
