package game;


public class Location {

    private int [] location = new int[2];

    public Location(int [] c) {
        this.location = c;
    }
    
    public void setLocation(int [] c) {
        this.location = c;
    }
    
    public int [] getLocation() {
        return location;
    }

}
