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

    //--------------- ATTRIBUTES ---------------//

    /**
     * Levels that are lost with the bad consequence.
     */
    protected int levels;

    /**
     * Array with the visible treasures.
     */
    protected ArrayList<TreasureKind> specificVisibleTreasures;

    /**
     * Array with the hidden treasures.
     */
    protected ArrayList<TreasureKind> specificHiddenTreasures;

    /**
     * Constructor that initializes the attributes text, levels and both treasures array.
     * @param text Bad Consequence text.
     * @param levels Levels that the player loses as bad consequence.
     * @param tVisible Specific visible treasures kind that the player loses.
     * @param tHidden Specific hidden treasures kind that the player loses.
     */
    public BadConsequenceSpecificTreasures(String text, int levels, ArrayList<TreasureKind> tVisible,
            ArrayList<TreasureKind> tHidden){
        this.text = text;
        this.levels = levels;
        this.specificVisibleTreasures = tVisible;
        this.specificHiddenTreasures = tHidden;
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
     * Get the specificVisibleTreasures attribute.
     * @return specificVisibleTreasures
     */
    public ArrayList<TreasureKind> getSpecificVisibleTreasures(){
        return specificVisibleTreasures;
    }

    /**
     * Get the specificHiddenTreasures attribute.
     * @return specificHiddenTreasures
     */
    public ArrayList<TreasureKind> getSpecificHiddenTreasures(){
        return specificHiddenTreasures;
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
        return new BadConsequenceSpecificTreasures("", 0, newSpecVisible, newSpecHidden);
    }

    /**
     * Check if the Bad Consequence is empty.
     * 
     * A BadConsequenceSpecificTreasures is empty levels is 0 and both treasures
     * list are empty or null.
     * 
     * @return Result of the comparison.
     */
    @Override
    public boolean isEmpty(){
        return levels == 0
            && (specificVisibleTreasures == null || specificVisibleTreasures.isEmpty())
            && (specificHiddenTreasures == null || specificHiddenTreasures.isEmpty());
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
     * @param numSpaces Integer with the number of spaces in the paragraph indentation.
     * @return String with the contents.
     */
    @Override
    public String toString(int numSpaces){

        String strSpaces = new String(new char[numSpaces]).replace('\0', ' ');
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
                System.out.println(treasure.name());
            }
            
        }

        return super.toString(numSpaces) 
               + strSpaces + "Text = " + text 
               + "\n"+ strSpaces + "Levels = " + Integer.toString(levels)
               + "\n"+ strSpaces + "specificVisibleTreasures = " + specificVisibleTreasures_str
               + "\n"+ strSpaces + "specificHiddenTreasures = "  + specificHiddenTreasures_str;
    }
}