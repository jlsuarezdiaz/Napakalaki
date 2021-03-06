////////////////////////////////////////////////////////////////////////////////
// Authors: Juan Luis Suárez Díaz, Andrés Herrera Poyatos
// Universidad de Granada, March, 2015
// Programación Orientada a Objetos - Napakalaki
////////////////////////////////////////////////////////////////////////////////
package GUI;

import Model.Prize;

/**
 *
 * @author Juan Luis
 */
public class PrizeView extends javax.swing.JPanel {
    /**
     * Prize whose view is going to be built
     */
    private Prize prizeModel;
    
    /**
     * Creates new form PrizeView
     */
    public PrizeView() {
        initComponents();
    }

    //------------------- SET METHODS -------------------//

    public void setPrize(Prize p){
        prizeModel = p;
        treasuresLabel.setText("Treasures: " + Integer.toString(prizeModel.getTreasures()));
        levelsLabel.setText("Levels: " + Integer.toString(prizeModel.getLevels()));
        repaint();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        prizeLabel = new javax.swing.JLabel();
        treasuresLabel = new javax.swing.JLabel();
        levelsLabel = new javax.swing.JLabel();

        prizeLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        prizeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        prizeLabel.setText("Prize");

        treasuresLabel.setText("Treasures: ");

        levelsLabel.setText("Levels:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(levelsLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(treasuresLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(prizeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 9, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(prizeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(treasuresLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(levelsLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel levelsLabel;
    private javax.swing.JLabel prizeLabel;
    private javax.swing.JLabel treasuresLabel;
    // End of variables declaration//GEN-END:variables
}
