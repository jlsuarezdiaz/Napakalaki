////////////////////////////////////////////////////////////////////////////////
// Authors: Juan Luis Suárez Díaz, Andrés Herrera Poyatos
// Universidad de Granada, March, 2015
// Programación Orientada a Objetos - Napakalaki
////////////////////////////////////////////////////////////////////////////////

package Model;

import java.util.ArrayList;   // ArrayList included
import java.util.Arrays;      // Arrays included
import java.util.Collections; // Collections to shuffle ArrayList.

/**
 * CardDealer Class.
 * This class manages everything related to decks of cards in Napakalaki game.
 * It is a singleton class, no more than one instance is allowed.
 *
 * @author andreshp, jlsuarez
 */
public class CardDealer {

    /**
     * Instance of card dealer.
     * 
     * It is the only valid instance of card dealer.
     * It can be obtained with getInstance.
     */
    private static CardDealer instance = null;

    /**
     * List with the used monsters in the game.
     */
    private ArrayList <Monster> usedMonsters;

    /**
     * List with the unused monsters in the game.
     * It can be considered the monsters' deck.
     */
    private ArrayList <Monster> unusedMonsters;

    /**
     * List with the used treasures in the game.
     */
    private ArrayList <Treasure> usedTreasures;

    /**
     * List with the unused treasures in the game.
     * It can be considered the treasures' deck.
     */
    private ArrayList <Treasure> unusedTreasures;

    /** 
     * Card Dealer constructor.
     * 
     * It is private since we are not letting to create more than one
     * instance. To get that instance use the method getInstance.
     */
    private CardDealer() {
    }
    
    /**
     * Initialize the treasures' deck.
     * Every treasure is added to unusedTreasures.
     */
    private void initTreasureCardDeck(){

        //--------------------- ADD THE TREASURES ----------------------//

        // Treasure: ¡Sí mi amo!
        unusedTreasures.add(new Treasure("¡Sí mi amo!",0,4,7,TreasureKind.HELMET));

        // Treasure: Botas de investigación
        unusedTreasures.add(new Treasure("Botas de investigación",600,3,4,TreasureKind.SHOE));

        // Treasure: Capucha de Cthulhu
        unusedTreasures.add(new Treasure("Capucha de Cthulhu",500,3,5,TreasureKind.HELMET));

        // Treasure: A prueba de babas
        unusedTreasures.add(new Treasure("A prueba de babas",400,2,5,TreasureKind.ARMOR));

        // Treasure: Botas de lluvia ácida
        unusedTreasures.add(new Treasure("Botas de lluvia ácida",800,1,1,TreasureKind.BOTHHANDS));

        // Treasure: Casco minero
        unusedTreasures.add(new Treasure("Casco minero",400,2,4,TreasureKind.HELMET));

        // Treasure: Ametralladora Thompson
        unusedTreasures.add(new Treasure("Ametralladora Thompson",600,4,8,TreasureKind.BOTHHANDS));

        // Treasure: Camiseta de la UGR
        unusedTreasures.add(new Treasure("Camiseta de la UGR",100,1,7,TreasureKind.ARMOR));

        // Treasure: Clavo de rail ferroviario
        unusedTreasures.add(new Treasure("Clavo de rail ferroviario",400,3,6,TreasureKind.ONEHAND));

        // Treasure: Cuchillo de Sushi arcano
        unusedTreasures.add(new Treasure("Cuchillo de Sushi arcano",300,2,3,TreasureKind.ONEHAND));

        // Treasure: Fez alópodo
        unusedTreasures.add(new Treasure("Fez alópodo",700,3,5,TreasureKind.HELMET));

        // Treasure: Hacha prehistórica
        unusedTreasures.add(new Treasure("Hacha prehistórica",500,2,5,TreasureKind.ONEHAND));

        // Treasure: El aparato del Pr. Tesla
        unusedTreasures.add(new Treasure("El aparato del Pr. Tesla",900,4,8,TreasureKind.ARMOR));

        // Treasure: Gaita
        unusedTreasures.add(new Treasure("Gaita",500,4,5,TreasureKind.BOTHHANDS));

        // Treasure: Insecticida
        unusedTreasures.add(new Treasure("Insecticida",300,2,3,TreasureKind.ONEHAND));

        // Treasure: Escopeta de 3 cañones
        unusedTreasures.add(new Treasure("Escopeta de 3 cañones",700,4,6,TreasureKind.BOTHHANDS));

        // Treasure: Garabato místico
        unusedTreasures.add(new Treasure("Garabato místico",300,2,2,TreasureKind.ONEHAND));

        // Treasure: La fuerza de Mr. T
        unusedTreasures.add(new Treasure("La fuerza de Mr. T",1000,0,0,TreasureKind.NECKLACE));

        // Treasure: La rebeca metálica
        unusedTreasures.add(new Treasure("La rebeca metálica",400,2,3,TreasureKind.ARMOR));

        // Treasure: Mazo de los antiguos
        unusedTreasures.add(new Treasure("Mazo de los antiguos",200,3,4,TreasureKind.ONEHAND));

        // Treasure: Necroplayboycón
        unusedTreasures.add(new Treasure("Necroplayboycón",300,3,5,TreasureKind.ONEHAND));

        // Treasure: Lanzallamas
        unusedTreasures.add(new Treasure("Lanzallamas",800,4,8,TreasureKind.BOTHHANDS));

        // Treasure: Necrocomicón
        unusedTreasures.add(new Treasure("Necrocomicón",100,1,1,TreasureKind.ONEHAND));

        // Treasure: Necronomicón
        unusedTreasures.add(new Treasure("Necronomicón",800,5,7,TreasureKind.BOTHHANDS));

        // Treasure: Linterna a 2 manos
        unusedTreasures.add(new Treasure("Linterna a 2 manos",400,3,6,TreasureKind.BOTHHANDS));

        // Treasure: Necrognomicón
        unusedTreasures.add(new Treasure("Necrognomicón",200,2,4,TreasureKind.ONEHAND));

        // Treasure: Necrotelecom
        unusedTreasures.add(new Treasure("Necrotelecom",300,2,3,TreasureKind.HELMET));

        // Treasure: Porra preternatural
        unusedTreasures.add(new Treasure("Porra preternatural",200,2,3,TreasureKind.ONEHAND));

        // Treasure: Tentáculo de pega
        unusedTreasures.add(new Treasure("Tentáculo de pega",200,0,1,TreasureKind.HELMET));

        // Treasure: Zapato deja-amigos
        unusedTreasures.add(new Treasure("Zapato deja-amigos",500,0,1,TreasureKind.SHOE));

        // Treasure: Shogulador
        unusedTreasures.add(new Treasure("Shogulador",600,1,1,TreasureKind.BOTHHANDS));

        // Treasure: Varita de atizamiento
        unusedTreasures.add(new Treasure("Varita de atizamiento",400,3,4,TreasureKind.ONEHAND));
    }
    
    /**
     * Initialize the monsters' deck.
     * Every monster is added to unusedMonsters.
     */
    private void initMonsterCardDeck(){

        BadConsequence badConsequence;
        Prize prize;
        
        //------------------------ ADD THE MONSTERS ------------------------//

                // Monster: 3 Byakhees de bonanza
        badConsequence = new BadConsequence("Pierdes tu armadura visible y otra oculta.", 0,
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)));
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("3 Byakhees de bonanza", 8, badConsequence, prize));
        
        // Monster: Chibithulhu
        badConsequence = new BadConsequence("Embobados con el lindo primigenio te descartas de tu casco visible.", 0,
                new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList());
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("Chibithulhu", 2, badConsequence, prize));

        // Monster: El sopor de Dunwich
        badConsequence = new BadConsequence("El primordial bostezo contagioso. Pierdes el calzado visible.", 0, 
                new ArrayList(Arrays.asList(TreasureKind.SHOE)), new ArrayList());
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("El sopor de Dunwich", 2, badConsequence, prize));
        
        // Monster: Ángeles de la noche ibicenca
        badConsequence = new BadConsequence("Te atrapan para llevarte de fiesta y te dejan caer "
                + "en mitad del vuelo. Descarta 1 mano visible y 1 mano oculta.", 0, 
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), 
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
        prize = new Prize(4,1);
        unusedMonsters.add(new Monster("Ángeles de la noche ibicenca", 14, badConsequence, prize));
        
        // Monster: El gorrón en el umbral
        badConsequence = new BadConsequence("Pierdes todos tus tesoros visibles.", 0, 100, 0);
        prize = new Prize(3,1);
        unusedMonsters.add(new Monster("El gorrón en el umbral", 10, badConsequence, prize));

        // Monster: H.P. Munchcraft
        badConsequence = new BadConsequence("Pierdes la armadura visible.", 0, 
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
                new ArrayList());
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("H.P. Munchcraft", 6, badConsequence, prize));
        
        // Monster: Bichgooth
        badConsequence = new BadConsequence("Sientes bichos bajo la ropa. Descarta la armadura visible.", 0, 
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
                new ArrayList());
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("Bichgooth", 2, badConsequence, prize));
        
        // Monster: El rey de rosa
        badConsequence = new BadConsequence("Pierdes 5 niveles y 3 tesoros visibles.", 5, 3, 0);
        prize = new Prize(4,2);
        unusedMonsters.add(new Monster("El rey de rosa", 13, badConsequence, prize));
        
        // Monster: La que redacta en las tinieblas
        badConsequence = new BadConsequence("Toses los pulmones y pierdes 2 niveles.", 2, 0, 0);
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("La que redacta en las tinieblas", 2, badConsequence, prize));

        // Monster: Los hondos
        badConsequence = new BadConsequence("Estos mostruos resultan bastante superficiales "
                + "y te aburren mortalmente. Estas muerto.", true);
        prize = new Prize(2,1); 
        unusedMonsters.add(new Monster("Los hondos", 8, badConsequence, prize));
        
        // Monster: Semillas Cthulhu
        badConsequence = new BadConsequence("Pierdes 2 niveles y 2 tesoros ocultos.", 2, 0, 2);
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("Semillas Cthulhu", 4, badConsequence, prize));

        // Monster: Dameargo
        badConsequence = new BadConsequence("Te intentas escaquear. Pierdes una mano visible.", 0,
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),
                new ArrayList());
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("Dameargo", 1, badConsequence, prize));

        // Monster: Pollipólipo volante
        badConsequence = new BadConsequence("Da mucho asquito. Pierdes 3 niveles.", 3, 0, 0);
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("Pollipólipo volante", 3, badConsequence, prize));

        // Monster: Yskhtihyssg-Goth
        badConsequence = new BadConsequence("No le hace gracia que pronuncien mal su nombre. Estás muerto.", true);
        prize = new Prize(3,1);
        unusedMonsters.add(new Monster("Yskhtihyssg-Goth", 12, badConsequence, prize));

        // Monster: Familia feliz
        badConsequence = new BadConsequence("La familia te atrapa. Estás muerto.", true);
        prize = new Prize(4,1);
        unusedMonsters.add(new Monster("Familia feliz", 1, badConsequence, prize));
        
        // Monster: Roboggoth
        badConsequence = new BadConsequence("La quinta directiva primaria te obliga a perder 2 niveles "
                + "y un tesoro de 2 manos visible.", 2, new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)),
                new ArrayList());
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("Roboggoth", 8, badConsequence, prize));

        // Monster: El espia
        badConsequence = new BadConsequence("Te asusta en la noche. Pierdes un casco visible.", 0,
                new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList());
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("El espia", 5, badConsequence, prize));

        // Monster: El lenguas
        badConsequence = new BadConsequence("Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles", 2, 5, 0);
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("El lenguas", 20, badConsequence, prize));

        // Monster: Bicéfalo
        badConsequence = new BadConsequence("Te faltan manos para tanta cabeza. Pierdes 3 niveles y "
                + "tus tesoros visibles de las manos.", 3, 
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND, TreasureKind.BOTHHANDS)), new ArrayList());
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("Bicéfalo", 20, badConsequence, prize));
    }
    
    /**
     * Shuffles all the treasures.
     * Internally, it shuffles unusedTreasures.
     */
    private void shuffleTreasures(){
        Collections.shuffle(unusedTreasures);
    }

    /**
     * Shuffles all the monsters.
     * Internally, it shuffles unusedMonsters.
     */
    private void shuffleMonsters(){
        Collections.shuffle(unusedMonsters);
    }

    /**
     * Get the singlenton instance of the class.
     * @return instance
     */
    public static CardDealer getInstance() {
        if(instance == null) {
            instance = new CardDealer();
        }
        return instance;
    }
    
    /**
     * Get the following treasure in the treasures' deck.
     * If the deck is empty then usedTreasures is assigned to the treasures'
     * deck and passes to be empty. The treasures' deck is shuffled afterwards.
     * @return The treasure at the top of the deck.
     */
    public Treasure nextTreasure(){
        if (unusedTreasures.isEmpty()){
            unusedTreasures = usedTreasures;
            usedTreasures = new ArrayList();
            shuffleTreasures();
        }
        return unusedTreasures.remove(unusedTreasures.size() -1);
    }
    
    /**
     * Get the following monster in the monsters' deck.
     * If the deck is empty then usedMonsters is assigned to the monsters'
     * deck and passes to be empty. The monsters' deck is shuffled afterwards.
     * @return The monster at the top of the deck.
     */
    public Monster nextMonster(){
        if (unusedMonsters.isEmpty()){
            unusedMonsters = usedMonsters;
            usedMonsters = new ArrayList();
            shuffleTreasures();
        }
        return unusedMonsters.remove(unusedMonsters.size() -1);
    }
    
    /**
     * Adds a treasure to the used treasures' deck.
     * @param t Treasure that has been used. Precondition: The treasure is 
     * supposed not to be in the unused treasures' deck.
     */
    public void giveTreasureBack(Treasure t){
        usedTreasures.add(t);
    }
    
    /**
     * Adds a monster to the used monsters' deck.
     * @param m Monster that has been used. Precondition: The monster is 
     * supposed not to be in the unused monsters' deck.
     */
    public void giveMonsterBack(Monster m){
        usedMonsters.add(m);    
    }
    
    /**
     * Initializes both treasures and monsters decks and shuffles them.
     * 
     * Calls the private methods initTreasureCardDeck and initMonsterCardDeck
     * to initialize both decks and the respective shuffle methods.
     */
    public void initCards(){
        initTreasureCardDeck();
        shuffleTreasures();
        initMonsterCardDeck();
        shuffleMonsters();
    }
}