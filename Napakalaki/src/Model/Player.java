////////////////////////////////////////////////////////////////////////////////
// Authors: Juan Luis Suárez Díaz, Andrés Herrera Poyatos
// Universidad de Granada, March, 2015
// Programación Orientada a Objetos - Napakalaki
////////////////////////////////////////////////////////////////////////////////

package Model;

import java.util.ArrayList;

/**
 * Player Class.
 * This class represents a player in Napakalaki game.
 * @author andreshp, jlsuarez
 */
public class Player {
    
    //------------------ ATTRIBUTES --------------------//
    
    /**
     * Player's name.
     */
    private String name;
    
    /**
     * Player's level.
     */
    private int level;
    
    /**
     * Attribute shows whether the player is dead.
     */
    private boolean dead;
        
    /**
     * Player's visible treasures.
     */
    private ArrayList<Treasure> visibleTreasures;
    
    /**
     * Player's hidden treasures.
     */
    private ArrayList<Treasure> hiddenTreasures;
    
    /**
     * Player's pending Bad Consequence.
     */
    private BadConsequence pendingBadConsequence;
    
    /**
     * Constant value showing maximum number of Hidden Treasure enabled.
     */
    private static final int MAXHIDDENTREASURES = 4;

    //----------------- PRIVATE METHODS ------------------//
    
    /**
     * Brings the player to life.
     */
    private void bringToLife(){
        this.dead = true;
    }
    
    /**
     * Increases player's level.
     * @param levels Amount of levels to increase.
     */
    private void increaseLevels(int levels){
        this.level += levels;
    }
    
    /**
     * Decreases players level.
     * @param levels Amount of levels to decrease.
     */
    private void decreaseLevels(int levels){
        this.level = (this.level - levels >= 1)? this.level - levels: 1;
    }
    
    /**
    * Sets a bad consequence as pending.
    * @param b Bad Consequence to assign as pending.
    */ 
    private void setPendingBadConsequence(BadConsequence b){
        this.pendingBadConsequence = b;
    }
    
    /**
     * The player dies.
     */
    private void die(){
        this.dead = true;
        this.level = 1;
        CardDealer dealer = CardDealer.getInstance();
        
        for(Treasure t: visibleTreasures){
            dealer.giveTreasureBack(t);
        }
        
        for(Treasure t: hiddenTreasures){
            dealer.giveTreasureBack(t);
        }
        
        visibleTreasures.clear();
        hiddenTreasures.clear();
    }
    
    /**
     * Discards the necklace if it is a visible treasure.
     * In that case, it is given back to the card dealer.
     */
    private void discardNecklaceIfVisible(){
        for (int i = 0; i < visibleTreasures.size(); i++){
            if (visibleTreasures.get(i).getType() == TreasureKind.NECKLACE) {
                CardDealer instance = CardDealer.getInstance();
                instance.giveTreasureBack(visibleTreasures.remove(i));
            }
        }
    }
    
    /**
     * Makes the player die if he doesn't have treasures.
     */
    private void dieIfNoTreasures(){
        if(this.visibleTreasures.isEmpty() && this.hiddenTreasures.isEmpty()){
            die();
        }
    }

    /**
     * Determines if the player can buy certain number of levels.
     * A player can buy levels if he doesn't win with those levels.
     * @param levels The number of levels the player wants to buy.
     * @return true, if and only ifm the player can buy the levels asked.
     */
    private boolean canIBuyLevels(int levels){
        return (level + levels) < 10;
    }
    
    //--------------- PROTECTED METHODS ---------------//
    
    /**
     * Gets the total levels that the player can buy with the given treasures list.
     * @param t Array with the treasures.
     * @return Amount of levels the player is able to buy (no rounded).
     */
    protected float computeGoldCoinsValue(ArrayList<Treasure> t){
        float sum = 0;
        for (Treasure p : t){
            sum += p.getGoldCoins();
        }
        return (float)(sum / 1000.0);
    }
    
    //--------------- CONSTRUCTOR ---------------//
    
    /**
     * Constructor by player's name.
     * @param name Player's name.
     */
    public Player(String name){
        this.name = name;
        this.level = 1;
        this.dead = true;
        this.hiddenTreasures = new ArrayList();
        this.visibleTreasures = new ArrayList();
        this.pendingBadConsequence = null;
    }
    
    //-------------- PUBLIC METHODS ---------------//
    
    /**
     * Get player's name.
     * @return player's name.
     */
    public String getName(){
        return name;
    }
    
    /**
     * Applies the prize given as argument.
     * @param p Prize to apply.
     */
    public void applyPrize(Prize p){
        int nLevels = p.getLevels();
        this.increaseLevels(nLevels);
        int nPrize = p.getTreasures();
        CardDealer dealer = CardDealer.getInstance();
        
        for(int i = 0; i < nPrize; i++){
            hiddenTreasures.add(dealer.nextTreasure());
        }
    }
    
    /**
     * The player combats with a monster.
     * @param m Monster to battle.
     * @return Result of the battle.
     */
    public CombatResult combat(Monster m){
        int myLevel = this.getCombatLevel();
        int levelMonster = m.getCombatLevel();
        CombatResult combatResult;
        
        if(myLevel > levelMonster){
            Prize prize = m.getPrize();
            this.applyPrize(prize);
            if(this.level < 10)
                combatResult = CombatResult.WIN;
            else
                combatResult = CombatResult.WINANDWINGAME;
        }
        
        else{
            int escape = Dice.getInstance().nextNumber();
            if(escape < 5){
                BadConsequence bad = m.getBadConsequence();
                boolean amIdead = bad.kills();
                
                if(amIdead){
                    die();
                    combatResult = CombatResult.LOSEANDDIE;
                }
                else{
                    this.applyBadConsequence(bad);
                    combatResult = CombatResult.LOSE;
                }
            }
            else
                combatResult = CombatResult.LOSEANDESCAPE;
        }
        return combatResult;
    }
    
    /**
     * Applies the Bad Consequence given as argument.
     * @param bad Bad Consequence to apply.
     */
    public void applyBadConsequence(BadConsequence bad){
        int nLevels = bad.getLevels();
        this.decreaseLevels(nLevels);
        BadConsequence pendingBad = bad.adjustToFitTreasureLists(visibleTreasures,hiddenTreasures);
        this.setPendingBadConsequence(pendingBad);
    }
    
    /**
     * Makes visible the treasure given as argument.
     * @param t Treasure to make visible.
     * @return true if and only if player could make visible the treasure properly.
     */
    public boolean makeTreasureVisible(Treasure t){
        boolean can = canMakeTreasureVisible(t);
        if(can){
            visibleTreasures.add(t);
            hiddenTreasures.remove(t);
        }
        return can;
    }
    
    /**
     * It checks if the given treasure can be made visible.
     * A treasure can be made visible if the player is not already equiped with
     * a treasure of the same type. If the treasure is ONEHAND, then the player
     * is allow to wear two of those.
     * 
     * @param t Treasure to check.
     * @return Boolean with the checking's result.
     */
    public boolean canMakeTreasureVisible(Treasure t){
        int numOneHand = 0;
        for (Treasure vt : visibleTreasures){
            if (t.getType() == vt.getType()){
                if (t.getType() == TreasureKind.ONEHAND && numOneHand == 0){
                    numOneHand += 1;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * It discards the given treasure if it is visible.
     * @param t Treasure to discard.
     */
    public void discardVisibleTreasure(Treasure t){
        visibleTreasures.remove(t);
        
        if(pendingBadConsequence != null && !pendingBadConsequence.isEmpty()){
            pendingBadConsequence.substractVisibleTreasure(t);
        }
        CardDealer.getInstance().giveTreasureBack(t);
        dieIfNoTreasures();
    }
    
    /**
     * It discards the given treasure if it is hidden.
     * @param t Treasure to discard.
     */
    public void discardHiddenTreasure(Treasure t){
        hiddenTreasures.remove(t);
        
        if(pendingBadConsequence != null && !pendingBadConsequence.isEmpty()){
            pendingBadConsequence.substractHiddenTreasure(t);
        }
        CardDealer.getInstance().giveTreasureBack(t);
        dieIfNoTreasures();
    }
    
    /**
     * Method to buy levels.
     * @param visible Visible Treasures to sell.
     * @param hidden Hidden Treasures to sell.
     * @return --- Boolean ---
     */
    public boolean buyLevels(ArrayList<Treasure> visible, ArrayList<Treasure> hidden){
        float levels = this.computeGoldCoinsValue(visible);
        levels += this.computeGoldCoinsValue(hidden);
        boolean canI = this.canIBuyLevels((int) levels);
        
        if(canI){
            this.increaseLevels((int) levels);
            for(Treasure t : visible){
                this.discardVisibleTreasure(t);
            }
            for(Treasure t: hidden){
                this.discardHiddenTreasure(t);
            }
        }
        return canI;
    }
    
    /**
     * Gets the combat level of the player.
     * @return Combat level.
     */
    public int getCombatLevel(){
        int sum_max = 0;
        int sum_min = 0;
        boolean isNecklace = false;
        
        for(Treasure t : visibleTreasures){
            sum_min += t.getMinBonus();
            sum_max += t.getMinBonus();
            if(t.getType() == TreasureKind.NECKLACE)
                isNecklace = true;
        }
        
        return level + (isNecklace? sum_max : sum_min);
    }
    
    /**
     * It checks the player state.
     * @return true if and only if there are no pending Bad Consequences and player has a correct
     * number of hidden treasures.
     */
    public boolean validState(){
        return (this.pendingBadConsequence == null || this.pendingBadConsequence.isEmpty())
               && this.hiddenTreasures.size() <= Player.MAXHIDDENTREASURES;
    }
    
    /**
     * Inits treasures.
     * @return 
     */
    public void initTreasures(){
        this.bringToLife();
        int number = Dice.getInstance().nextNumber();
        int times = (number == 1)?1:(number == 6)?3:2;
        
        for(int i = 1; i <= times; i++)
            hiddenTreasures.add(CardDealer.getInstance().nextTreasure());
        
    }    
    
    /**
     * It checks if player is dead.
     * @return true if and only if the player is dead.
     */
    public boolean isDead(){
        return this.dead;
    }
    
    /**
     * It checks if the player has visible treasures.
     * @return true if and only of player has visible treasures.
     */
    public boolean hasVisibleTreasures(){
        return !this.visibleTreasures.isEmpty();
    }
    
    /**
     * Gets visible treasures.
     * @return Array with the visible treasures.
     */
    public ArrayList<Treasure> getVisibleTreasures(){
        return this.visibleTreasures;
    }
    
    /**
     * Gets hidden treasures.
     * @return Array with the hidden treasures.
     */
    public ArrayList<Treasure> getHiddenTreasures(){
        return this.hiddenTreasures;
    }
    
    /**
     * Gets a string with player's info.
     * @return Player's info.
     */
    public String toString(){
        return this.name + "\nLevel: " + Integer.toString(level) + 
                " Combat Level: " + Integer.toString(getCombatLevel()) + "\nMal rollo pendiente: " +
                ((pendingBadConsequence==null||pendingBadConsequence.isEmpty())?"OK":this.pendingBadConsequence.toString());
    }
}   
