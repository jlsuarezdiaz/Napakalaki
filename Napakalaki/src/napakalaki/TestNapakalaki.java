//////////////////////////////////////////////////////////////////////////////////////
// Authors: Juan Luis Suárez Díaz, Andrés Herrera Poyatos
// Universidad de Granada, March, 2015
// Programación Orientada a Objetos - Napakalaki
//////////////////////////////////////////////////////////////////////////////////////

package napakalaki;

import java.util.ArrayList; // ArrayList included
import java.util.Arrays;    // Arrays included

/**
 * Test Main to try the changes in the program.
 * The monsters are created and some operations with them are done.
 * 
 * @author andreshp, jlsuarez
 */
public class TestNapakalaki {
    /**
     * Main for testing the program.
     * @param args the command line arguments.
     */
    public static void main(String[] args) {
        ArrayList<Monster> monsters = new ArrayList();
        BadConsequence badConsequence;
        Prize prize;
        
        //----------------- Add Monsters -----------------//

        // Monster: 3 Byakhees de bonanza
        badConsequence = new BadConsequence("Pierdes tu armadura visible y otra oculta.", 0,
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
        prize = new Prize(2,1);
        monsters.add(new Monster("3 Byakhees de bonanza", 8, badConsequence, prize));
        
        // Monster: Chibithulhu
        badConsequence = new BadConsequence("Embobados con el lindo primigenio te descartas de tu casco visible.", 0,
                new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList());
        prize = new Prize(1,1);
        monsters.add(new Monster("Chibithulhu", 2, badConsequence, prize));

        // Monster: El sopor de Dunwich
        badConsequence = new BadConsequence("El primordial bostezo contagioso. Pierdes el calzado visible.", 0, 
                new ArrayList(Arrays.asList(TreasureKind.SHOE)), new ArrayList());
        prize = new Prize(1,1);
        monsters.add(new Monster("El sopor de Dunwich", 2, badConsequence, prize));
        
        // Monster: Ángeles de la noche ibicenca
        badConsequence = new BadConsequence("Te atrapan para llevarte de fiesta y te dejan caer "
                + "en mitad del vuelo. Descarta 1 mano visible y 1 mano oculta.", 0, 
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), 
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
        prize = new Prize(4,1);
        monsters.add(new Monster("Ángeles de la noche ibicenca", 14, badConsequence, prize));
        
        // Monster: El gorrón en el umbral
        badConsequence = new BadConsequence("Pierdes todos tus tesoros visibles.", 0, 6, 0);
        prize = new Prize(3,1);
        monsters.add(new Monster("El gorrón en el umbral", 10, badConsequence, prize));

        // Monster: H.P. Munchcraft
        badConsequence = new BadConsequence("Pierdes la armadura visible.", 0, 
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
                new ArrayList());
        prize = new Prize(2,1);
        monsters.add(new Monster("H.P. Munchcraft", 6, badConsequence, prize));
        
        // Monster: Bichgooth
        badConsequence = new BadConsequence("Sientes bichos bajo la ropa. Descarta la armadura visible.", 0, 
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
                new ArrayList());
        prize = new Prize(1,1);
        monsters.add(new Monster("Bichgooth", 2, badConsequence, prize));
        
        // Monster: El rey de rosa
        badConsequence = new BadConsequence("Pierdes 5 niveles y 3 tesoros visibles.", 5, 3, 0);
        prize = new Prize(4,2);
        monsters.add(new Monster("El rey de rosa", 13, badConsequence, prize));
        
        // Monster: La que redacta en las tinieblas
        badConsequence = new BadConsequence("Toses los pulmones y pierdes 2 niveles.", 2, 0, 0);
        prize = new Prize(1,1);
        monsters.add(new Monster("La que redacta en las tinieblas", 2, badConsequence, prize));

        // Monster: Los hondos
        badConsequence = new BadConsequence("Estos mostruos resultan bastante superficiales "
                + "y te aburren mortalmente. Estas muerto.", true);
        prize = new Prize(2,1); 
        monsters.add(new Monster("Los hondos", 8, badConsequence, prize));
        
        // Monster: Semillas Cthulhu
        badConsequence = new BadConsequence("Pierdes 2 niveles y 2 tesoros ocultos.", 2, 0, 2);
        prize = new Prize(2,1);
        monsters.add(new Monster("Semillas Cthulhu", 4, badConsequence, prize));

        // Monster: Dameargo
        badConsequence = new BadConsequence("Te intentas escaquear. Pierdes una mano visible.", 0,
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),
                new ArrayList());
        prize = new Prize(2,1);
        monsters.add(new Monster("Dameargo", 1, badConsequence, prize));

        // Monster: Pollipólipo volante
        badConsequence = new BadConsequence("Da mucho asquito. Pierdes 3 niveles.", 3, 0, 0);
        prize = new Prize(1,1);
        monsters.add(new Monster("Pollipólipo volante", 3, badConsequence, prize));

        // Monster: Yskhtihyssg-Goth
        badConsequence = new BadConsequence("No le hace gracia que pronuncien mal su nombre. Estás muerto.", true);
        prize = new Prize(3,1);
        monsters.add(new Monster("Yskhtihyssg-Goth", 12, badConsequence, prize));

        // Monster: Familia feliz
        badConsequence = new BadConsequence("La familia te atrapa. Estás muerto", true);
        prize = new Prize(4,1);
        monsters.add(new Monster("Familia feliz", 1, badConsequence, prize));
        
        // Monster: Roboggoth
        badConsequence = new BadConsequence("La quinta directiva primaria te obliga a perder 2 niveles "
                + "y un tesoro de 2 manos visible.", 2, new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)),
                new ArrayList());
        prize = new Prize(2,1);
        monsters.add(new Monster("Roboggoth", 8, badConsequence, prize));

        // Monster: El espia
        badConsequence = new BadConsequence("Te asusta en la noche. Pierdes un casco visible.", 0,
                new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList());
        prize = new Prize(1,1);
        monsters.add(new Monster("El espia", 5, badConsequence, prize));

        // Monster: El lenguas
        badConsequence = new BadConsequence("Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles", 2, 5, 0);
        prize = new Prize(1,1);
        monsters.add(new Monster("El lenguas", 20, badConsequence, prize));

        // Monster: Bicéfalo
        badConsequence = new BadConsequence("Te faltan manos para tanta cabeza. Pierdes 3 niveles y "
                + "tus tesoros visibles de las manos.", 3, 
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND, TreasureKind.BOTHHANDS)), new ArrayList());
        prize = new Prize(1,1);
        monsters.add(new Monster("Bicéfalo", 20, badConsequence, prize));
    
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
            if (badConsequence.getDeath() == false && badConsequence.getNVisibleTreasures() == 0 
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
            if (badConsequence.getSpecificVisibleTreasures().contains(TreasureKind.ONEHAND)
                    || badConsequence.getSpecificHiddenTreasures().contains(TreasureKind.ONEHAND)){
                System.out.println(monster.toString() + "\n");    
            }
        }
    }
}