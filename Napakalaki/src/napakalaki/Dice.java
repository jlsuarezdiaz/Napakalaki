//////////////////////////////////////////////////////////////////////////////////////
// Authors: Juan Luis Suárez Díaz, Andrés Herrera Poyatos
// Universidad de Granada, March, 2015
// Programación Orientada a Objetos - Napakalaki
//////////////////////////////////////////////////////////////////////////////////////
package napakalaki;

/**
 * Dice class.
 * This class represents a dice structure used in Napakalaki game.
 * @author Juan Luis
 */
public class Dice {
    private static Dice instance = null;
    
    public static Dice getInstance(){
        if(instance == null){
            instance = new Dice();
        }
        return instance;
    }
}
