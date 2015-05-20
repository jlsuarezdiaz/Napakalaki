////////////////////////////////////////////////////////////////////////////////
// Authors: Juan Luis Suárez Díaz, Andrés Herrera Poyatos
// Universidad de Granada, March, 2015
// Programación Orientada a Objetos - Napakalaki
////////////////////////////////////////////////////////////////////////////////

package Model;

import java.util.ArrayList;

/**
 * Death Bad Consequence Class.
 * Monster's Bad Consequence which implies death.
 *
 * @author andreshp, jlsuarez
 */
public class BadConsequenceDeath extends BadConsequence {

    //--------------- ATTRIBUTES ---------------//

    /**
     * Boolean that indicates if the bad consequence is death.
     */
    protected boolean death;

    //--------------- CONSTRUCTOR ---------------//

    /**
     * Constructor that initializes the attributes text and death.
     */
    public BadConsequenceDeath(String text, boolean death){
        this.text = text;
        this.death = death;
    }

    //--------------- GET METHODS ---------------//

    /**
     * Get the death attribute.
     * @return death
     */
    public boolean kills(){
        return death;
    }

    //--------------- OTHER PUBLIC METHODS ---------------//

    /**
     * Create a new BadConsequence in order to get the player to be able 
     * to carry it out completely.
     * @param visible Visible treasures of the player.
     * @param hidden Hidden treasures of the player
     * @return A new death bad consequence.
     */
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> visible, ArrayList<Treasure> hidden){
        return new BadConsequenceDeath("Queda por cumplir:", true);
    }

    /**
     * Subtracts the visible treasure given from the bad consequence.
     * 
     * The method does nothing since it is a death bad consequence.
     * 
     * @param t Treasure to subtract.
     */
    @Override
    public void subtractVisibleTreasure(Treasure t){
    }

    /**
     * Check if the Bad Consequence is empty.
     * 
     * A death bad consequence is empty if death is false.
     * 
     * @return Result of the comparison.
     */
    @Override
    public boolean isEmpty(){
        return ! this.death;
    }

    /**
     * Subtracts the hidden treasure given from the bad consequence.
     * 
     * Do nothing since it is a death bad consequence.
     * 
     * @param t Treasure to subtract.
     */
    @Override
    public void subtractHiddenTreasure(Treasure t){
    }

    /**
     * Returns a string with the Bad Consequence instance contents.
     * @param numSpaces Integer with the number of spaces in the paragraph indentation.
     * @return String with the contents.
     */
    @Override
    public String toString(int numSpaces){

        String strSpaces = new String(new char[numSpaces]).replace('\0', ' ');

        return super.toString(numSpaces) 
               + strSpaces + "Text = " + text 
               + "\n"+ strSpaces + "Levels = " + Integer.toString(getLevels())
               + "\n"+ strSpaces + "Death = " + Boolean.toString(death);
    }
}
