////////////////////////////////////////////////////////////////////////////////
// Authors: Juan Luis Suárez Díaz, Andrés Herrera Poyatos
// Universidad de Granada, March, 2015
// Programación Orientada a Objetos - Napakalaki
////////////////////////////////////////////////////////////////////////////////

package Test;

import Model.BadConsequence;
import Model.BadConsequenceDeath;
import Model.BadConsequenceNumberTreasures;
import Model.BadConsequenceSpecificTreasures;
import Model.Monster;
import Model.Prize;
import Model.TreasureKind;
import java.util.ArrayList; // ArrayList included
import java.util.Arrays;    // Arrays included

/**
 * Test Main to try the changes in the program.
 * The monsters are created and some operations with them are done.
 * 
 * @author andreshp, jlsuarez
 */
public class Test1 {
    /**
     * Main for testing the program.
     * @param args the command line arguments.
     */
    public static void main(String[] args) {
        ArrayList<Monster> monsters = new ArrayList<>();
        BadConsequence badConsequence;
        Prize prize;
        
        //----------------- Add Monsters -----------------//

        // Monster: 3 Byakhees de bonanza
        badConsequence = new BadConsequenceSpecificTreasures("Pierdes tu"
                + " armadura visible y otra oculta.", 0,
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)));
        prize = new Prize(2,1);
        monsters.add(new Monster("3 Byakhees de bonanza", 8, badConsequence, prize));
        
        // Monster: Chibithulhu
        badConsequence = new BadConsequenceSpecificTreasures("Embobados con el "
                + "lindo primigenio te descartas de tu casco visible.", 0,
                new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList());
        prize = new Prize(1,1);
        monsters.add(new Monster("Chibithulhu", 2, badConsequence, prize));

        // Monster: El sopor de Dunwich
        badConsequence = new BadConsequenceSpecificTreasures("El primordial "
                + "bostezo contagioso. Pierdes el calzado visible.", 0, 
                new ArrayList(Arrays.asList(TreasureKind.SHOE)), new ArrayList());
        prize = new Prize(1,1);
        monsters.add(new Monster("El sopor de Dunwich", 2, badConsequence, prize));
        
        // Monster: Ángeles de la noche ibicenca
        badConsequence = new BadConsequenceSpecificTreasures("Te atrapan para "
                + "llevarte de fiesta y te dejan caer "
                + "en mitad del vuelo. Descarta 1 mano visible y 1 mano oculta.", 
                0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), 
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
        prize = new Prize(4,1);
        monsters.add(new Monster("Ángeles de la noche ibicenca", 14, badConsequence, prize));
        
        // Monster: El gorrón en el umbral
        badConsequence = new BadConsequenceNumberTreasures("Pierdes todos tus "
                + "tesoros visibles.", 0, 100, 0);
        prize = new Prize(3,1);
        monsters.add(new Monster("El gorrón en el umbral", 10, badConsequence, prize));

        // Monster: H.P. Munchcraft
        badConsequence = new BadConsequenceSpecificTreasures("Pierdes la "
                + "armadura visible.", 0, 
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
                new ArrayList());
        prize = new Prize(2,1);
        monsters.add(new Monster("H.P. Munchcraft", 6, badConsequence, prize));
        
        // Monster: Bichgooth
        badConsequence = new BadConsequenceSpecificTreasures("Sientes bichos "
                + "bajo la ropa. Descarta la armadura visible.", 0, 
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
                new ArrayList());
        prize = new Prize(1,1);
        monsters.add(new Monster("Bichgooth", 2, badConsequence, prize));
        
        // Monster: El rey de rosa
        badConsequence = new BadConsequenceNumberTreasures("Pierdes 5 niveles "
                + "y 3 tesoros visibles.", 5, 3, 0);
        prize = new Prize(4,2);
        monsters.add(new Monster("El rey de rosa", 13, badConsequence, prize));
        
        // Monster: La que redacta en las tinieblas
        badConsequence = new BadConsequenceNumberTreasures("Toses los pulmones "
                + "y pierdes 2 niveles.", 2, 0, 0);
        prize = new Prize(1,1);
        monsters.add(new Monster("La que redacta en las tinieblas", 2, badConsequence, prize));

        // Monster: Los hondos
        badConsequence = new BadConsequenceDeath("Estos mostruos resultan "
                + "bastante superficiales y te aburren mortalmente. Estas muerto.", true);
        prize = new Prize(2,1); 
        monsters.add(new Monster("Los hondos", 8, badConsequence, prize));
        
        // Monster: Semillas Cthulhu
        badConsequence = new BadConsequenceNumberTreasures("Pierdes 2 niveles y "
                + "2 tesoros ocultos.", 2, 0, 2);
        prize = new Prize(2,1);
        monsters.add(new Monster("Semillas Cthulhu", 4, badConsequence, prize));

        // Monster: Dameargo
        badConsequence = new BadConsequenceSpecificTreasures("Te intentas escaquear. "
                + "Pierdes una mano visible.", 0,
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),
                new ArrayList());
        prize = new Prize(2,1);
        monsters.add(new Monster("Dameargo", 1, badConsequence, prize));

        // Monster: Pollipólipo volante
        badConsequence = new BadConsequenceNumberTreasures("Da mucho asquito. "
                + "Pierdes 3 niveles.", 3, 0, 0);
        prize = new Prize(1,1);
        monsters.add(new Monster("Pollipólipo volante", 3, badConsequence, prize));

        // Monster: Yskhtihyssg-Goth
        badConsequence = new BadConsequenceDeath("No le hace gracia que "
                + "pronuncien mal su nombre. Estás muerto.", true);
        prize = new Prize(3,1);
        monsters.add(new Monster("Yskhtihyssg-Goth", 12, badConsequence, prize));

        // Monster: Familia feliz
        badConsequence = new BadConsequenceDeath("La familia te atrapa. Estás muerto.", true);
        prize = new Prize(4,1);
        monsters.add(new Monster("Familia feliz", 1, badConsequence, prize));
        
        // Monster: Roboggoth
        badConsequence = new BadConsequenceSpecificTreasures("La quinta directiva "
                + "primaria te obliga a perder 2 niveles "
                + "y un tesoro de 2 manos visible.", 2, 
                new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)),
                new ArrayList());
        prize = new Prize(2,1);
        monsters.add(new Monster("Roboggoth", 8, badConsequence, prize));

        // Monster: El espia
        badConsequence = new BadConsequenceSpecificTreasures("Te asusta en la noche. "
                + "Pierdes un casco visible.", 0,
                new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList());
        prize = new Prize(1,1);
        monsters.add(new Monster("El espia", 5, badConsequence, prize));

        // Monster: El lenguas
        badConsequence = new BadConsequenceNumberTreasures("Menudo susto te llevas. "
                + "Pierdes 2 niveles y 5 tesoros visibles", 2, 5, 0);
        prize = new Prize(1,1);
        monsters.add(new Monster("El lenguas", 20, badConsequence, prize));

        // Monster: Bicéfalo
        badConsequence = new BadConsequenceSpecificTreasures("Te faltan manos "
                + "para tanta cabeza. Pierdes 3 niveles y "
                + "tus tesoros visibles de las manos.", 3, 
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND, 
                        TreasureKind.ONEHAND, TreasureKind.BOTHHANDS)), new ArrayList());
        prize = new Prize(1,1);
        monsters.add(new Monster("Bicéfalo", 20, badConsequence, prize));

        // Cultist Monsters
        
        // Monster: El mal indecible impronunciable
        badConsequence = new BadConsequenceSpecificTreasures("Pierdes 1 mano visible", 0, 
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), new ArrayList());
        prize = new Prize(3,1);
        monsters.add(new Monster ("El mal indecible impronunciable", 10, badConsequence, prize,-2));

        // Monster: Testigos Oculares
        badConsequence = new BadConsequenceNumberTreasures("Pierdes tus tesoros visibles."
                + " Jajaja", 0, 100, 0);
        prize = new Prize(2,1);
        monsters.add(new Monster ("Testigos Oculares", 6, badConsequence, prize, 2));
        
        // Monster: El gran cthulhu
        badConsequence = new BadConsequenceDeath("Hoy no es tu día de suerte. Mueres", true);
        prize = new Prize(2,5);
        monsters.add(new Monster ("El gran cthulhu", 20, badConsequence, prize, 4));

        // Monster: Serpiente Político
        badConsequence = new BadConsequenceNumberTreasures("Tu gobierno te recorta 2 niveles", 2, 0, 0);
        prize = new Prize(2,1);
        monsters.add(new Monster ("Serpiente Político", 8, badConsequence, prize, -2));

        // Monster: Felpuggoth
        badConsequence = new BadConsequenceSpecificTreasures("Pierdes tu casco "
                + "y tu armadura visible. Pierdes tus manos ocultas.", 
                0, new ArrayList(Arrays.asList(TreasureKind.HELMET,TreasureKind.ARMOR)), 
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND,TreasureKind.ONEHAND)));
        prize = new Prize(1,1);
        monsters.add(new Monster ("Felpuggoth", 2, badConsequence, prize, 5));

        // Monster: Shoggoth
        badConsequence = new BadConsequenceNumberTreasures("Pierdes 2 niveles", 2, 0, 0);
        prize = new Prize(4,2);
        monsters.add(new Monster ("Shoggoth", 16, badConsequence, prize, -4));

        // Monster: Lolitagooth
        badConsequence = new BadConsequenceNumberTreasures("Pintalabios negro. "
                + "Pierdes 2 niveles", 2, 0, 0);
        prize = new Prize(1,1);
        monsters.add(new Monster ("Lolitagooth", 2, badConsequence, prize, 3));
    
        //----------------- Operations asked -----------------//

        // Print monsters with combat level greater than 10 
        System.out.println("Monsters with Combat Level greater than 10:\n");
        for (Monster monster : monsters){
            if (monster.getCombatLevel() > 10){
                System.out.println(monster.toString() + "\n");
            }
        }
        
        // Print monsters with just losing levels as Bad Consequence
        System.out.println("Monsters with just losing levels as Bad Consequence:\n");
        for (Monster monster : monsters){
            badConsequence = monster.getBadConsequence();
            if (badConsequence.kills() == false && badConsequence.getNVisibleTreasures() == 0 
                    && badConsequence.getNHiddenTreasures() == 0 
                    && badConsequence.getSpecificVisibleTreasures() == null
                    && badConsequence.getSpecificHiddenTreasures() == null){
                System.out.println(monster.toString() + "\n");    
            }
        }

        // Print monsters with just losing levels as Bad Consequence
        System.out.println("Monsters with Prize Levels greater than 1:\n");
        for (Monster monster : monsters){
            prize = monster.getPrize();
            if (prize.getLevels() > 1){
                System.out.println(monster.toString() + "\n");    
            }
        }

        // Print monsters which make you lose at least ONEHAND as Bad Consequence
        System.out.println("Monsters which make you lose at least ONEHAND as Bad Consequence:\n");
        for (Monster monster : monsters){
            badConsequence = monster.getBadConsequence();
            if (    (badConsequence.getSpecificVisibleTreasures() != null 
                     && badConsequence.getSpecificVisibleTreasures().contains(TreasureKind.ONEHAND))
                 || (badConsequence.getSpecificHiddenTreasures() != null
                     && badConsequence.getSpecificHiddenTreasures().contains(TreasureKind.ONEHAND))) {
                System.out.println(monster.toString() + "\n");    
            }
        }
    }
}
