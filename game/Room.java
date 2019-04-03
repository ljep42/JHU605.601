package game;

import java.util.ArrayList;


public class Room {
    private String name;
    private Location location;
    private boolean passageway = false;
    private boolean occupied;
    private ArrayList<Player> players;

    public Room(String name) {
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

    public Location getlocation() {
        return location;
    }

    public void setlocation(Location location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }
}
