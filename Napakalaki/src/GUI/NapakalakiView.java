////////////////////////////////////////////////////////////////////////////////
// Authors: Juan Luis Suárez Díaz, Andrés Herrera Poyatos
// Universidad de Granada, March, 2015
// Programación Orientada a Objetos - Napakalaki
////////////////////////////////////////////////////////////////////////////////

package GUI;

import Model.CombatResult;
import Model.Napakalaki;
import javax.swing.JOptionPane;

/**
 * Class which represents the view of the Napakalaki game.
 * @author andreshp, jlsuarez
 */
public class NapakalakiView extends javax.swing.JFrame {
    
    //----------------- ATTRIBUTES -----------------//

    Napakalaki napakalakiModel;
    
    //----------------- PRIVATE METHODS ----------------//

    /**
     * Method that disables every buttons and other attributes of the view.
     */
    private void disableAfterEndOfGame(){
        this.nextTurnButton.setEnabled(false);
        this.beginCombatButton.setEnabled(false);
        this.combatButton.setEnabled(false);
        this.playerView.enableButtons(false);
    }

    /**
     * Prepares the view for the next turn.
     * The player and the monster are updated.
     * Just the player is visible. Just the begin combat buttom is enabled.
     */
    private void prepareNextTurnView(){
        playerView.setPlayer(napakalakiModel.getCurrentPlayer());
        monsterView.setMonster(napakalakiModel.getCurrentMonster());
        monsterView.setVisible(false);
        playerView.enableButtons(true);
        nextTurnButton.setEnabled(false);
        combatButton.setEnabled(false);
        beginCombatButton.setEnabled(true);
    }

    //----------------- CONSTRUCTOR -----------------//

    /**
     * Creates new form NapakalakiView
     */
    public NapakalakiView() {
        initComponents();
        
    }

    //----------------- GET & SET METHODS -----------------//

    public void setNapakalaki(Napakalaki n){
        napakalakiModel = n;
        playerView.setNapakalaki(n);
    }
    
    /**
     * Shows the frame to the user.
     */
    public void showView() {
        this.setVisible(true);
        this.prepareNextTurnView();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        playerView = new GUI.PlayerView();
        jLabel1 = new javax.swing.JLabel();
        monsterView = new GUI.MonsterView();
        nextTurnButton = new javax.swing.JButton();
        beginCombatButton = new javax.swing.JButton();
        combatButton = new javax.swing.JButton();
        combatResultLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Purisa", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Napakalaki");

        nextTurnButton.setText("Next Turn");
        nextTurnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextTurnButtonActionPerformed(evt);
            }
        });

        beginCombatButton.setText("Begin Combat Phase");
        beginCombatButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beginCombatButtonActionPerformed(evt);
            }
        });

        combatButton.setText("Combat!");
        combatButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combatButtonActionPerformed(evt);
            }
        });

        combatResultLabel.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        combatResultLabel.setText("Combat Result:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nextTurnButton)
                            .addComponent(playerView, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(beginCombatButton)
                                .addGap(74, 74, 74)
                                .addComponent(combatButton)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(combatResultLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(monsterView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(50, 50, 50))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(beginCombatButton)
                    .addComponent(combatButton)
                    .addComponent(nextTurnButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(monsterView, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69)
                        .addComponent(combatResultLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(playerView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //----------------- EVENTS -----------------------//

    /**
     * Perform the action of meeting a monster.
     * @param evt  Action Performed event.
     */
    private void beginCombatButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beginCombatButtonActionPerformed
        monsterView.setVisible(true);
        playerView.enableButtons(false);
        this.combatButton.setEnabled(true);
        this.beginCombatButton.setEnabled(false);
    }//GEN-LAST:event_beginCombatButtonActionPerformed

    /**
     * Perform the action of battling
     * @param evt Action Performed event
     */
    private void combatButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combatButtonActionPerformed
        //Send message to Model
        CombatResult result = napakalakiModel.combat();
        switch (result) {
            case WINANDWINGAME : 
                this.combatResultLabel.setText("¡¡¡ H A S   G A N A D O   L A   P A R T I D A !!!");
                disableAfterEndOfGame();
                break;
            case WIN :
                this.combatResultLabel.setText("\n\n Ganaste el combate");
                break;
            case LOSE :
                this.combatResultLabel.setText("\n\n Has perdido el combate, te toca cumplir el mal rollo");
                break;
            case LOSEANDESCAPE :
                this.combatResultLabel.setText("\n\n Perdiste el combate pero has logrado escapar");
                break;
            case LOSEANDDIE :
                this.combatResultLabel.setText("\n\n Perdiste el combate y además estás muerto");
                break;
            case LOSEANDCONVERT:
                this.combatResultLabel.setText("\n\n Has perdido el combate y te has convertido en sectario");
                break;        
        }
        
        //Update player
        playerView.setPlayer(napakalakiModel.getCurrentPlayer());
        
        if(result != CombatResult.WINANDWINGAME){
            //Enable buttons
            playerView.enableButtons(false,true,true);
            nextTurnButton.setEnabled(true);
            combatButton.setEnabled(false);
            beginCombatButton.setEnabled(false);
        }
    }//GEN-LAST:event_combatButtonActionPerformed

    /**
     * Performs the action of going into next turn.
     * @param evt 
     */
    private void nextTurnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextTurnButtonActionPerformed
        if(!napakalakiModel.nextTurn()){
            JOptionPane.showMessageDialog(null, "No cumples las condiciones para pasar de turno.\n" +
                    "O bien tienes más de 4 tesoros ocultos,\no bien te queda mal rollo por cumplir. ",
                    "Cannot advance to next turn",JOptionPane.ERROR_MESSAGE);           
        }
        else prepareNextTurnView();
    }//GEN-LAST:event_nextTurnButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton beginCombatButton;
    private javax.swing.JButton combatButton;
    private javax.swing.JLabel combatResultLabel;
    private javax.swing.JLabel jLabel1;
    private GUI.MonsterView monsterView;
    private javax.swing.JButton nextTurnButton;
    private GUI.PlayerView playerView;
    // End of variables declaration//GEN-END:variables
}
