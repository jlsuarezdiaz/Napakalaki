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
public class BadConsequenceDeath extends BadConsequence {
    
    /**
     * Constructor that initializes the attributes text and death.
     */
    public BadConsequenceDeath(String text, boolean death){
        super(text,0,0,0,null,null,death);
    }
    
}
