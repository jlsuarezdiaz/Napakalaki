////////////////////////////////////////////////////////////////////////////////
// Authors: Juan Luis Suárez Díaz, Andrés Herrera Poyatos
// Universidad de Granada, March, 2015
// Programación Orientada a Objetos - Napakalaki
////////////////////////////////////////////////////////////////////////////////

package GUI;

import Model.Napakalaki;
import Model.Player;
import Model.Treasure;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * View for the players in Napakalaki game.
 * @author andreshp, jlsuarez
 */
public class PlayerView extends javax.swing.JPanel {

    //------------------- VARIABLES -------------------//
    
    /**
     * Player that the view represents.
     */
    Player playerModel;
    
    /**
     * Instance of Napakalaki model.
     */
    Napakalaki napakalakiModel;
    
    //------------------- CONSTRUCTOR -------------------//

    /**
     * Creates new form PlayerView.
     */
    public PlayerView() {
        initComponents();
    }

    //------------------- PUBLIC METHODS -------------------//

    /**
     * Set the player which the view represents.
     * Reinitializes the view with the new player info.
     * @param p Player to represent.
     */
    public void setPlayer(Player p) {
        // Set the new model
        playerModel = p;

        // Change the view attributes according to the new treasure. 
        nameLabel.setText("Player: " + playerModel.getName());
        levelLabel.setText("Level: " + Integer.toString(playerModel.getLevel()));
        combatLevelLabel.setText("Combat Level: " + Integer.toString(playerModel.getCombatLevel()));
        
        fillTreasurePanel(visibleTreasuresPanel, playerModel.getVisibleTreasures());
        fillTreasurePanel(hiddenTreasuresPanel, playerModel.getHiddenTreasures());

        // Repaint the view
        repaint();
        revalidate();
    }
    
    /**
     * Update Napakalaki model to the view.
     * @param n Napakalaki instance.
     */
    public void setNapakalaki(Napakalaki n){
        napakalakiModel = n;
    }

    /**
     * Fills the treasure panel with a treasure list.
     * @param aPanel JPanel to fill.
     * @param aList Treasure list which will fill the panel.
     */
    public void fillTreasurePanel(JPanel aPanel, ArrayList<Treasure> aList) {
        // Deletes old information
        aPanel.removeAll();

        // For each treasure in the list add its view to the panel.
        for (Treasure t : aList) {
            TreasureView aTreasureView = new TreasureView();
            aTreasureView.setTreasure (t);
            aTreasureView.setVisible (true);
            aPanel.add(aTreasureView);
        }

        // Update the panel
        aPanel.repaint();
        aPanel.revalidate();
    }

    /**
     * Obtains the treasures which are selected in the panel.
     * @param aPanel Panel with the treasures.
     * @return Selected treasures list.
     */
    public ArrayList<Treasure> getSelectedTreasures(JPanel aPanel) {
        // Se recorren los tesoros que contiene el panel,
        // almacenando en un vector aquellos que están seleccionados.
        // Finalmente se devuelve dicho vector.
        TreasureView tv;
        ArrayList<Treasure> output = new ArrayList();
        for (Component c : aPanel.getComponents()) {
            tv = (TreasureView) c;
            if ( tv.isSelected() )
                output.add ( tv.getTreasure() );
            }
        return output;
    }
    
    /**
     * Set each button in playerView enabled or disabled.
     * @param btBuyLevels state for buyLevelsButton
     * @param btDiscard state for discardTreasuresButton
     * @param btMkVisible state for makeVisibleButton
     */
    public void enableButtons(boolean btBuyLevels, boolean btDiscard, boolean btMkVisible){
        this.buyLevelsButton.setEnabled(btBuyLevels);
        this.discardTreasuresButton.setEnabled(btDiscard);
        this.makeVisibleButton.setEnabled(btMkVisible);
    }
    
    /**
     * Set all buttons in playerView enabled or disabled.
     * @param enabled boolean indicating enabled state.
     */
    public void enableButtons(boolean enabled){
        enableButtons(enabled,enabled,enabled);
    }

    //----------------------- GENERATED CODE -----------------------//

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nameLabel = new javax.swing.JLabel();
        levelLabel = new javax.swing.JLabel();
        combatLevelLabel = new javax.swing.JLabel();
        buyLevelsButton = new javax.swing.JButton();
        makeVisibleButton = new javax.swing.JButton();
        discardTreasuresButton = new javax.swing.JButton();
        visibleTreasuresLabel = new javax.swing.JLabel();
        hiddenTreasuresLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        visibleTreasuresPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        hiddenTreasuresPanel = new javax.swing.JPanel();

        setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));
        setPreferredSize(new java.awt.Dimension(480, 400));

        nameLabel.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        nameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nameLabel.setText("Player's Name");

        levelLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        levelLabel.setText("Level");

        combatLevelLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        combatLevelLabel.setText("Combat Level");

        buyLevelsButton.setBackground(java.awt.Color.darkGray);
        buyLevelsButton.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        buyLevelsButton.setForeground(java.awt.Color.white);
        buyLevelsButton.setText("Buy Levels");
        buyLevelsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buyLevelsButtonActionPerformed(evt);
            }
        });

        makeVisibleButton.setBackground(java.awt.Color.darkGray);
        makeVisibleButton.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        makeVisibleButton.setForeground(java.awt.Color.white);
        makeVisibleButton.setText("Make Visible");
        makeVisibleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                makeVisibleButtonActionPerformed(evt);
            }
        });

        discardTreasuresButton.setBackground(java.awt.Color.darkGray);
        discardTreasuresButton.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        discardTreasuresButton.setForeground(java.awt.Color.white);
        discardTreasuresButton.setText("Discard Treasures");
        discardTreasuresButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discardTreasuresButtonActionPerformed(evt);
            }
        });

        visibleTreasuresLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        visibleTreasuresLabel.setText("Visible Treasures");

        hiddenTreasuresLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hiddenTreasuresLabel.setText("Hidden Treasures");

        visibleTreasuresPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(10, 5, 50)));
        visibleTreasuresPanel.setAutoscrolls(true);
        visibleTreasuresPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(visibleTreasuresPanel);

        hiddenTreasuresPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(10, 5, 50)));
        hiddenTreasuresPanel.setAutoscrolls(true);
        jScrollPane2.setViewportView(hiddenTreasuresPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(visibleTreasuresLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nameLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(hiddenTreasuresLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buyLevelsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(makeVisibleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(discardTreasuresButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(levelLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(combatLevelLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(levelLabel)
                    .addComponent(combatLevelLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buyLevelsButton)
                    .addComponent(makeVisibleButton)
                    .addComponent(discardTreasuresButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(visibleTreasuresLabel)
                .addGap(4, 4, 4)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(hiddenTreasuresLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Performs the action of making treasures visible.
     * @param evt Action Performed event.
     */
    private void makeVisibleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makeVisibleButtonActionPerformed
        //Get GUI info.
        ArrayList<Treasure> selHidden = getSelectedTreasures(hiddenTreasuresPanel);
        //Send message to Model
        for(Treasure t: selHidden){
            if(!napakalakiModel.makeTreasureVisible(t))
                JOptionPane.showMessageDialog(null, "El tesoro " + t.getName() + ", de tipo " + t.getType().toString() + 
                        ", no se puede hacer visible en este momento :S", "Cannot made visible", JOptionPane.WARNING_MESSAGE);
        }
        //Update view
        setPlayer(napakalakiModel.getCurrentPlayer());
    }//GEN-LAST:event_makeVisibleButtonActionPerformed

    /**
     * Performs the action of buying levels.
     * @param evt Action Performed event.
     */
    private void buyLevelsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buyLevelsButtonActionPerformed
        //Get GUI  info.
        ArrayList<Treasure> selVisible = getSelectedTreasures(visibleTreasuresPanel);
        ArrayList<Treasure> selHidden = getSelectedTreasures(hiddenTreasuresPanel);
        //Send message to Model
        if(!napakalakiModel.buyLevels(selVisible, selHidden))
            JOptionPane.showMessageDialog(null, "No se verifican las condiciones para comprar niveles. Compra cancelada.",
                    "Cannot buy levels",JOptionPane.ERROR_MESSAGE);
        //Update view
        setPlayer(napakalakiModel.getCurrentPlayer());
    }//GEN-LAST:event_buyLevelsButtonActionPerformed

    /**
     * Performs the action of discarding treasures.
     * @param evt Action Performed event.
     */
    private void discardTreasuresButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discardTreasuresButtonActionPerformed
        //Get GUI info
        ArrayList<Treasure> selVisible = getSelectedTreasures(visibleTreasuresPanel);
        ArrayList<Treasure> selHidden = getSelectedTreasures(hiddenTreasuresPanel);
        
        //Send message to Model
        for(Treasure t: selVisible)
            napakalakiModel.discardVisibleTreasure(t);
        for(Treasure t: selHidden)
            napakalakiModel.discardHiddenTreasure(t);
        
        //Update view
        setPlayer(napakalakiModel.getCurrentPlayer());
    }//GEN-LAST:event_discardTreasuresButtonActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buyLevelsButton;
    private javax.swing.JLabel combatLevelLabel;
    private javax.swing.JButton discardTreasuresButton;
    private javax.swing.JLabel hiddenTreasuresLabel;
    private javax.swing.JPanel hiddenTreasuresPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel levelLabel;
    private javax.swing.JButton makeVisibleButton;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel visibleTreasuresLabel;
    private javax.swing.JPanel visibleTreasuresPanel;
    // End of variables declaration//GEN-END:variables
}
