//////////////////////////////////////////////////////////////////////////////////////
// Authors: Juan Luis Suárez Díaz, Andrés Herrera Poyatos
// Universidad de Granada, March, 2015
// Programación Orientada a Objetos - Napakalaki
//////////////////////////////////////////////////////////////////////////////////////

package napakalaki;

import java.util.ArrayList; // ArrayList included

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
     * Constructor that initializes every attribute but death.
     */
    public BadConsequence(String text, int levels, int nVisible, int nHidden){
        this.text = text;
        this.levels = levels;
        this.nVisibleTreasures = nVisible;
        this.nHiddenTreasures = nHidden;
    }
    /**
     * Constructor that initializes the attributes text and death.
     */
    public BadConsequence(String text, boolean death){
        this.text = text;
        this.death = death;
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
    }
    
    //--------------- Gets Methods ---------------//

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

    //--------------- tpString Method ---------------//

    /**
     * Returns a string with the Bad Consequence instance contents.
     * @return String with the contens.
     */
    public String toString(){
        return "Text = " + text + "\nLevels = " + Integer.toString(levels)
                + "\nnVisibleTreasures = " + Integer.toString(nVisibleTreasures)
                + "\nnHiddenTreasures = " + Integer.toString(nHiddenTreasures)
                + "\nDeath = " + Boolean.toString(death);
    }
}
