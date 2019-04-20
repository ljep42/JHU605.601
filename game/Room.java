package game;

import java.util.ArrayList;


public class Room implements Location {
    private String name;
    private int[] location;
    private ArrayList<Player> players;
    private boolean passageway = false;
    private boolean isEmpty;

    public Room(String name) {
        this.name = name;
        isEmpty = true;
        players = new ArrayList<>();
        location = new int[2];
    }

    public void setName(String name){
        this.name = name;
    }
    
    public void setPassageway(Boolean passageway){
        this.passageway = passageway;
    }
    
    public Boolean getPassageway() {
        if (passageway)
            return true;
        else
            return false;
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
    public void addPlayer(Player p) {
        players.add(p);
    }

    @Override
    public int[] getLocation() {
        int[] arr = new int[2];
        arr[0] = location[0];
        arr[1] = location[1];
        
        return arr;
    }

    @Override
    public void setLocation(int[] loc) {
        location[0] = loc[0];
        location[1] = loc[1];
    }

    @Override
    public ArrayList<Player> getPlayers() {
        return players;
    }

    @Override
    public void removePlayer(Player p) {
        players.remove(p);
    }
    
    
}
