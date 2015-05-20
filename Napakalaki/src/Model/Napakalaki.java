////////////////////////////////////////////////////////////////////////////////
// Authors: Juan Luis Suárez Díaz, Andrés Herrera Poyatos
// Universidad de Granada, March, 2015
// Programación Orientada a Objetos - Napakalaki
////////////////////////////////////////////////////////////////////////////////

package Model;

import java.util.ArrayList;
import java.util.Random;

/**
 * Napakalaki class.
 * Main class for controlling Napakalaki game.
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
    private void initPlayers(ArrayList<String> names){
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

    //--------------- GET METHODS ---------------//

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

    /**
     * Gets current monster in the game.
     * @return Current Monster.
     */
    public Monster getCurrentMonster(){
        return currentMonster;        
    }

    /**
     * Gets current player in the game.
     * @return Current Player.
     */
    public Player getCurrentPlayer(){
        return currentPlayer;        
    }
    
    /**
     * Get Visible Treasures.
     * @return Current player's visible treasures.
     */
    public ArrayList<Treasure> getVisibleTreasures(){
        return currentPlayer.getVisibleTreasures();
    }
    
    /**
     * Get Hidden Treasures.
     * @return Current player's hidden treasures.
     */
    public ArrayList<Treasure> getHiddenTreasures(){
        return currentPlayer.getHiddenTreasures();
    }

    //--------------- OTHER PUBLIC METHODS ---------------//

    /**
     * Buy levels before combat a monster.
     * @param visible Visible treasures used to get levels.
     * @param hidden Hidden treasures used to get levels.
     * @return true if and only if level purchase was effective.
     */
    public boolean buyLevels(ArrayList <Treasure> visible, ArrayList <Treasure> hidden){
        return currentPlayer.buyLevels(visible, hidden);
    }

    /**
     * Checks if current player can make a treasure visible
     * @param t Treasure to make visible.
     * @return True if and only if treasure can be made visible.
     */
    public boolean canMakeTreasureVisible(Treasure t){
        return currentPlayer.canMakeTreasureVisible(t);
    }

    /**
     * Combat with current player against current monster.
     * @return Result of the battle.
     */
    public CombatResult combat(){
        CombatResult combatResult = currentPlayer.combat(currentMonster);
        CardDealer.getInstance().giveMonsterBack(currentMonster);
        
        // If the player was converted to cultist then do it
        if (combatResult == CombatResult.LOSEANDCONVERT){
            Cultist cultistCard = CardDealer.getInstance().nextCultist();
            currentPlayer = new CultistPlayer(currentPlayer, cultistCard);
            players.set(currentPlayerIndex, currentPlayer);
        }

        return combatResult;
    }
    
    /**
     * Erase the given treasures from the player list of visible treasures.
     * @param t Treasures to erase.
     */
    public void discardVisibleTreasure(Treasure t){ 
        currentPlayer.discardVisibleTreasure(t);
    }
    
    /**
     * Erase the given treasures from the player list of hidden treasures.
     * @param t Treasures to erase.
     */
    public void discardHiddenTreasure(Treasure t){
        currentPlayer.discardHiddenTreasure(t);
    }

    /**
     * Checks if the game has finished according to last battle result.
     * @param result Result of the combat.
     * @return Boolean indicating whether the game has finished.
     */
    public boolean endOfGame(CombatResult result){
        return result == CombatResult.WINANDWINGAME;
    }

    /**
     * Initialize  main things needed to play Napakalaki game.
     * @param players Array with players' names.
     */
    public void initGame(ArrayList<String> players){
        CardDealer.getInstance().initCards();
        initPlayers(players);
        nextTurn();
    }

    /**
     * Makes visible a treasure.
     * @param t Treasure to make visible.
     * @return true if and only if current player could make visible the treasure properly.
     */
    public boolean makeTreasureVisible(Treasure t){
        return currentPlayer.makeTreasureVisible(t);    
    }
    
    /**
     * Set next turn in the game, if it is possible.
     * @return true if and only if next turn was set properly.
     */
    public boolean nextTurn(){
        boolean stateOK = nextTurnAllowed();
        
        if(stateOK){
            currentMonster = CardDealer.getInstance().nextMonster();
            nextPlayer();
            
            if(currentPlayer.isDead())
                currentPlayer.initTreasures();        
        }
        return stateOK;
    }
    
    /**
     * Checks if current player in the game can finish his or her turn properly.
     * @return Boolean indicating whether player can leave the turn.
     */
    public boolean nextTurnAllowed(){
        return currentPlayer == null || currentPlayer.validState();
    }
}
