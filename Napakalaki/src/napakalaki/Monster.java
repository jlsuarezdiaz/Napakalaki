//////////////////////////////////////////////////////////////////////////////////////
// Authors: Juan Luis Suárez Díaz, Andrés Herrera Poyatos
// Universidad de Granada, March, 2015
// Programación Orientada a Objetos - Napakalaki
//////////////////////////////////////////////////////////////////////////////////////

package napakalaki;

/**
 *
 * @author Juan Luis
 */
public class Monster {
    private String name;
    
    private int combatLevel;
    
    private Prize prize;
    
    private BadConsequence badCons;
    
    
    public String getName(){
        return this.name;
    }
    
    public int getCombatLevel(){
        return this.combatLevel;
    }
    
    public Monster(String name, int level, BadConsequence bc, Prize prize){
        this.name = name;
        this.combatLevel = level;
        this.prize = prize;
        this.badCons = bc;
    }
    
   public String toString(){
       return "Name = " + this.name + " level = " + Integer.toString(combatLevel) + " prize = [" + prize.toString()
               + "] bad consequence = [" + badCons.toString() + "]";
   }
}
