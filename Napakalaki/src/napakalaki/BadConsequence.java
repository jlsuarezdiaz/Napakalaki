//////////////////////////////////////////////////////////////////////////////////////
// Authors: Juan Luis Suárez Díaz, Andrés Herrera Poyatos
// Universidad de Granada, March, 2015
// Programación Orientada a Objetos - Napakalaki
//////////////////////////////////////////////////////////////////////////////////////

package napakalaki;

/**
 *
 * @author andreshp
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
}
