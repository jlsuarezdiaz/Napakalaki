////////////////////////////////////////////////////////////////////////////////
// Authors: Juan Luis Suárez Díaz, Andrés Herrera Poyatos
// Universidad de Granada, March, 2015
// Programación Orientada a Objetos - Napakalaki
////////////////////////////////////////////////////////////////////////////////

package Test;

import Model.BadConsequence;
import Model.CardDealer;
import Model.Monster;
import Model.Treasure;
import Model.Prize;
import Model.TreasureKind;
import Model.Dice;

/**
 * Test Main to try the changes in the program.
 * A CardDealer instance is used, doing some operations with it.
 * 
 * @author andreshp, jlsuarez
 */
public class Test2 {
    /**
     * Main for testing the program.
     * @param args the command line arguments.
     */
    public static void main(String[] args) {

        CardDealer cards = CardDealer.getInstance();
        cards.initCards();
        Monster monster;   
        Treasure treasure;
        BadConsequence badConsequence;
        Prize prize;
        Dice dice = Dice.getInstance();
        
        //----------------- Operations with the deck -----------------//

        // Print monsters with combat level greater than 10
        System.out.println("Monsters with Combat Level greater than 10:\n");
        for (int i = 0; i < 19; i++){
            monster = cards.nextMonster();
            if (monster.getCombatLevel() > 10){
                System.out.println(monster.toString() + "\n");
            }
            cards.giveMonsterBack(monster);
        }
        
        // Print monsters with just losing levels as Bad Consequence
        System.out.println("Monsters with just losing levels as Bad Consequence:\n");
        for (int i = 0; i < 19; i++){
            monster = cards.nextMonster();
            badConsequence = monster.getBadConsequence();
            if (badConsequence.kills() == false && badConsequence.getNVisibleTreasures() == 0 
                    && badConsequence.getNHiddenTreasures() == 0 
                    && badConsequence.getSpecificVisibleTreasures() == null
                    && badConsequence.getSpecificHiddenTreasures() == null){
                System.out.println(monster.toString() + "\n");    
            }
            cards.giveMonsterBack(monster);
        }

        // Print monsters with just losing levels as Bad Consequence
        System.out.println("Monsters with Prize Levels greater than 1:\n");
        for (int i = 0; i < 19; i++){
            monster = cards.nextMonster();
            prize = monster.getPrize();
            if (prize.getLevels() > 1){
                System.out.println(monster.toString() + "\n");    
            }
            cards.giveMonsterBack(monster);
        }

        // Print monsters which make you lose at least ONEHAND as Bad Consequence
        System.out.println("Monsters which make you lose at least ONEHAND as Bad Consequence:\n");
        for (int i = 0; i < 19; i++){
            monster = cards.nextMonster();
            badConsequence = monster.getBadConsequence();
            if (    (badConsequence.getSpecificVisibleTreasures() != null 
                     && badConsequence.getSpecificVisibleTreasures().contains(TreasureKind.ONEHAND))
                 || (badConsequence.getSpecificHiddenTreasures() != null
                     && badConsequence.getSpecificHiddenTreasures().contains(TreasureKind.ONEHAND))) {
                System.out.println(monster.toString() + "\n");    
            }
            cards.giveMonsterBack(monster);
        }
        
        // Print treasures whose bonus does not improve while wearing the necklace
        System.out.println("Treasures whose bonus does not improve while wearing the necklace:\n");
        for(int i = 0; i < 32; i++){
            treasure = cards.nextTreasure();
            if(treasure.getMinBonus() == treasure.getMaxBonus())
                System.out.println(treasure.toString() + "\n");
            cards.giveTreasureBack(treasure);
        }
        
        // Print treasures while 100 or less gold coins:
        System.out.println("Treasures with 100 or less gold coins:\n");
        for(int i = 0; i < 32; i++){
            treasure = cards.nextTreasure();
            if(treasure.getGoldCoins() <= 100)
                System.out.println(treasure.toString() + "\n");
            cards.giveTreasureBack(treasure);
        }
        
        // Print treasures you can wear in the hands:
        System.out.println("Treasures you can wear in the hands:\n");
        for(int i = 0; i < 32; i++){
            treasure = cards.nextTreasure();
            if(treasure.getType() == TreasureKind.ONEHAND || treasure.getType() == TreasureKind.BOTHHANDS)
                System.out.println(treasure.toString() + "\n");
            cards.giveTreasureBack(treasure);
        }
        
        // Print treasures while 100 or less gold coins:
        System.out.println("Treasure whose name starts with 'Necro':\n");
        for(int i = 0; i < 32; i++){
            treasure = cards.nextTreasure();
            if(treasure.getName().startsWith("Necro"))
                System.out.println(treasure.toString() + "\n");
            cards.giveTreasureBack(treasure);
        }
        
        // --- TESTING DICE --- //
        System.out.print("Testing the dice: ");
        for(int i = 0; i < 28; i++)
            System.out.print(Integer.toString(dice.nextNumber()) + " ");
        
        System.out.println("\n");

    }
}
