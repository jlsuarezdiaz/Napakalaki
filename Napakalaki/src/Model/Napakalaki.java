////////////////////////////////////////////////////////////////////////////////
// Authors: Juan Luis Suárez Díaz, Andrés Herrera Poyatos
// Universidad de Granada, March, 2015
// Programación Orientada a Objetos - Napakalaki
////////////////////////////////////////////////////////////////////////////////

package Model;

import java.util.ArrayList;
import java.util.Random;

/**
 * Napakalaki class
 * Main class of Napakalaki game.
 * @author andreshp, jlsuarez
 */
public class Napakalaki {
   
    //----------------------- ATTRIBUTES -----------------------//

    /**
     * Instance of Napakalaki.
     * 
     * It is the only valid instance of Napakalaki.
     * It can be obtained with getInstance.
     */
    private static Napakalaki instance = null;

    /**
     * Current player in the game.
     */
    private Player currentPlayer;
    
    /**
     * Current player index in the game.
     */
    private int currentPlayerIndex;
    
    /**
     * List with the players in the game.
     */
    private ArrayList<Player> players;
    
    /**
     * Current monster in the game.
     */
    private Monster currentMonster;

    //----------------------- PRIVATE METHODS -----------------------//

    /** 
     * Napakalaki constructor.
     * 
     * It is private since we are not letting to create more than one
     * instance. To get that instance use the method getInstance.
     */
    private Napakalaki() {
        currentPlayer = null;
        currentPlayerIndex = 0;
        players = new ArrayList<>();
        currentMonster = null;
    }

    /**
     * Initialize players for the game.
     * @param names array with players' names.
     */
    private void initPlayers(String [] names){
        for(String name: names){
            players.add(new Player(name));
        }
    }
    
    /**
     * Method that changes the current player in the game.
     * @return New current player.
     */
    private Player nextPlayer(){
        Random rand = new Random();
        if(currentPlayer == null){
            currentPlayerIndex = rand.nextInt(players.size());
        }
        else{
            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        }
        currentPlayer = players.get(currentPlayerIndex);
        return currentPlayer;
        
    }

    //----------------------- PUBLIC METHODS -----------------------//

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
        return currentPlayer;        
    }
    public Monster getCurrentMonster(){
        return currentMonster;        
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
    
    /**
     * Checks if current player in the game can finish his or her turn properly.
     * @return Boolean indicating whether player can leave the turn.
     */
    public boolean nextTurnAllowed(){
        return currentPlayer.validState();
    }
    
    /**
     * Checks if the game has finished according to last battle result.
     * @param result Result of the combat.
     * @return Boolean indicating whether the game has finished.
     */
    public boolean endOfGame(CombatResult result){
        return result == CombatResult.WINANDWINGAME;
    }
}
