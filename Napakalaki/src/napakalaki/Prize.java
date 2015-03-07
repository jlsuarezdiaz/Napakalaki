//////////////////////////////////////////////////////////////////////////////////////
// Authors: Juan Luis Suárez Díaz, Andrés Herrera Poyatos
// Universidad de Granada, March, 2015
// Programación Orientada a Objetos - Napakalaki
//////////////////////////////////////////////////////////////////////////////////////

package napakalaki;

/**
 * Prize Class.
 * This class contains the data related to the prizes
 * in Napakalaki game.
 * 
 * @author andreshp, jlsuarez
 */
public class Prize {
   
    //--------------- Private Attributes ---------------//

    /**
     * Amount of treasures bonus.
     */
    private int treasures;
    
    /**
     * Amount of levels bonus.
     */
    private int levels;

    //--------------- Constructors ---------------//

    /**
     * Constructor
     * @param treasures Treasures bonus for the prize.
     * @param levels Levels bonus for the prize.
     */
    public Prize(int treasures, int levels){
        this.treasures = treasures;
        this.levels = levels;
    }

    //--------------- Get Methods ---------------//

    /**
     * Get the treasures bonus.
     * @return treasures.
     */
    public int getTreasures(){
        return this.treasures;
    }
    
    /**
     * Get the level bonus.
     * @return levels.
     */
    public int getLevels(){
        return this.levels;
    }

    //--------------- toString Method ---------------//
   
    /**
     * Gets a string with the prize's info.
     * @return string with information.
     */
    public String toString(){
        return "Treasures = " + Integer.toString(treasures) + "Levels = " + Integer.toString(levels);
    }
    
}