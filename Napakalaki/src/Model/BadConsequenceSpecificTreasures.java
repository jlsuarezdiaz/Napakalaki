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

    /**
     * Create a new BadConsequence in order to get the player to be able to carry it out completely.
     * @param visible Visible treasures of the player.
     * @param hidden Hidden treasures of the player
     * @return A new bad consequence reduced according to visible and hidden player treasures.
     */
    @Override
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> visible, ArrayList<Treasure> hidden){
        
        ArrayList<TreasureKind> newSpecVisible = new ArrayList(), newSpecHidden = new ArrayList();
        ArrayList<TreasureKind> mapVis = new ArrayList(), mapHid = new ArrayList();

        // Map the player's tresuvisibleres type to mapVis and mapHid
        for(Treasure t: visible)
            mapVis.add(t.getType());
        for(Treasure t: hidden)
            mapHid.add(t.getType());

        // Sort the tresure specific lists
        specificVisibleTreasures.sort(null);
        specificHiddenTreasures.sort(null);
        
        int freqNew = 0, freqPlay = 0;
        TreasureKind last = null;

        // Adds to newspecvisible the treasures in visible asked by the badCons.
        for(TreasureKind k: specificVisibleTreasures){
            if (k != last){
                last = k;
                freqNew = 0;
                freqPlay = Collections.frequency(mapVis, k);
            }
            if(freqNew < freqPlay){
                newSpecVisible.add(k);
                freqNew++;
            }
        }

        freqNew = freqPlay = 0; last = null;

        // Adds to newspechidden the treasures in hidden asked by the badCons.
        for(TreasureKind k: specificHiddenTreasures){
            if(k != last){
               last = k;
               freqNew = 0;
               freqPlay = Collections.frequency(mapHid, k);
            }

            if(freqNew < freqPlay){
                newSpecHidden.add(k);
                    freqNew++;
            }
        }   
        return new BadConsequenceSpecificTreasures("Queda por cumplir:", 0, newSpecVisible, newSpecHidden);
    }
}