////////////////////////////////////////////////////////////////////////////////
// Authors: Juan Luis Suárez Díaz, Andrés Herrera Poyatos
// Universidad de Granada, March, 2015
// Programación Orientada a Objetos - Napakalaki
////////////////////////////////////////////////////////////////////////////////

package Model;

/**
 *
 * @author andreshp
 */
public class BadConsequenceDeath extends BadConsequence {
    
    /**
     * Constructor that initializes the attributes text and death.
     */
    public BadConsequenceDeath(String text, boolean death){
        super(text,0,0,0,null,null,death);
    }
    
    /**
     * Subtracts the visible treasure given from the bad consequence.
     * 
     * Do nothing since it is a death bad consequence.
     * 
     * @param t Treasure to subtract.
     */
    @Override
    public void subtractVisibleTreasure(Treasure t){
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
     * @return String with the contents.
     */
    public String toString(){
        // Read only variable with the number of spaces to print in each line.
        final int num_spaces = 5;
        String strSpaces = new String(new char[num_spaces]).replace('\0', ' ');

        return strSpaces + "Text = " + text 
               + "\n"+ strSpaces + "Levels = " + Integer.toString(levels)
               + "\n"+ strSpaces + "Death = " + Boolean.toString(death);
    }
}
