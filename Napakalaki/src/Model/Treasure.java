////////////////////////////////////////////////////////////////////////////////
// Authors: Juan Luis Suárez Díaz, Andrés Herrera Poyatos
// Universidad de Granada, March, 2015
// Programación Orientada a Objetos - Napakalaki
////////////////////////////////////////////////////////////////////////////////
package Model;

/**
 * Treasure Class.
 * This class represents a treasure in Napakalaki game.
 * @author andreshp, jlsuarez
 */
public class Treasure implements Card {
    
    //------------- ATTRIBUTES ---------------//
    
    /**
     * Text with treasure's name.
     */
    private String name;
    
    /**
     * Amount of gold coins of the treasure.
     */
    private int goldCoins;
    
    /**
     *  Minimum bonus of the treasure.
     */
    private int minBonus;
    
    /**
     * Maximum bonus of the treasure.
     */
    private int maxBonus;
    
    /**
     * Kind of treasure.
     */
    private TreasureKind type;
    
    
    //--------------- CONSTRUCTORS ---------------//
    
    /**
     * Class Constructor.
     * Initializes name, goldCoins, minBonus, maxBonus and type to the values
     * given as parameters.
     * @param name Treasure's name.
     * @param goldCoins Treasure's value in gold coins.
     * @param minBonus Treasure's bonus in case the player isn't equiped with a necklace.
     * @param maxBonus Treasure's bonus in case the player is equiped with a necklace.
     * @param type Treasure's type. 
     */
    public Treasure(String name, int goldCoins, int minBonus, int maxBonus, TreasureKind type){
        this.name = name;
        this.goldCoins = goldCoins;
        this.minBonus = minBonus;
        this.maxBonus = maxBonus;
        this.type = type;
    }
    
    //--------------- GETS METHODS ---------------//
    
    /**
     * Gets the treasure's name.
     * @return name
     */
    public String getName(){
        return this.name;
    }
    
    /**
     * Gets the treasure's value in gold coins.
     * @return goldCoins
     */
    public int getGoldCoins(){
        return this.goldCoins;
    }
    
    /**
     * Gets the treasure's minimum bonus.
     * It is applied if the player isn't equiped with a necklace.
     * @return minBonus
     */
    public int getMinBonus(){
        return this.minBonus;
    }
    
    /**
     * Gets the treasure's maximum bonus.
     * It is applied if the player is equiped with a necklace.
     * @return maxBonus
     */
    public int getMaxBonus(){
        return this.maxBonus;
    }
    
    /**
     * Gets the treasure's type.
     * It can be a HELMET, NECKLACE, BOTHHANDS, ONEHAND, ARMOR, SHOE
     * @return type
     */
    public TreasureKind getType(){
        return this.type;
    }
    
    public String toString(){
        return "Name = " + this.name + "\nGold Coins = " + this.goldCoins + "\nMinimum Bonus = "
               + this.minBonus + "\nMaximum Bonus = " + this.maxBonus + "\nKind of the trasure = "
               + this.type.name();
    }

    //--------------- CARD INTERFACE METHODS ---------------//

    @Override
    /**
     * Override getBasicValue form Card.
     * @return Treasure's minimum bonus.
     */
    public int getBasicValue() {
        return getMinBonus();
    }

    @Override
    /**
     * Override getSpecialValue form Card.
     * @return Treasure's maximum bonus.
     */
    public int getSpecialValue() {
        return getMaxBonus();
    }
}
