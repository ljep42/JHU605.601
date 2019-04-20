package game;

import java.util.ArrayList;


public class Room implements Location {
    private String name;
    private Location location;
    private ArrayList<Player> players;
    private boolean passageway = false;
    private boolean isEmpty;

    public Room(String name) {
        this.name = name;
        isEmpty = true;
        players = new ArrayList<>();
    }

//    public void removePlayer(Player player) {
//        players.remove(player);
//    }

//    public ArrayList<Player> getOccupants() {
//        return players;
//    }
//
//    public int getNumPlayers() {
//        return players.size();
//    }
//
//    
//
//    public Location getlocation() {
//        return location;
//    }
//
//    public void setlocation(Location location) {
//        this.location = location;
//    }

    public void setName(String name){
        this.name = name;
    }
    
    public void setPassageway(Boolean passageway){
        this.passageway = passageway;
    }
    
    public Boolean getPassageway() {
        return passageway;
    }
    
    
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public boolean isEmpty() {
        if (players.size() == 0) {
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public void addPlayer(Player player) {
        players.add(player);
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
    
    
}
