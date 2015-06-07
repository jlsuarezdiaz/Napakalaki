////////////////////////////////////////////////////////////////////////////////
// Authors: Juan Luis Suárez Díaz, Andrés Herrera Poyatos
// Universidad de Granada, March, 2015
// Programación Orientada a Objetos - Napakalaki
////////////////////////////////////////////////////////////////////////////////

package Model;

/**
 * Cultist card for napakalaki game.
 * @author andreshp, jlsuarez
 */
public class Cultist implements Card {

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

    //--------------------- GETTERS ------------------------//
    public int getBonus(){
        return gainedLevels;
    }
    
    public String getName(){
        return name;
    }
    //--------------- CARD INTERFACE METHODS ---------------//

    /**
     * Override getBasicValue form Card.
     * @return The basic gainedLevels of the cultist card.
     */
    @Override
    public int getBasicValue() {
        return gainedLevels;
    }

    /**
     * Override getSpecialValue form Card.
     * @return The gainedLevels of the cultist card taking into account the
     * cultist players number.
     */
    @Override
    public int getSpecialValue() {
        return getBasicValue() * CultistPlayer.getTotalCultistPlayers();
    }

    /**
     * To String method for a cultist card.
     * @return String with the name and gained levels.
     */
    @Override
    public String toString(){
        return "Nombre: " + name
                + ", Gained Levels: " + Integer.toString(gainedLevels);
    }
}
