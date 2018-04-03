package automat;

import java.awt.Color;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author chris
 */
public class Indkøbskurv_Ba_Jpanel extends javax.swing.JPanel {

    private static Billetautomatv2 ba;
    private int type_billet;

    void setLogik(Billetautomatv2 automat) {
        ba = automat;
        jRadioButton_Voksenbillet.setText("Voksen - "+ba.getBilletpris(0)+" kr.");
        jRadioButton_Ungdomsbillet.setText("Ungdom - "+ba.getBilletpris(1)+" kr.");
        jRadioButton_Børnebillet.setText("Børne - "+ba.getBilletpris(2)+" kr.");
        jRadioButton_Studenterbillet.setText("Studenter - "+ba.getBilletpris(3)+" kr.");
        jRadioButton_Cykelbillet.setText("Cykel - "+ba.getBilletpris(4)+" kr.");
        jTextField_Totalbeløb.setText("0.0 kr.");
        
        // Renser listen med billetter
        jList_af_Billetter.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = {};
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jSpinner1.setValue(2);
        
        jTextField_Balancen.setText(""+ba.getBalance()+" kr."); // Opdatere balancen
    }

    /**
     * Creates new form Indkøbskurv_Ba_Jpanel
     */
    public Indkøbskurv_Ba_Jpanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jRadioButton_Børnebillet = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jRadioButton_Voksenbillet = new javax.swing.JRadioButton();
        jRadioButton_Studenterbillet = new javax.swing.JRadioButton();
        jButton_Tilføj_Indkøbskurv = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList_af_Billetter = new javax.swing.JList<>();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jRadioButton_Cykelbillet = new javax.swing.JRadioButton();
        jRadioButton_Ungdomsbillet = new javax.swing.JRadioButton();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField_Totalbeløb = new javax.swing.JTextField();
        jButton_fjern_Valgte = new javax.swing.JButton();
        jButton_Køb_indkøbskurv = new javax.swing.JButton();
        jTextField_Balancen = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList1);

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
        });

        buttonGroup1.add(jRadioButton_Børnebillet);
        jRadioButton_Børnebillet.setText("Børne - ");
        jRadioButton_Børnebillet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_BørnebilletActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Indkøbskurv");

        jLabel2.setText("Vælg hvilken billet du vil købe og tryk \"Tilføj\" for,");

        jLabel3.setText("at tilføje den til din indkøbskurv.");

        buttonGroup1.add(jRadioButton_Voksenbillet);
        jRadioButton_Voksenbillet.setSelected(true);
        jRadioButton_Voksenbillet.setText("Voksen - ");
        jRadioButton_Voksenbillet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_VoksenbilletActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton_Studenterbillet);
        jRadioButton_Studenterbillet.setText("Studenter -");
        jRadioButton_Studenterbillet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_StudenterbilletActionPerformed(evt);
            }
        });

        jButton_Tilføj_Indkøbskurv.setText("Tilføj");
        jButton_Tilføj_Indkøbskurv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Tilføj_IndkøbskurvActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(jList_af_Billetter);

        jLabel5.setText("Billetter");

        buttonGroup1.add(jRadioButton_Cykelbillet);
        jRadioButton_Cykelbillet.setText("Cykel -");
        jRadioButton_Cykelbillet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_CykelbilletActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton_Ungdomsbillet);
        jRadioButton_Ungdomsbillet.setText("Ungdom  - ");
        jRadioButton_Ungdomsbillet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_UngdomsbilletActionPerformed(evt);
            }
        });

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(2, 2, 8, 1));
        jSpinner1.setValue(2);
        jSpinner1.setVerifyInputWhenFocusTarget(false);

        jLabel4.setText("Antal Zoner:");

        jLabel6.setText("(2-8 zoner)");

        jLabel7.setText("I alt:");

        jTextField_Totalbeløb.setText("0 kr.");
        jTextField_Totalbeløb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_TotalbeløbActionPerformed(evt);
            }
        });

        jButton_fjern_Valgte.setText("Fjern valgte billet");
        jButton_fjern_Valgte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_fjern_ValgteActionPerformed(evt);
            }
        });

        jButton_Køb_indkøbskurv.setForeground(new java.awt.Color(250, 0, 0));
        jButton_Køb_indkøbskurv.setText("Køb indholdet af indkøbskurven");
        jButton_Køb_indkøbskurv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton_Køb_indkøbskurvMouseEntered(evt);
            }
        });
        jButton_Køb_indkøbskurv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Køb_indkøbskurvActionPerformed(evt);
            }
        });

        jTextField_Balancen.setText("0");
        jTextField_Balancen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_BalancenActionPerformed(evt);
            }
        });

        jLabel8.setText("Balance: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                        .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addGap(118, 118, 118)
                        .addComponent(jButton_Tilføj_Indkøbskurv)
                        .addGap(76, 76, 76))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButton_Ungdomsbillet)
                                    .addComponent(jRadioButton_Voksenbillet))
                                .addGap(54, 54, 54)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButton_Børnebillet)
                                    .addComponent(jRadioButton_Studenterbillet))
                                .addGap(43, 43, 43)
                                .addComponent(jRadioButton_Cykelbillet))
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_fjern_Valgte)
                        .addGap(35, 35, 35))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField_Totalbeløb, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                            .addComponent(jTextField_Balancen))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton_Køb_indkøbskurv)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton_Voksenbillet)
                    .addComponent(jRadioButton_Cykelbillet)
                    .addComponent(jRadioButton_Børnebillet))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton_Ungdomsbillet)
                    .addComponent(jRadioButton_Studenterbillet))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jButton_Tilføj_Indkøbskurv)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jButton_fjern_Valgte)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton_Køb_indkøbskurv)
                        .addGap(28, 28, 28))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jTextField_Totalbeløb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_Balancen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(17, 17, 17))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton_BørnebilletActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_BørnebilletActionPerformed
        // TODO add your handling code here:
        type_billet = 2;
    }//GEN-LAST:event_jRadioButton_BørnebilletActionPerformed

    private void jRadioButton_VoksenbilletActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_VoksenbilletActionPerformed
        // TODO add your handling code here:
        type_billet = 0;
    }//GEN-LAST:event_jRadioButton_VoksenbilletActionPerformed

    private void jRadioButton_StudenterbilletActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_StudenterbilletActionPerformed
        // TODO add your handling code here:
        type_billet = 3;
    }//GEN-LAST:event_jRadioButton_StudenterbilletActionPerformed

    private void jButton_Tilføj_IndkøbskurvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Tilføj_IndkøbskurvActionPerformed
        
        ba.koebBilletter(type_billet, (int) jSpinner1.getValue());
        
        jList_af_Billetter.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = ba.get_Billetlisten();
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jTextField_Totalbeløb.setText(ba.getTotalPrice()+" kr.");
        
        if(ba.get_Billetlisten().length != 0 && ba.getBalance() >= ba.getTotalPrice()){ // Hvis der er tilføjet nogle GYLDIGE billetter
            jButton_Køb_indkøbskurv.setForeground(Color.GREEN);
        }else{
            jButton_Køb_indkøbskurv.setForeground(Color.RED);
        }
           
        
    }//GEN-LAST:event_jButton_Tilføj_IndkøbskurvActionPerformed

    private void jRadioButton_CykelbilletActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_CykelbilletActionPerformed
        // TODO add your handling code here:
        type_billet = 4;
    }//GEN-LAST:event_jRadioButton_CykelbilletActionPerformed

    private void jRadioButton_UngdomsbilletActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_UngdomsbilletActionPerformed
        // TODO add your handling code here:
        type_billet = 1;
    }//GEN-LAST:event_jRadioButton_UngdomsbilletActionPerformed

    private void jTextField_TotalbeløbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_TotalbeløbActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jTextField_TotalbeløbActionPerformed

    private void jButton_fjern_ValgteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_fjern_ValgteActionPerformed
        // TODO add your handling code here:
        if(jList_af_Billetter.getSelectedIndex() == -1 && ba.getTotalPrice() == 0){
            return;
        }else if(jList_af_Billetter.getSelectedIndex() == -1 && jList_af_Billetter.getModel().getSize() != 0){
            ba.sletBillet(0);           
        }else{
            ba.sletBillet(jList_af_Billetter.getSelectedIndex());
        }
            // Opdater listen med billetter
            jList_af_Billetter.setModel(new javax.swing.AbstractListModel<String>() {
                String[] strings = ba.get_Billetlisten();
                public int getSize() { return strings.length; }
                public String getElementAt(int i) { return strings[i]; }
            });

            jTextField_Totalbeløb.setText(ba.getTotalPrice()+" kr.");// Udregn i alt feltet og opdater det

            if(ba.get_Billetlisten().length == 0){ // Hvis der ikke er flere billetter
                jButton_Køb_indkøbskurv.setForeground(Color.RED);
            }else if(ba.get_Billetlisten().length != 0 && ba.getBalance()> 0 && ba.getTotalPrice()> 0&& ba.getBalance() >= ba.getTotalPrice()){
                jButton_Køb_indkøbskurv.setForeground(Color.GREEN);
            }        
        

        
    }//GEN-LAST:event_jButton_fjern_ValgteActionPerformed

    private void jButton_Køb_indkøbskurvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Køb_indkøbskurvActionPerformed
        // TODO add your handling code here:
        if(ba.get_Billetlisten().length != 0 && ba.getBalance() >= ba.getTotalPrice()){ // Hvis der er billetter der kan sælges
            ba.endeligtKoeb();
            jButton_Køb_indkøbskurv.setForeground(Color.RED);
            
            // Opdater listen med billetter
            jList_af_Billetter.setModel(new javax.swing.AbstractListModel<String>() {
                String[] strings = ba.get_Billetlisten();
                public int getSize() { return strings.length; }
                public String getElementAt(int i) { return strings[i]; }
            });
            
            jTextField_Balancen.setText(""+ba.getBalance()+" kr."); // Opdatere balancen
            jTextField_Totalbeløb.setText(ba.getTotalPrice()+" kr."); // Udregn i alt feltet og opdater det            
        }
    }//GEN-LAST:event_jButton_Køb_indkøbskurvActionPerformed

    private void jTextField_BalancenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_BalancenActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jTextField_BalancenActionPerformed

    private void jButton_Køb_indkøbskurvMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_Køb_indkøbskurvMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_Køb_indkøbskurvMouseEntered

    // Når musen kommer ind i panellet
    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        // TODO add your handling code here:
        jTextField_Balancen.setText(""+ba.getBalance()+" kr."); // Opdatere balancen
        if(ba.getBalance() >= ba.getTotalPrice() && ba.getBalance()> 0 && ba.getTotalPrice()> 0){
            jButton_Køb_indkøbskurv.setForeground(Color.GREEN);
        }else{
            jButton_Køb_indkøbskurv.setForeground(Color.RED);
        }
    }//GEN-LAST:event_formMouseEntered
    // Når musen kommer udfra panellet
    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
        // TODO add your handling code here:
        jTextField_Balancen.setText(""+ba.getBalance()+" kr."); // Opdatere balancen
        if(ba.getBalance() >= ba.getTotalPrice() && ba.getBalance()> 0 && ba.getTotalPrice()> 0){
            jButton_Køb_indkøbskurv.setForeground(Color.GREEN);
        }else{
            jButton_Køb_indkøbskurv.setForeground(Color.RED);
        }
    }//GEN-LAST:event_formMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton_Køb_indkøbskurv;
    private javax.swing.JButton jButton_Tilføj_Indkøbskurv;
    private javax.swing.JButton jButton_fjern_Valgte;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList_af_Billetter;
    private javax.swing.JRadioButton jRadioButton_Børnebillet;
    private javax.swing.JRadioButton jRadioButton_Cykelbillet;
    private javax.swing.JRadioButton jRadioButton_Studenterbillet;
    private javax.swing.JRadioButton jRadioButton_Ungdomsbillet;
    private javax.swing.JRadioButton jRadioButton_Voksenbillet;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTextField jTextField_Balancen;
    private javax.swing.JTextField jTextField_Totalbeløb;
    // End of variables declaration//GEN-END:variables
}
