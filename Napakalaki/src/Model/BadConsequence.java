////////////////////////////////////////////////////////////////////////////////
// Authors: Juan Luis Suárez Díaz, Andrés Herrera Poyatos
// Universidad de Granada, March, 2015
// Programación Orientada a Objetos - Napakalaki
////////////////////////////////////////////////////////////////////////////////

package Model;

import java.util.ArrayList; // ArrayList included
import java.util.Collections;

/**
 * Bad Consequence Class.
 * It indicates the consequences of losing to a monster.
 * These consequences are levels or treasures lost and even death.
 * 
 * @author andreshp, jlsuarez
 */
public abstract class BadConsequence {

    //--------------- ATTRIBUTES ---------------//
    
    /**
     * Text that explains what does the bad consequence do.
     */
    protected String text;
    
    //--------------- GET METHODS ---------------//

    /**
     * Get the text attribute.
     * @return text
     */ 
    public String getText(){
        return text;
    }

    /**
     * Get the levels lost by the player.
     * 
     * Each child must implements this method since some of them does not
     * have the levels attribute.
     * 
     * @return levels lost
     */
    abstract public int getLevels();

    //--------------- OTHER PUBLIC METHODS ---------------//

    /**
     * Create a new BadConsequence in order to get the player to be able to 
     * carry it out completely.
     * @param visible Visible treasures of the player.
     * @param hidden Hidden treasures of the player
     * @return A new bad consequence reduced according to visible and hidden 
     * player treasures.
     */
    abstract public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> visible, ArrayList<Treasure> hidden);

    /**
     * Check if the Bad Consequence is empty.
     * 
     * A BadConsequence is empty if every attribute is initialized to 0, false,
     * null or "" in case of strings.
     * 
     * @return Result of the comparison.
     */
    abstract public boolean isEmpty();

    /**
     * Subtracts the visible treasure given from the bad consequence.
     * 
     * If the bad consequence just ask for a number of visible treasures then
     * that number is decremented. Else if the bad consequence ask for specific
     * visible treasures, subtract t.getType() from the specific treasures
     * asked.
     * 
     * @param t Treasure to subtract.
     */
    abstract public void subtractVisibleTreasure(Treasure t);

    /**
     * Subtracts the hidden treasure given from the bad consequence.
     * 
     * If the bad consequence just ask for a number of hidden treasures then
     * that number is decremented. Else if the bad consequence ask for specific
     * hidden treasures, subtract t.getType() from the specific treasures
     * asked.
     * 
     * @param t Treasure to subtract.
     */
    abstract public void subtractHiddenTreasure(Treasure t);

    /**
     * Returns a string with the Bad Consequence instance contents.
     * @param numSpaces Integer with the number of spaces in the paragraph indentation.
     * @return String with the contents.
     */
    public String toString(int numSpaces){
        String strSpaces = new String(new char[numSpaces]).replace('\0', ' ');
        return strSpaces + "Esto es un mal rollo con el siguiente contenido:\n";
    }    
}
