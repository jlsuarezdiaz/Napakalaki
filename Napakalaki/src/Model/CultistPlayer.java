////////////////////////////////////////////////////////////////////////////////
// Authors: Juan Luis Suárez Díaz, Andrés Herrera Poyatos
// Universidad de Granada, March, 2015
// Programación Orientada a Objetos - Napakalaki
////////////////////////////////////////////////////////////////////////////////

package Model;

/**
 *
 * @author andreshp
 */
public class CultistPlayer extends Player {

    public static int totalCultistPlayer = 0;
    private Cultist myCultistCard;
    
    public CultistPlayer(Player p, Cultist c) {
        myCultistCard = c;
    }
    
    @Override
    public int getOponentLevel(Monster m){  
    }
    @Override
    public boolean shouldConvert(Monster m){  
    }
    
}
