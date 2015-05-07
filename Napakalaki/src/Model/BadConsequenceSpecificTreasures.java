////////////////////////////////////////////////////////////////////////////////
// Authors: Juan Luis Suárez Díaz, Andrés Herrera Poyatos
// Universidad de Granada, March, 2015
// Programación Orientada a Objetos - Napakalaki
////////////////////////////////////////////////////////////////////////////////

package Model;

import java.util.ArrayList;

/**
 *
 * @author andreshp
 */
public class BadConsequenceSpecificTreasures extends BadConsequence {
    /**
     * Constructor that initializes the attributes text, levels and both treasures array.
     */
    public BadConsequenceSpecificTreasures(String text, int levels, ArrayList<TreasureKind> tVisible,
            ArrayList<TreasureKind> tHidden){
        super(text,levels,0,0,tVisible,tHidden,false);
    }
    
}
