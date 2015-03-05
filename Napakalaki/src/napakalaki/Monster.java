/////////////////////////////////////////////////////////////////////////////////////
// Authors: Juan Luis Suárez Díaz, Andrés Herrera Poyatos
// Universidad de Granada, March, 2015
// Programación Orientada a Objetos - Napakalaki
//////////////////////////////////////////////////////////////////////////////////////

package napakalaki;

/**
 * Monster Class.
 * This class has all the information related to the monsters
 * in Napakalaki game.
 * 
 * @author andreshp, jlsuarez
 */
public class Monster {
    
    //--------------- Private Attributes ---------------//
    
    /**
     * Monter's name
     */
    private String name;
    
    /**
     * Monster's level
     */
    private int combatLevel;
    
    /**
     * Prize: consequences of defeating monster.
     */
    private Prize prize;
    
    /**
     * Consequences of being defeated.
     */
    private BadConsequence badCons;
    
    /**
     * Get the name attribute
     * @return name
     */
    public String getName(){
        return this.name;
    }
    
    /**
     * Get the level attribute.
     * @return combatLevel
     */
    public int getCombatLevel(){
        return this.combatLevel;
    }
    
    /**
     * Constructor.
     * @param name Monster's name.
     * @param level Monster's level.
     * @param bc Bad consequence.
     * @param prize  Prize.
     */
    public Monster(String name, int level, BadConsequence bc, Prize prize){
        this.name = name;
        this.combatLevel = level;
        this.prize = prize;
        this.badCons = bc;
    }
    
    /**
     * Gets a string with the monster's info.
     * @return string with information.
     */
    public String toString(){
       return "Name = " + this.name + " level = " + Integer.toString(combatLevel) + " prize = [" + prize.toString()
               + "] bad consequence = [" + badCons.toString() + "]";
   }
}
