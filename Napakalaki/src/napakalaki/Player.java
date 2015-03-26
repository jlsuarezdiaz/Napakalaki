//////////////////////////////////////////////////////////////////////////////////////
// Authors: Juan Luis Suárez Díaz, Andrés Herrera Poyatos
// Universidad de Granada, March, 2015
// Programación Orientada a Objetos - Napakalaki
//////////////////////////////////////////////////////////////////////////////////////
package napakalaki;

import java.util.ArrayList;

/**
 * Player Class.
 * This class represents a player in Napakalaki game.
 * @author andreshp, jlsuarez
 */
public class Player {
    
    //------------- Private attributes ---------------//
    
    /**
     * Player's name.
     */
    private String name;
    
    /**
     * Player's level.
     */
    private int level;
    
    /**
     * Attribute shows whether the player is dead.
     */
    private boolean dead;
    
    /**
     * Constant value showing maximum number of Hidden Treasure enabled.
     */
    private static final int MAXHIDDENTREASURES = 4;
    
    /**
     * Player's visible treasures.
     */
    private ArrayList<Treasure> visibleTreasures;
    
    /**
     * Player's hidden treasures.
     */
    private ArrayList<Treasure> hiddenTreasures;
    
    /**
     * Player's pending Bad Consequence.
     */
    private BadConsequence pendingBadConsequence;
    
    //--------------- Private Methods ----------------//
    
    /**
     * Brings the player to life.
     */
    private void bringToLife(){
        this.dead = true;
    }
    
    /**
     * Increases player's level.
     * @param levels Amount of levels to increase.
     */
    private void increaseLevel(int levels){
        this.level += levels;
    }
    
    /**
     * Decreases players level.
     * @param levels Amount of levels to decrease.
     */
    private void decreaseLevel(int levels){
        this.level = (this.level - levels >= 1)?this.level - levels: 1;
    }
    
    
    private void setPendingBadConsequence(BadConsequence b){
        this.pendingBadConsequence = b;
    }
    
    private void die(){
        this.dead = true;
        this.level = 1;
        this.visibleTreasures = new ArrayList();
        this.hiddenTreasures = new ArrayList();
    }
    
    private void discardNecklaceIfVisible(){
        
    }
    
    private void dieIfNoTreasures(){
        
    }

    
    
    
    //--------------- Constructors ---------------//
    
    public Player(String name){
        this.name = name;
        this.level = 1;
        this.dead = true;
        this.hiddenTreasures = new ArrayList();
        this.visibleTreasures = new ArrayList();
    }
}   
