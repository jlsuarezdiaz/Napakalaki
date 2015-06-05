////////////////////////////////////////////////////////////////////////////////
// Authors: Juan Luis Suárez Díaz, Andrés Herrera Poyatos
// Universidad de Granada, March, 2015
// Programación Orientada a Objetos - Napakalaki
////////////////////////////////////////////////////////////////////////////////

package GUI;

import Model.Player;
import Model.Treasure;
import java.util.ArrayList;
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
    
    //------------------- CONSTRUCTOR -------------------//

    /**
     * Creates new form PlayerView.
     */
    public PlayerView() {
        initComponents();
    }

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
        hiddenTreasuresPanel = new javax.swing.JPanel();
        visibleTreasuresPanel = new javax.swing.JPanel();
        buyLevelsButton = new javax.swing.JButton();
        makeVisibleButton = new javax.swing.JButton();
        discardTreasuresButton = new javax.swing.JButton();

        nameLabel.setText("Player's Name");

        levelLabel.setText("Level");

        combatLevelLabel.setText("Combat Level");

        hiddenTreasuresPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(10, 5, 50)));

        visibleTreasuresPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(10, 5, 50)));

        javax.swing.GroupLayout visibleTreasuresPanelLayout = new javax.swing.GroupLayout(visibleTreasuresPanel);
        visibleTreasuresPanel.setLayout(visibleTreasuresPanelLayout);
        visibleTreasuresPanelLayout.setHorizontalGroup(
            visibleTreasuresPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        visibleTreasuresPanelLayout.setVerticalGroup(
            visibleTreasuresPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        buyLevelsButton.setText("Buy Levels");

        makeVisibleButton.setText("Make Visible");

        discardTreasuresButton.setText("Discard Treasures");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(visibleTreasuresPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(hiddenTreasuresPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(levelLabel)
                            .addComponent(buyLevelsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(makeVisibleButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(discardTreasuresButton)
                                .addGap(0, 2, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(94, 94, 94)
                                .addComponent(combatLevelLabel)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(levelLabel)
                    .addComponent(combatLevelLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buyLevelsButton)
                    .addComponent(makeVisibleButton)
                    .addComponent(discardTreasuresButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(visibleTreasuresPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(hiddenTreasuresPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

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
        nameLabel.setText(playerModel.getName());
        levelLabel.setText("Level: " + Integer.toString(playerModel.getLevel()));
        combatLevelLabel.setText("Combat Level: " + Integer.toString(playerModel.getCombatLevel()));
        
        fillTreasurePanel(visibleTreasuresPanel, playerModel.getVisibleTreasures());
        fillTreasurePanel(hiddenTreasuresPanel, playerModel.getHiddenTreasures());

        // Repaint the view
        repaint();
        revalidate();
    }

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
        // Se fuerza la actualización visual del panel
        aPanel.repaint();
        aPanel.revalidate();
    }

    //----------------------- NOT ADAPTABLE CODE -----------------------//

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buyLevelsButton;
    private javax.swing.JLabel combatLevelLabel;
    private javax.swing.JButton discardTreasuresButton;
    private javax.swing.JPanel hiddenTreasuresPanel;
    private javax.swing.JLabel levelLabel;
    private javax.swing.JButton makeVisibleButton;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JPanel visibleTreasuresPanel;
    // End of variables declaration//GEN-END:variables
}
