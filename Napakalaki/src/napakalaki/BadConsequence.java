//////////////////////////////////////////////////////////////////////////////////////
// Authors: Juan Luis Suárez Díaz, Andrés Herrera Poyatos
// Universidad de Granada, March, 2015
// Programación Orientada a Objetos - Napakalaki
//////////////////////////////////////////////////////////////////////////////////////

package napakalaki;

import java.util.ArrayList; // ArrayList included
import java.lang.*;

/**
 * Bad Consequence Class.
 * It indicates the consequences of losing to the monster.
 * These consequences are lost of levels, treasures and even death.
 * 
 * @author andreshp, jlsuarez
 */
public class BadConsequence {

    //--------------- Private Attributes ---------------//
    
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
    
    
    //--------------- Constructors ---------------//
    
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
    BadConsequence(String text, int levels, ArrayList<TreasureKind> tVisible,
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
    
    //--------------- Get Methods ---------------//

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
    public boolean getDeath(){
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

    //--------------- toString Method ---------------//

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
        if (specificVisibleTreasures == null){
            specificVisibleTreasures_str = " Ninguno";
        }
        else{
            for (TreasureKind treasure : specificVisibleTreasures){
                specificVisibleTreasures_str += " " + treasure.name();
            }
            
        }
        
        // Get the specific hidden treasures as string
        if (specificHiddenTreasures == null){
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
               + "\n"+ strSpaces + "specificVisibleTreasures =" + specificVisibleTreasures_str
               + "\n"+ strSpaces + "specificHiddenTreasures ="  + specificHiddenTreasures_str
               + "\n"+ strSpaces + "Death = " + Boolean.toString(death);
    }
}
