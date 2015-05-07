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
public class BadConsequenceNumberTreasures extends BadConsequence {
    /**
     * Constructor that initializes the attributes text, levels and both treasures array.
     */
    public BadConsequenceNumberTreasures(String text, int levels, int nVisible,
            int nHidden){
        super(text,levels,nVisible,nHidden,null,null,false);
    }    
}
