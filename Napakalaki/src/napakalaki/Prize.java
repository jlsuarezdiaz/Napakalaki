//////////////////////////////////////////////////////////////////////////////////////
// Authors: Juan Luis Suárez Díaz, Andrés Herrera Poyatos
// Universidad de Granada, March, 2015
// Programación Orientada a Objetos - Napakalaki
//////////////////////////////////////////////////////////////////////////////////////

package napakalaki;

/**
 *
 * @author andreshp
 */
public class Prize {
    //Definición de variables que almacenan el estado de objetos de esta clase
    //[public|protected|private] [static] [final] tipo nomVar [=inicialización];
    //Definición de los métodos que definan la funcionalidad de los objetos
    //Cabecera del método
    //[public|protected|private] [static] [abstract|final] returnType
    //nombreMetodo ([listParametros]) [throws listaExcepciones]
    private int treasures;
    
    private int levels;

    public Prize(int treasures, int levels){
        this.treasures = treasures;
        this.levels = levels;
    }
    
    public int getTreasures(){
        return this.treasures;
    }
    
    public int getLevels(){
        return this.levels;
    }
    
    public String toString(){
        return "Treasures = " + Integer.toString(treasures) + " levels = " + Integer.toString(levels);
    }
    
}