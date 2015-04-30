////////////////////////////////////////////////////////////////////////////////
// Authors: Juan Luis Suárez Díaz, Andrés Herrera Poyatos
// Universidad de Granada, March, 2015
// Programación Orientada a Objetos - Napakalaki
////////////////////////////////////////////////////////////////////////////////

package Model;

/**
 * Cultist card for napakalaki game.
 * @author andreshp
 */
public class Cultist implements Card{
    
    /**
     * Cultist's name.
     */
    private String name;
    
    /**
     * Levels added to the cultist player.
     */
    private int gainedLevels;
    
    /**
     * Constructor for the cultist class.
     * Initializes name and gainedLevels.
     * @param name Name for the cultist.
     * @param gainedLevels Attribute gainedLevels value.
     */
    public Cultist(String name, int gainedLevels){
        this.name = name;
        this.gainedLevels = gainedLevels;
    }    

    @Override
    public int getBasicValue() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getSpecialValue() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}