package game;

import java.util.ArrayList;


public class Hallway implements Location {
    private String name;
    private int[] location;
    private ArrayList<Player> players;
    private boolean passageWay = false;
    private boolean isEmpty;
    
    // constructor
    public Hallway(String name, int[] loc) {
        this.name = name;
        isEmpty = true;
        this.location = location;
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
        if(players.size() < 1) {
            players.add(p);
        }
        else 
            System.out.println("unable to move, space is occupied");
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
        loc[0] = location[0];
        loc[1] = location[1];
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
