/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.ArrayList;

/**
 *
 * @author Lee
 */
public interface Location {
    
    /**
     * Gets name of player
     * @return String
     */
    public String getName();
    
    /**
     * checks if area is empty
     * @return True is area is empty
     */
    public boolean isEmpty();
    
    /**
     * Adds player to room
     * adds player to list for room
     * @param player 
     */
    public void addPlayer(Player p);
    
    /**
     * gets location returns array for x,y coordinates
     * @return 
     */
    public int[] getLocation();
    
    /**
     * sets location
     * @param loc 
     */
    public void setLocation(int[] loc);
    
    /**
     * get player list in hallway or room/location
     * @param p
     * @return Player
     */
    public ArrayList<Player> getPlayers();
    
    /**
     * 
     * @param p
     * @return 
     */
    public void removePlayer(Player p);
    
}
