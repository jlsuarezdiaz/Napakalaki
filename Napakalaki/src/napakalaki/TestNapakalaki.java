//////////////////////////////////////////////////////////////////////////////////////
// Authors: Juan Luis Suárez Díaz, Andrés Herrera Poyatos
// Universidad de Granada, March, 2015
// Programación Orientada a Objetos - Napakalaki
//////////////////////////////////////////////////////////////////////////////////////

package napakalaki;

import java.util.ArrayList; // ArrayList included
import java.util.Arrays;    // Arrays included

/**
 *
 * @author andreshp
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
        
        //---------------- Added Monster ----------------//

        // Monster: Byakhees de bonanza
        badConsequence = new BadConsequence("Pierdes tu armadura visible y otra oculta", 0, 
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
        prize = new Prize(2,1);
        monsters.add(new Monster("Byakhees de bonanza", 8, badConsequence, prize));
        
        // Monster: El rey de rosa
        badConsequence = new BadConsequence("Pierdes 5 niveles y 3 tesoros visibles", 5, 3, 0);
        prize = new Prize(4,2);
        monsters.add(new Monster("El rey de rosa", 13, badConsequence, prize));
        
        // Monster: Ángeles de la noche ibicenca
        badConsequence = new BadConsequence("Te atrapan para llevarte de fiesta y te dejan caer "
                + "en mitad del vuelo. Descarta 1 mano visible y 1 mano oculta", 0, 
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), 
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
        prize = new Prize(4,1);
        monsters.add(new Monster("Ángeles de la noche ibicenca", 14, badConsequence, prize));
    }
    
}
