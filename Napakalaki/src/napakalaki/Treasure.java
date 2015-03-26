//////////////////////////////////////////////////////////////////////////////////////
// Authors: Juan Luis Suárez Díaz, Andrés Herrera Poyatos
// Universidad de Granada, March, 2015
// Programación Orientada a Objetos - Napakalaki
//////////////////////////////////////////////////////////////////////////////////////
package napakalaki;

/**
 * Treasure Class.
 * This class represents a treasure in Napakalaki game.
 * @author andreshp, jlsuarez
 */
public class Treasure {
    
    //------------- Private attributes ---------------//
    
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
    //--------------- Public methods ---------------//
    
    /**
     * Constructor.
     */
    public Treasure(String name, int gold, int min, int max, TreasureKind kind){
        this.name = name;
        this.goldCoins = gold;
        this.minBonus = min;
        this.maxBonus = max;
        this.type = kind;
    }
    
    public String getName(){
        return this.name;
    }
    
    public int getGoldCoins(){
        return this.goldCoins;
    }
    
    public int getMinBonus(){
        return this.minBonus;
    }
    
    public int getMaxBonus(){
        return this.maxBonus;
    }
    
    public TreasureKind getType(){
        return this.type;
    }
}
