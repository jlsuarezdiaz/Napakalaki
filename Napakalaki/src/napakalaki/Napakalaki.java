////////////////////////////////////////////////////////////////////////////////
// Authors: Juan Luis Suárez Díaz, Andrés Herrera Poyatos
// Universidad de Granada, March, 2015
// Programación Orientada a Objetos - Napakalaki
////////////////////////////////////////////////////////////////////////////////

package napakalaki;

/**
 * Napakalaki class
 * Main class of Napakalaki game.
 * @author andreshp, jlsuarez
 */
public class Napakalaki {
   
    /**
     * Instance of Napakalaki.
     * 
     * It is the only valid instance of Napakalaki.
     * It can be obtained with getInstance.
     */
    private static Napakalaki instance = null;

    /** 
     * Napakalaki constructor.
     * 
     * It is private since we are not letting to create more than one
     * instance. To get that instance use the method getInstance.
     */
    private Napakalaki() {
    }

    private void initPlayers(String [] names){
        
    }
    
    private Player nextPlayer(){
        return null;
    }
    
     /**
     * Get the singlenton instance of the class.
     * @return instance
     */
    public static Napakalaki getInstance() {
        if(instance == null) {
            instance = new Napakalaki();
        }
        return instance;
    }   

    public CombatResult combat(){
        return null;        
    }
    
    public void discardVisibleTreasure(Treasure t){
        
    }
    
    public void discardHiddenTreasure(Treasure t){
    
    }
    
    public boolean makeTreasureVisible(Treasure t){
        return false;
    }
    
    public boolean buyLevels(Treasure [] visible, Treasure [] hidden){
        return false;
    }
    
    public void initGame(String [] players){
        
    }
    
    public Player getCurrentPlayer(){
        return null;        
    }
    
    public Monster getCurrentMonster(){
        return null;        
    }
    
    public boolean canMakeTreasureVisible(Treasure t){
        return false;        
    }
    
    public Treasure [] getVisibleTreasures(){
        return null;
    }
    
    public Treasure [] getHiddenTreasures(){
        return null;
    }
    
    public boolean nextTurn(){
        return false;
    }
    
    public boolean nextTurnAllowed(){
        return false;
    }
    
    public boolean endOfGame(CombatResult result){
        return false;
    }
}
