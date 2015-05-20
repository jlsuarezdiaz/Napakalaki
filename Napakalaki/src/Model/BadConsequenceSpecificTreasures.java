////////////////////////////////////////////////////////////////////////////////
// Authors: Juan Luis Suárez Díaz, Andrés Herrera Poyatos
// Universidad de Granada, March, 2015
// Programación Orientada a Objetos - Napakalaki
////////////////////////////////////////////////////////////////////////////////

package Model;

import java.util.ArrayList;

/**
 *
 * @author andreshp
 */
public class BadConsequenceSpecificTreasures extends BadConsequence {
    /**
     * Constructor that initializes the attributes text, levels and both treasures array.
     */
    public BadConsequenceSpecificTreasures(String text, int levels, ArrayList<TreasureKind> tVisible,
            ArrayList<TreasureKind> tHidden){
        super(text,levels,0,0,tVisible,tHidden,false);
    }
    
    /**
     * Subtracts the visible treasure given from the bad consequence.
     * 
     * Subtract t.getType() from the specific treasures
     * asked.
     * 
     * @param t Treasure to subtract.
     */
    @Override
    public void subtractVisibleTreasure(Treasure t){
        specificVisibleTreasures.remove(t.getType());
    }

    /**
     * Subtracts the hidden treasure given from the bad consequence.
     * 
     * Subtract t.getType() from the specific treasures
     * asked.
     * 
     * @param t Treasure to subtract.
     */
    @Override
    public void subtractHiddenTreasure(Treasure t){
        specificVisibleTreasures.remove(t.getType());
    }

    /**
     * Returns a string with the Bad Consequence instance contents.
     * @return String with the contents.
     */
    public String toString(){
        // Read only variable with the number of spaces to print in each line.
        final int num_spaces = 5;
        
        String strSpaces = new String(new char[num_spaces]).replace('\0', ' ');
        String specificVisibleTreasures_str = "", specificHiddenTreasures_str = "";
        
        // Get the specific visible treasures as string
        if (specificVisibleTreasures == null || specificVisibleTreasures.isEmpty()){
            specificVisibleTreasures_str = " Ninguno";
        }
        else{
            for (TreasureKind treasure : specificVisibleTreasures){
                specificVisibleTreasures_str += " " + treasure.name();
            }
            
        }
        
        // Get the specific hidden treasures as string
        if (specificHiddenTreasures == null || specificHiddenTreasures.isEmpty()){
            specificHiddenTreasures_str = " Ninguno";
        }
        else{
            for (TreasureKind treasure : specificHiddenTreasures){
                specificHiddenTreasures_str += " " + treasure.name();
            }
            
        }

        return strSpaces + "Text = " + text 
               + "\n"+ strSpaces + "Levels = " + Integer.toString(levels)
               + "\n"+ strSpaces + "specificVisibleTreasures = " + specificVisibleTreasures_str
               + "\n"+ strSpaces + "specificHiddenTreasures = "  + specificHiddenTreasures_str;
    }
}
