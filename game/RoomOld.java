package game;

import java.util.ArrayList;


public class RoomOld {
    private String name;
    private LocationOld location;
    private boolean passageway = false;
    private boolean occupied;
    private ArrayList<Player> players;

    public RoomOld(String name) {
        this.name = name;
        occupied = false;
        players = new ArrayList<Player>();
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void removePlayer(Player player) {
        players.remove(player);
    }

    public ArrayList<Player> getOccupants() {
        return players;
    }

    public int getNumPlayers() {
        return players.size();
    }

    public boolean isEmpty() {
        if (players.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public LocationOld getlocation() {
        return location;
    }

    public void setlocation(LocationOld location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }
}
