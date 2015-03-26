//////////////////////////////////////////////////////////////////////////////////////
// Authors: Juan Luis Suárez Díaz, Andrés Herrera Poyatos
// Universidad de Granada, March, 2015
// Programación Orientada a Objetos - Napakalaki
//////////////////////////////////////////////////////////////////////////////////////
package napakalaki;

import java.util.Random;

/**
 * Dice class.
 * This class represents a dice structure used in Napakalaki game.
 * @author andreshp, jlsuarez
 */
public class Dice {
    /**
     * Class instance
     */
    private static Dice instance = null;
    
    /**
     * Private constructor
     */
    private Dice(){
        
    }
    
    /**
     * @brief gets a single instance of the class.
     * @return class instance.
     */
    public static Dice getInstance(){
        if(instance == null){
            instance = new Dice();
        }
        return instance;
    }
    
    /**
     * @brief Throws the dice and gets the value.
     * @return Value obtained from the dice (from 1 to 6).
     */
    public int nextNumber(){
       Random rand = new Random();
       return rand.nextInt(6)+1;
    }
}
