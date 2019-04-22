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
     * Gets name of location
     * @return String
     */
    public String getName();
    
    /**
     * checks if location is empty
     * @return True is area is empty
     */
    public boolean isEmpty();
    
    /**
     * Adds player to location
     * @param player 
     */
    public void addPlayer(Player p);
    
    /**
     * gets location returns array for x,y coordinates
     * @return array of int
     */
    public int[] getLocation();
    
    /**
     * sets location
     * @param loc 
     */
    public void setLocation(int[] loc);
    
    /**
     * get player list in location
     * @param p
     * @return Player
     */
    public ArrayList<Player> getPlayers();
    
    /**
     * Remove's player from location
     * @param p
     * @return 
     */
    public void removePlayer(Player p);
    
}
