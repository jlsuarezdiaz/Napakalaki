////////////////////////////////////////////////////////////////////////////////
// Authors: Juan Luis Suárez Díaz, Andrés Herrera Poyatos
// Universidad de Granada, March, 2015
// Programación Orientada a Objetos - Napakalaki
////////////////////////////////////////////////////////////////////////////////

package Model;

import java.util.ArrayList; // ArrayList included
import java.util.Collections;

/**
 * Bad Consequence Class.
 * It indicates the consequences of losing to the monster.
 * These consequences are lost of levels, treasures and even death.
 * 
 * @author andreshp, jlsuarez
 */
public abstract class BadConsequence {

    //--------------- ATTRIBUTES ---------------//
    
    /**
     * Text that explains what does the bad consequence do.
     */
    protected String text;

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

    /**
     * Boolean that indicates if the bad consequence is death.
     */
    protected boolean death;

    /**
     * Array with the visible treasures.
     */
    protected ArrayList<TreasureKind> specificVisibleTreasures;

    /**
     * Array with the hidden treasures.
     */
    protected ArrayList<TreasureKind> specificHiddenTreasures;
    
    
    //--------------- CONSTRUCTORS ---------------//
    
    /**
     * Constructor that initializes every attribute but the arrays and death.
     * @param text
     * @param nVisible
     * @param nHidden
     * @param specificVisibleTreasures
     * @param specificHiddenTreasures
     * @param death
     */
    public BadConsequence(String text, int levels, int nVisible, int nHidden, 
            ArrayList<TreasureKind> specificVisibleTreasures, ArrayList<TreasureKind> specificHiddenTreasures,
            boolean death){
        this.text = text;
        this.levels = levels;
        this.nVisibleTreasures = nVisible;
        this.nHiddenTreasures = nHidden;
        this.specificVisibleTreasures = specificVisibleTreasures;
        this.specificHiddenTreasures = specificHiddenTreasures;
        this.death = death;
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
     * Subtracts the visible treasure given from the bad consequence.
     * 
     * If the bad consequence just ask for a number of visible treasures then
     * that number is decremented. Else if the bad consequence ask for specific
     * visible treasures, subtract t.getType() from the specific treasures
     * asked.
     * 
     * @param t Treasure to subtract.
     */
    abstract public void subtractVisibleTreasure(Treasure t);

    /**
     * Subtracts the hidden treasure given from the bad consequence.
     * 
     * If the bad consequence just ask for a number of hidden treasures then
     * that number is decremented. Else if the bad consequence ask for specific
     * hidden treasures, subtract t.getType() from the specific treasures
     * asked.
     * 
     * @param t Treasure to subtract.
     */
    abstract public void subtractHiddenTreasure(Treasure t);

    /**
     * Check if the Bad Consequence is empty.
     * 
     * A BadConsequence is empty if every attribute is initialized to 0, false,
     * null or "" in case of strings.
     * 
     * @return Result of the comparison.
     */
    public boolean isEmpty(){
        return  !death && nVisibleTreasures == 0 && nHiddenTreasures == 0 && 
            (specificVisibleTreasures == null || specificVisibleTreasures.isEmpty()) &&
            (specificHiddenTreasures == null || specificHiddenTreasures.isEmpty());
    }

    /**
     * Returns a string with the Bad Consequence instance contents.
     * @return String with the contents.
     */
    public String toString(){
        return "Esto es un mal rollo con el siguiente contenido:\n";
    }
    
    /**
     * Create a new BadConsequence in order to get the player to be able to carry it out completely.
     * @param visible Visible treasures of the player.
     * @param hidden Hidden treasures of the player
     * @return A new bad consequence reduced according to visible and hidden player treasures.
     */
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> visible, ArrayList<Treasure> hidden){

        BadConsequence newbad = null;
        
        if (this.specificVisibleTreasures == null && this.specificHiddenTreasures == null){
            int newnvisible = Integer.min(this.nVisibleTreasures,visible.size()),
                newnhidden = Integer.min(this.nHiddenTreasures,hidden.size());
            newbad = new BadConsequenceNumberTreasures("Queda por cumplir:", 0, newnvisible, newnhidden);
        }
        else{
            ArrayList<TreasureKind> newspecvisible = new ArrayList(), newspechidden = new ArrayList();
            ArrayList<TreasureKind> mapvis = new ArrayList(), maphid = new ArrayList();
            
            for(Treasure t: visible)
                mapvis.add(t.getType());
                       
            for(Treasure t: hidden)
                maphid.add(t.getType());

            int freq_new = 0, freq_play = 0;
            TreasureKind last = null;
            for(TreasureKind k: specificVisibleTreasures){
                if(k != last){
                   last = k;
                   freq_new = 0;
                   freq_play = Collections.frequency(mapvis, k);
                }
                
                if(freq_new < freq_play){
                    newspecvisible.add(k);
                    freq_new++;
                }
            }

            freq_new = freq_play = 0; last = null;
            for(TreasureKind k: specificHiddenTreasures){
                if(k != last){
                   last = k;
                   freq_new = 0;
                   freq_play = Collections.frequency(maphid, k);
                }
                
                if(freq_new < freq_play){
                    newspechidden.add(k);
                    freq_new++;
                }
            }
            newbad = new BadConsequenceSpecificTreasures("Queda por cumplir:", 0, newspecvisible, newspechidden);
        }
        return newbad;
    }
}
