package game;

import java.util.ArrayList;


public class Hallway implements Location {
    private String name;
    private Location location;
    private ArrayList<Player> players;
    private boolean passageWay = false;
    private boolean isEmpty;
    
    public Hallway(String name, Location loc) {
        this.name = name;
        this.location = loc;
        isEmpty = true;
        players = new ArrayList<>();
        
    }
    
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isEmpty() {
        return isEmpty;
    }
    
    @Override
    public void addPlayer(Player p) {
        
    }

    @Override
    public int[] getLocation() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setLocation(int[] loc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Player getPlayer(int[] p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Player removePlayer(Player p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    public void setEmpty(boolean isEmpty) {
//        this.isEmpty = isEmpty;
//    }

//    public Location getlocation() {
//        return location;
//    }
//
//    public void setlocation(Location loc) {
//        this.location = loc;
//    }

    

    
}
