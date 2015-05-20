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

    //--------------- CARD INTERFACE METHODS ---------------//

    @Override
    /**
     * Override getBasicValue form Card.
     * @return The basic gainedLevels of the cultist card.
     */
    public int getBasicValue() {
        return gainedLevels;
    }

    @Override
    /**
     * Override getSpecialValue form Card.
     * @return The gainedLevels of the cultist card taking into account the
     * cultist player number.
     */
    public int getSpecialValue() {
        return getBasicValue()*CultistPlayer.getTotalCultistPlayers();
    }
    
    public String toString(){
        return "Nombre: " + name
                + ", Gained Levels: " + Integer.toString(gainedLevels);
    }
}
