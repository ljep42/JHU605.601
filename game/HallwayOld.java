package game;


public class HallwayOld {
    private String name;
    private LocationOld location;
    private boolean isEmpty;

    public HallwayOld(String name, LocationOld location) {
        this.name = name;
        this.location = location;
        isEmpty = true;
    }

    public String getName() {
        return name;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean isEmpty) {
        this.isEmpty = isEmpty;
    }

    public LocationOld getlocation() {
        return location;
    }

    public void setlocation(LocationOld location) {
        this.location = location;
    }
}
