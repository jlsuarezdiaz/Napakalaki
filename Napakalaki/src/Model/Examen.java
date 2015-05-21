////////////////////////////////////////////////////////////////////////////////
// Authors: Juan Luis Suárez Díaz, Andrés Herrera Poyatos
// Universidad de Granada, March, 2015
// Programación Orientada a Objetos - Napakalaki
////////////////////////////////////////////////////////////////////////////////

package Model;

import java.util.ArrayList; // ArrayList included
import java.util.Arrays;

/**
 * Class for the PDOO practice exam.
 * @author andreshp, jlsuarez
 */
public class Examen {

    // Main method
    public static void main(String[] args) {

        //------------------- USUAL PLAYERS -------------------//
 
        Player p1 = new Player("Jugador 1");
        Player p2 = new Player("Jugador 2");
        
        //--------------------- TREASURES ---------------------//

        Treasure tArmor = new Treasure("Armadura", 600, 5, 6, TreasureKind.ARMOR);
        Treasure tBothhands = new Treasure("Dos manos", 600, 4, 8, TreasureKind.BOTHHANDS);
        Treasure tHelmet = new Treasure("Casco", 400, 2, 3, TreasureKind.HELMET);
        Treasure tNecklace = new Treasure("Collar", 1000, 0, 0, TreasureKind.NECKLACE);
        Treasure tOnehand1 = new Treasure("Una mano 1", 400, 3, 6, TreasureKind.ONEHAND);
        Treasure tOnehand2 = new Treasure("Una mano 2", 300, 2, 3, TreasureKind.ONEHAND);
        Treasure tShoe = new Treasure("Botas", 600, 3, 4, TreasureKind.SHOE);

        // Arrays
        ArrayList<Treasure> vTreasures1 = new ArrayList<>();
        ArrayList<Treasure> hTreasures1 = new ArrayList<>();
        ArrayList<Treasure> vTreasures2 = new ArrayList<>(Arrays.asList(tArmor, tBothhands));
        ArrayList<Treasure> hTreasures2 = new ArrayList<>(Arrays.asList(tHelmet, tOnehand2));

        vTreasures1.add(tOnehand1);
        hTreasures1.add(tShoe);

        //----------------- BAD CONSEQUENCES ------------------//

        // Death
        BadConsequence badConsDeath = new BadConsequenceDeath("Bad Consequence 1", true);
        // Number Treasures
        BadConsequence badConsNT = new BadConsequenceNumberTreasures(
            "Bad consequence 2", 3, 1, 1);
        // Specific Treasures
        BadConsequence badConsST = new BadConsequenceSpecificTreasures(
            "Bad consequence 3", 3, new ArrayList(Arrays.asList(TreasureKind.ONEHAND, 
            TreasureKind.BOTHHANDS)), new ArrayList());

        //----------------- MONSTERS ------------------//
        
        // Usual monsters
        Monster m1 = new Monster("Monstruo 1", 11, badConsDeath, new Prize(1,1));
        Monster m2 = new Monster("Monstruo 2", 12, badConsNT, new Prize(2,2));
        Monster m3 = new Monster("Monstruo 3", 13, badConsST, new Prize(3,3));

        // Monsters with level change against cultist
        Monster mc1 = new Monster("Monstruo 1", 11, badConsDeath, new Prize(1,1), 1);
        Monster mc2 = new Monster("Monstruo 2", 12, badConsNT, new Prize(2,2), 2);
        Monster mc3 = new Monster("Monstruo 3", 13, badConsST, new Prize(3,3), 3);

        //------------------- CULTIST CARDS --------------------//
        
        Cultist cult1 = new Cultist("Sectario 1", 2);
        Cultist cult2 = new Cultist("Sectario 2", 2);

        //------------------ CULTIST PLAYERS ------------------//

        Player pAux = new Player("Jugador Sectario 1");
        CultistPlayer psec1 = new CultistPlayer(pAux, cult1);

        pAux = new Player("Jugador Sectario 2");
        CultistPlayer psec2 = new CultistPlayer(pAux, cult2);

        //--------------------- CARD DEALER ----------------------//

        CardDealer dealer = CardDealer.getInstance();
        dealer.initCards();
        
        //--------------------- OPERATIONS -----------------------//

        // Players are printed
        System.out.println("Antes de añadir tesoros:\n");
        System.out.println(p1.toStringXL() + "\n");  
        System.out.println(p2.toStringXL() + "\n");  
        System.out.println(psec1.toStringXL() + "\n");
        System.out.println(psec2.toStringXL() + "\n");

        p1.setVisibleTreasureList(vTreasures1);
        p1.setHiddenTreasureList(hTreasures1);
        psec1.setVisibleTreasureList(vTreasures1);
        psec1.setHiddenTreasureList(hTreasures1);
        p2.setVisibleTreasureList(vTreasures2);
        p2.setHiddenTreasureList(hTreasures2);
        psec2.setVisibleTreasureList(vTreasures2);
        psec2.setHiddenTreasureList(hTreasures2);

        // Players are printed after setting their treasures
        System.out.println("Tras añadir tesoros:\n");
        System.out.println(p1.toStringXL() + "\n");  
        System.out.println(p2.toStringXL() + "\n");  
        System.out.println(psec1.toStringXL() + "\n");
        System.out.println(psec2.toStringXL() + "\n");

        // Print monsters levels
        System.out.println("Niveles de los monstruos para un jugador usual:");
        System.out.println("m1: " + Integer.toString(p1.getOpponentLevel(m1)));
        System.out.println("m2: " + Integer.toString(p1.getOpponentLevel(m2)));
        System.out.println("m3: " + Integer.toString(p1.getOpponentLevel(m3)));
        System.out.println("mc1: " + Integer.toString(p1.getOpponentLevel(mc1)));
        System.out.println("mc2: " + Integer.toString(p1.getOpponentLevel(mc2)));
        System.out.println("mc3: " + Integer.toString(p1.getOpponentLevel(mc3)));
        System.out.println("Niveles de los monstruos para un jugador sectario:");
        System.out.println("m1: " + Integer.toString(psec1.getOpponentLevel(m1)));
        System.out.println("m2: " + Integer.toString(psec1.getOpponentLevel(m2)));
        System.out.println("m3: " + Integer.toString(psec1.getOpponentLevel(m3)));
        System.out.println("mc1: " + Integer.toString(psec1.getOpponentLevel(mc1)));
        System.out.println("mc2: " + Integer.toString(psec1.getOpponentLevel(mc2)));
        System.out.println("mc3: " + Integer.toString(psec1.getOpponentLevel(mc3)));

        // Do an adjustToFit and set it as pending bad consequence
        BadConsequence newBadCons = badConsST.adjustToFitTreasureLists(p1.getVisibleTreasures(), p1.getHiddenTreasures());
        p1.setPendingBadConsequence(newBadCons);
        System.out.println("\nTras asignar un bad consequence pendiente:");
        System.out.println(p1.toStringXL() + "\n");  
        
        // Buy levels for a player
        p1.buyLevels((ArrayList<Treasure>) p1.getVisibleTreasures().clone(), new ArrayList());
        psec1.buyLevels((ArrayList<Treasure>) psec2.getVisibleTreasures().clone(), new ArrayList());

        // Players are printed after buying levels
        System.out.println("Tras comprar niveles:\n");
        System.out.println(p1.toStringXL() + "\n");  
        System.out.println(p2.toStringXL() + "\n");  
        System.out.println(psec1.toStringXL() + "\n");
        System.out.println(psec2.toStringXL() + "\n");
    }
}
