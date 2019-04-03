package game;


public class Hallway {
    private String name;
    private Location location;
    private boolean isEmpty;

    public Hallway(String name, Location location) {
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

    public Location getlocation() {
        return location;
    }

    public void setlocation(Location location) {
        this.location = location;
    }
}
