////////////////////////////////////////////////////////////////////////////////
// Authors: Juan Luis Suárez Díaz, Andrés Herrera Poyatos
// Universidad de Granada, March, 2015
// Programación Orientada a Objetos - Napakalaki
////////////////////////////////////////////////////////////////////////////////
package Model;

/**
 * Interface with the methods that a card for Napakalaki game must implements.
 * @author andreshp, jlsuarez
 */
public interface Card {
    
    /**
     * Get the basic card value.
     * @return Integer with the value.
     */
    public int getBasicValue();

    /**
     * Get the special card value.
     * @return Integer with the value.
     */
    public int getSpecialValue(); 
}
