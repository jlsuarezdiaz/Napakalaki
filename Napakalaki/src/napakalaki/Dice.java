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
 * @author Juan Luis
 */
public class Dice {
    /**
     * Class Instance
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
    
    public int nextNumber(){
       Random rand = new Random();
       return rand.nextInt(6)+1;
    }
}
