////////////////////////////////////////////////////////////////////////////////
// Authors: Juan Luis Suárez Díaz, Andrés Herrera Poyatos
// Universidad de Granada, March, 2015
// Programación Orientada a Objetos - Napakalaki
////////////////////////////////////////////////////////////////////////////////

package Model;

import java.util.ArrayList; // ArrayList included

/**
 * Bad Consequence Class.
 * It indicates the consequences of losing to the monster.
 * These consequences are lost of levels, treasures and even death.
 * 
 * @author andreshp, jlsuarez
 */
public class BadConsequence {

    //--------------- ATTRIBUTES ---------------//
    
    /**
     * Text that explains what does the bad consequence do.
     */
    private String text;

    /**
     * Levels that are lost with the bad consequence.
     */
    private int levels;

    /**
     * Number of Visible Treasures that are lost. 
     */
    private int nVisibleTreasures;

    /**
     * Number of Hidden Treasures that are lost. 
     */
    private int nHiddenTreasures;

    /**
     * Boolean that indicates if the bad consequence is death.
     */
    private boolean death;    

    /**
     * Array with the visible treasures.
     */
    private ArrayList<TreasureKind> specificVisibleTreasures;

    /**
     * Array with the hidden treasures.
     */
    private ArrayList<TreasureKind> specificHiddenTreasures;
    
    
    //--------------- CONSTRUCTORS ---------------//
    
    /**
     * Constructor that initializes every attribute but the arrays and death.
     */
    public BadConsequence(String text, int levels, int nVisible, int nHidden){
        this.text = text;
        this.levels = levels;
        this.nVisibleTreasures = nVisible;
        this.nHiddenTreasures = nHidden;

        // Initialize values by default
        this.death = false;
        this.specificVisibleTreasures = null;
        this.specificHiddenTreasures = null;
    }

    /**
     * Constructor that initializes the attributes text and death.
     */
    public BadConsequence(String text, boolean death){
        this.text = text;
        this.death = death;
        
        // Initialize values by default
        this.levels = 0;
        this.nHiddenTreasures = 0;
        this.nVisibleTreasures = 0;
        this.specificVisibleTreasures = null;
        this.specificHiddenTreasures = null;
    }

    /**
     * Constructor that initializes the attributes text, levels and both treasures array.
     */
    public BadConsequence(String text, int levels, ArrayList<TreasureKind> tVisible,
            ArrayList<TreasureKind> tHidden){
        this.text = text;
        this.levels = levels;
        this.specificVisibleTreasures = tVisible;
        this.specificHiddenTreasures = tHidden;
        
        // Initialize values by default
        this.death = false;
        this.nHiddenTreasures = 0;
        this.nVisibleTreasures = 0;
    }
    
    //--------------- GET METHODS ---------------//

    /**
     * Get the text attribute.
     * @return text
     */ 
    public String getText(){
        return text;
    }

    /**
     * Get the levels attribute.
     * @return levels
     */
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
     * Get the death attribute.
     * @return death
     */
    public boolean kills(){
        return death;
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

    //--------------- OTHER PUBLIC METHODS ---------------//

    /**
     * Substracts the visible treasure given from the bad consequence.
     * 
     * If the bad consequence just ask for a number of visible treasures then
     * that number is decremented. Else if the bad consequence ask for specific
     * visible treasures, substract t.getType() from the specific treasures
     * asked.
     * 
     * @param t Treasure to substract.
     */
    public void substractVisibleTreasure(Treasure t){
        if (nVisibleTreasures > 0){
            nVisibleTreasures -= 1;
        }
        else{
            for (TreasureKind vt : specificVisibleTreasures){
                if (vt == t.getType()){
                    specificVisibleTreasures.remove(vt);
                }
            }
        }
    }

    /**
     * Substracts the hidden treasure given from the bad consequence.
     * 
     * If the bad consequence just ask for a number of hidden treasures then
     * that number is decremented. Else if the bad consequence ask for specific
     * hidden treasures, substract t.getType() from the specific treasures
     * asked.
     * 
     * @param t Treasure to substract.
     */
    public void substractHiddenTreasure(Treasure t){
        if (nHiddenTreasures > 0){
            nHiddenTreasures -= 1;
        }
        else{
            for (TreasureKind vt : specificHiddenTreasures){
                if (vt == t.getType()){
                    specificHiddenTreasures.remove(vt);
                }
            }
        }
    }

    /**
     * Check if the Bad Consequence is empty.
     * 
     * A BadConsequence is empty if every attribute is initialized to 0, false,
     * null or "" in case of strings.
     * 
     * @return Result of the comparison.
     */
    public boolean isEmpty(){
        return  (text == null || "".equals(text)) && death == false && 
            nVisibleTreasures == 0 && nHiddenTreasures == 0 && 
            specificVisibleTreasures == null && specificHiddenTreasures == null;
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
               + "\n"+ strSpaces + "nVisibleTreasures = " + Integer.toString(nVisibleTreasures)
               + "\n"+ strSpaces + "nHiddenTreasures = " + Integer.toString(nHiddenTreasures)
               + "\n"+ strSpaces + "specificVisibleTreasures = " + specificVisibleTreasures_str
               + "\n"+ strSpaces + "specificHiddenTreasures = "  + specificHiddenTreasures_str
               + "\n"+ strSpaces + "Death = " + Boolean.toString(death);
    }
    
    BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> visible, ArrayList<Treasure> hidden){
        if(this.specificVisibleTreasures == null && this.specificHiddenTreasures == null){
            if(this.nVisibleTreasures > visible.size())
                this.nVisibleTreasures = visible.size();
            if(this.nHiddenTreasures > hidden.size())
                this.nHiddenTreasures = hidden.size();
        }
        else{
            for(TreasureKind k: specificVisibleTreasures){

            }
        }
        return null;
    }
}
