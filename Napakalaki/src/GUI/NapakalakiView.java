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
        combatResultLabel.setVisible(false);
        nextPlayerLabel.setVisible(false);
    }
    
    /**
     * Prepares the view before next turn.
     * Just next turn, discard button and (depending on pending bad consequence) make visible
     * buttons are enabled.
     */
    private void prepareViewBeforeNextTurn(){
        playerView.enableButtons(false,true,true);
        nextTurnButton.setEnabled(true);
        nextPlayerLabel.setVisible(true);
        nextPlayerLabel.setText("Next Player: " + napakalakiModel.nextPlayerName());
        combatButton.setEnabled(false);
        beginCombatButton.setEnabled(false);
        playerView.enableMakeVisibleIfNotPending();
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
        nextPlayerLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Napakalaki");

        playerView.setMinimumSize(new java.awt.Dimension(500, 400));
        playerView.setPreferredSize(new java.awt.Dimension(500, 400));

        jLabel1.setFont(new java.awt.Font("Purisa", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Napakalaki");

        nextTurnButton.setBackground(java.awt.Color.darkGray);
        nextTurnButton.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        nextTurnButton.setForeground(java.awt.Color.white);
        nextTurnButton.setText("Next Turn");
        nextTurnButton.setFocusPainted(false);
        nextTurnButton.setMaximumSize(new java.awt.Dimension(160, 22));
        nextTurnButton.setMinimumSize(new java.awt.Dimension(160, 22));
        nextTurnButton.setPreferredSize(new java.awt.Dimension(160, 22));
        nextTurnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextTurnButtonActionPerformed(evt);
            }
        });

        beginCombatButton.setBackground(java.awt.Color.darkGray);
        beginCombatButton.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        beginCombatButton.setForeground(java.awt.Color.white);
        beginCombatButton.setText("Begin Combat");
        beginCombatButton.setFocusPainted(false);
        beginCombatButton.setMaximumSize(new java.awt.Dimension(160, 22));
        beginCombatButton.setMinimumSize(new java.awt.Dimension(160, 22));
        beginCombatButton.setPreferredSize(new java.awt.Dimension(170, 20));
        beginCombatButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beginCombatButtonActionPerformed(evt);
            }
        });

        combatButton.setBackground(java.awt.Color.darkGray);
        combatButton.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        combatButton.setForeground(java.awt.Color.white);
        combatButton.setText("Combat!");
        combatButton.setFocusPainted(false);
        combatButton.setMaximumSize(new java.awt.Dimension(160, 22));
        combatButton.setMinimumSize(new java.awt.Dimension(160, 22));
        combatButton.setPreferredSize(new java.awt.Dimension(160, 22));
        combatButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combatButtonActionPerformed(evt);
            }
        });

        combatResultLabel.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        combatResultLabel.setText("Combat Result:");

        nextPlayerLabel.setFont(new java.awt.Font("Ubuntu", 2, 14)); // NOI18N
        nextPlayerLabel.setText("Next Player...");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(nextTurnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nextPlayerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(playerView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(beginCombatButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(76, 76, 76)
                                .addComponent(combatButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(monsterView, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(combatResultLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap(50, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nextTurnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(beginCombatButton, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combatButton, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nextPlayerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(monsterView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(combatResultLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 144, Short.MAX_VALUE))
                    .addComponent(playerView, javax.swing.GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
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
        
        // Enable buttons
        if(result != CombatResult.WINANDWINGAME)
            prepareViewBeforeNextTurn();
        
        // Set Visible combatResultLabel
        this.combatResultLabel.setVisible(true);
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
    private javax.swing.JLabel nextPlayerLabel;
    private javax.swing.JButton nextTurnButton;
    private GUI.PlayerView playerView;
    // End of variables declaration//GEN-END:variables
}
