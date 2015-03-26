//////////////////////////////////////////////////////////////////////////////////////
// Authors: Juan Luis Suárez Díaz, Andrés Herrera Poyatos
// Universidad de Granada, March, 2015
// Programación Orientada a Objetos - Napakalaki
//////////////////////////////////////////////////////////////////////////////////////

package napakalaki;

import java.util.ArrayList; // ArrayList included

/**
 *
 * @author andreshp, jlsuarez
 */
public class CardDealer {

    /**
     * Instance of card dealer.
     * It is the only valid instance of card dealer.
     * It can be obtained with getInstance.
     */
    private static CardDealer instance = null;

    private ArrayList 
    
    /** 
     * Card Dealer constructor.
     * It is private since we are not letting to create more than one
     * instance. To get that instance use the method getInstance.
     */
    private CardDealer() {
    }
    
    private void initTreasureCardDeck(){

    }
    private void initMonsterCardDeck(){

    }
    private void shuffleTreasures(){

    }
    private void shuffleMonsters(){

    }

    /**
     * Get the singlenton instance of the class.
     * @return instance
     */
    public static CardDealer getInstance() {
        if(instance == null) {
            instance = new CardDealer();
        }
        return instance;
    }
    
    public Treasure nextTreasure(){
    }
    
    public Monster nextMonster(){

    }
    
    public void giveTreasureBack(Treasure t){

    }
    
    public void giveMonsterBack(Monster m){
    
    }
    
    public void initCards(){

    }
}
