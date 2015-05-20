////////////////////////////////////////////////////////////////////////////////
// Authors: Juan Luis Suárez Díaz, Andrés Herrera Poyatos
// Universidad de Granada, March, 2015
// Programación Orientada a Objetos - Napakalaki
////////////////////////////////////////////////////////////////////////////////
package Model;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author andreshp
 */
public class BadConsequenceNumberTreasures extends BadConsequence {
    /**
     * Constructor that initializes the attributes text, levels and both treasures array.
     */
    public BadConsequenceNumberTreasures(String text, int levels, int nVisible,
            int nHidden){
        super(text,levels,nVisible,nHidden,null,null,false);
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
    public void subtractHiddenTreasure(Treasure t){
        nHiddenTreasures -= nHiddenTreasures > 0? 1 : 0;
    }
    
    /**
     * Returns a string with the Bad Consequence instance contents.
     * @return String with the contents.
     */
    @Override
    public String toString(){

        // Read only variable with the number of spaces to print in each line.
        final int num_spaces = 5;
        String strSpaces = new String(new char[num_spaces]).replace('\0', ' ');
        
        return super.toString() 
               + strSpaces + "Text = " + text 
               + "\n"+ strSpaces + "Levels = " + Integer.toString(levels)
               + "\n"+ strSpaces + "nVisibleTreasures = " + Integer.toString(nVisibleTreasures)
               + "\n"+ strSpaces + "nHiddenTreasures = " + Integer.toString(nHiddenTreasures);
    }

    /**
     * Create a new BadConsequence in order to get the player to be able to carry it out completely.
     * @param visible Visible treasures of the player.
     * @param hidden Hidden treasures of the player
     * @return A new bad consequence reduced according to visible and hidden player treasures.
     */
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> visible, ArrayList<Treasure> hidden){

        int newnvisible = Integer.min(this.nVisibleTreasures,visible.size());
        int newnhidden = Integer.min(this.nHiddenTreasures,hidden.size());

        return new BadConsequenceNumberTreasures("Queda por cumplir:", 0, newnvisible, newnhidden);
    }
}