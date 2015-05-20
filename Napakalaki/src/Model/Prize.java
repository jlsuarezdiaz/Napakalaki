////////////////////////////////////////////////////////////////////////////////
// Authors: Juan Luis Suárez Díaz, Andrés Herrera Poyatos
// Universidad de Granada, March, 2015
// Programación Orientada a Objetos - Napakalaki
////////////////////////////////////////////////////////////////////////////////

package Model;

/**
 * Prize Class.
 * This class contains the data related to the prizes
 * in Napakalaki game.
 * 
 * @author andreshp, jlsuarez
 */
public class Prize {
   
    //--------------- ATTRIBUTES ---------------//

    /**
     * Amount of treasures bonus.
     */
    private int treasures;
    
    /**
     * Amount of levels bonus.
     */
    private int levels;

    //--------------- CONSTRUCTORS ---------------//

    /**
     * Constructor
     * @param treasures Treasures bonus for the prize.
     * @param levels Levels bonus for the prize.
     */
    public Prize(int treasures, int levels){
        this.treasures = treasures;
        this.levels = levels;
    }

    //--------------- GET METHODS ---------------//

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

    //--------------- TOSTRING METHOD ---------------//
   
    /**
     * Gets a string with the prize's info.
     * @return string with information.
     */
    @Override
    public String toString(){
        return "Treasures = " + Integer.toString(treasures) + ", Levels = " + Integer.toString(levels);
    }
    
}