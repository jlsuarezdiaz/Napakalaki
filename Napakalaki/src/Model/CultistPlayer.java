////////////////////////////////////////////////////////////////////////////////
// Authors: Juan Luis Suárez Díaz, Andrés Herrera Poyatos
// Universidad de Granada, March, 2015
// Programación Orientada a Objetos - Napakalaki
////////////////////////////////////////////////////////////////////////////////

package Model;

import java.util.ArrayList;

/**
 * Cultist Player Class.
 * This class represents a cultist player in Napakalaki game.
 * @author andreshp, jlsuarez
 */
public class CultistPlayer extends Player {

    //--------------- CLASS ATTRIBUTES AND METHODS ---------------//

    /**
     * Number of cultist players in the game.
     */
    public static int totalCultistPlayers = 0;

    /**
     * Get the number of cultist players in the game.
     * @return totalCultistPlayer
     */
    public static int getTotalCultistPlayers(){
        return totalCultistPlayers;
    }

    //--------------- INSTANCE ATTRIBUTES AND METHODS ---------------//

    //--------------- ATTRIBUTES ---------------//

    /**
     * Player's cultist card.
     * It contains the cultist's bonus.
     */
    private Cultist myCultistCard;
    
    //--------------- CONSTRUCTOR ---------------//

    /**
     * Constructor for a cultist player.
     * @param p Player that is converted to cultist.
     * @param c Cultist card assigned to the player.
     */
    public CultistPlayer(Player p, Cultist c) {
        super(p);
        myCultistCard = c;
        totalCultistPlayers++;  
    }
    
    //--------------- PUBLIC METHODS ---------------//
    
    /**
     * Overrides Player's computeGoldCoinsValue method.
     * @return Player's gold coins multiplied by 2.
     */
    @Override
    public float computeGoldCoinsValue(ArrayList<Treasure> t) {
        return super.computeGoldCoinsValue(t)*2;
    }
    
    /**
     * Overrides Player's getCombatLevel method.
     * @return Player's combat level plus the cultist bonus.
     */
    @Override
    public int getCombatLevel() {
        return super.getCombatLevel() + myCultistCard.getSpecialValue();
    }
    
    /**
     * Gets the player's cultist card.
     * @return myCultistCard
     */
    public Cultist getCultist(){
        return myCultistCard;
    }

    /**
     * Overrides Player's getOpponentLevel method.
     * @param m Monster to fight against.
     * @return Monster's level when fighting against a cultist player.
     */
    @Override
    public int getOpponentLevel(Monster m){
        return m.getSpecialValue();
    }

    /**
     * Overrides Player's shouldConvert method.
     * @return False. A cultist player can't be converted again.
     */
    @Override
    public boolean shouldConvert(){
        return false;
    }
    
    /**
     * Overrides Player's toString method.
     * @return String with the player info.
     */
    @Override
    public String toString(){
        return super.toString()
                + "\nCarta de sectario:"
                + "\n    " + myCultistCard.toString();
    }
}
