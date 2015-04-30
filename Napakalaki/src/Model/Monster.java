/////////////////////////////////////////////////////////////////////////////////////
// Authors: Juan Luis Suárez Díaz, Andrés Herrera Poyatos
// Universidad de Granada, March, 2015
// Programación Orientada a Objetos - Napakalaki
//////////////////////////////////////////////////////////////////////////////////////

package Model;

/**
 * Monster Class.
 * This class has all the information related to the monsters
 * in Napakalaki game.
 * 
 * @author andreshp, jlsuarez
 */
public class Monster {
    
    //--------------- ATTRIBUTES ---------------//
    
    /**
     * Monter's name.
     */
    private String name;
    
    /**
     * Monster's level.
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
     * Levels that changes the monster combatLevel if he fights against a
     * cultist player.
     */
    private int levelsChangeAgainstCultistPlayer;
    
    //--------------- CONSTRUCTOR ---------------//
    
    /**
     * Class Constructor for a usual monster.
     * Initializes all the attributes.
     * @param name Monster's name.
     * @param level Monster's level.
     * @param bc Bad consequence.
     * @param prize Prize.
     */
    public Monster(String name, int level, BadConsequence bc, Prize prize){
        this.name = name;
        this.combatLevel = level;
        this.prize = prize;
        this.badCons = bc;
        this.levelsChangeAgainstCultistPlayer = 0;
    }

    /**
     * Class Constructor for a monster whose combat level changes against a
     * cultist player.
     * Initializes all the attributes.
     * @param name Monster's name.
     * @param level Monster's level.
     * @param bc Bad consequence.
     * @param levelsChangeAgainstCultistPlayer Integer with the attribute's value.
     */
    public Monster(String name, int level, BadConsequence bc, Prize prize, int levelsChangeAgainstCultistPlayer){
        this.name = name;
        this.combatLevel = level;
        this.prize = prize;
        this.badCons = bc;
        this.levelsChangeAgainstCultistPlayer = levelsChangeAgainstCultistPlayer;
    }

    //--------------- GET METHODS ---------------//

    /**
     * Get the name attribute.
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
     * Get the Bad Consequence attribute.
     * @return badCons
     */
    public BadConsequence getBadConsequence(){
        return this.badCons;
    }

    /**
     * Get the Prize attribute.
     * @return prize
     */
    public Prize getPrize(){
        return this.prize;
    }

    //--------------- TOSTRING METHOD ---------------//

    /**
     * Gets a string with the monster's info.
     * @return string with information.
     */
    public String toString(){
       return "Name = " + this.name + "\nLevel = " + Integer.toString(combatLevel) 
               + "\nPrize = [" + prize.toString() + "] \nBad Consequence = [\n" + 
               badCons.toString() + "\n]";
   }
}
