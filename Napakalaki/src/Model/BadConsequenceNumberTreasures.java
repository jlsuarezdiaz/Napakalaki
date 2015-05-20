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
public class BadConsequenceNumberTreasures extends BadConsequence {

    //--------------- ATTRIBUTES ---------------//

    /**
     * Levels that are lost with the bad consequence.
     */
    protected int levels;

    /**
     * Number of Visible Treasures that are lost. 
     */
    protected int nVisibleTreasures;

    /**
     * Number of Hidden Treasures that are lost. 
     */
    protected int nHiddenTreasures;

    //--------------- CONSTRUCTOR ---------------//

    /**
     * Constructor that initializes the attributes text, levels and both number
     * of treasures.
     * @param text Bad Consequence text.
     * @param levels Levels that the player loses as bad consequence.
     * @param nVisible Number of visible treasures that the player loses.
     * @param nHidden Number of hidden treasures that the player loses.
     */
    public BadConsequenceNumberTreasures(String text, int levels, int nVisible, 
            int nHidden){
        this.text = text;
        this.levels = levels;
        this.nVisibleTreasures = nVisible;
        this.nHiddenTreasures = nHidden;
    }

    //--------------- GET METHODS ---------------//

    /**
     * Get the levels attribute.
     * @return levels
     */
    @Override
    public int getLevels(){
        return levels;
    }

    /**
     * Get the nVisibleTreasures attribute.
     * @return nVisibleTreasures
     */
    public int getNVisibleTreasures(){
        return nVisibleTreasures;
    }

    /**
     * Get the nHiddenTreasures attribute.
     * @return nHiddenTreasures
     */
    public int getNHiddenTreasures(){
        return nHiddenTreasures;
    }

    /**
     * Check if the bad consequence kills the player.
     * @return false
     */
    @Override
    public boolean kills(){
        return false;
    }

    //--------------- OTHER PUBLIC METHODS ---------------//

    /**
     * Create a new BadConsequence in order to get the player to be able to carry it out completely.
     * @param visible Visible treasures of the player.
     * @param hidden Hidden treasures of the player
     * @return A new bad consequence reduced according to visible and hidden player treasures.
     */
    @Override
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> visible, ArrayList<Treasure> hidden){

        int newnvisible = Integer.min(this.nVisibleTreasures,visible.size());
        int newnhidden = Integer.min(this.nHiddenTreasures,hidden.size());

        return new BadConsequenceNumberTreasures("Queda por cumplir:", 0, newnvisible, newnhidden);
    }

    /**
     * Check if the Bad Consequence is empty.
     * 
     * A BadConsequenceNumberTreasures is empty if levels, nVisibleTreasures
     * and nHiddenTreasures are 0.
     * 
     * @return Result of the comparison.
     */
    @Override
    public boolean isEmpty(){
        return levels == 0 && nVisibleTreasures == 0 && nHiddenTreasures == 0;
    }

    /**
     * Subtracts the visible treasure given from the bad consequence.
     * 
     * The number of visible treasures is decremented. 
     * 
     * @param t Treasure to subtract.
     */
    @Override
    public void subtractVisibleTreasure(Treasure t){
        nVisibleTreasures -= nVisibleTreasures > 0? 1 : 0;
    }

    /**
     * Subtracts the hidden treasure given from the bad consequence.
     * 
     * The number of hidden treasures is decremented. 
     * 
     * @param t Treasure to subtract.
     */
    @Override
    public void subtractHiddenTreasure(Treasure t){
        nHiddenTreasures -= nHiddenTreasures > 0? 1 : 0;
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
               + "\n"+ strSpaces + "Levels = " + Integer.toString(levels)
               + "\n"+ strSpaces + "nVisibleTreasures = " + Integer.toString(nVisibleTreasures)
               + "\n"+ strSpaces + "nHiddenTreasures = " + Integer.toString(nHiddenTreasures);
    }
}