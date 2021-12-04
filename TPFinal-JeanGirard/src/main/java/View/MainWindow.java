/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author etudiant
 */
public class MainWindow extends javax.swing.JFrame {

    /**
     * Creates new form MainWindow
     */
    public MainWindow() {
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

        displayJPannel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList3 = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        outputExpressionField = new javax.swing.JTextArea();
        inputExpressionField = new javax.swing.JTextField();
        opButtonsJPanel = new javax.swing.JPanel();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        equalButton = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jList1.setName("name1"); // NOI18N
        jScrollPane1.setViewportView(jList1);

        jList3.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList3.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane2.setViewportView(jList3);

        outputExpressionField.setColumns(20);
        outputExpressionField.setRows(5);
        outputExpressionField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        outputExpressionField.setFocusable(false);
        jScrollPane3.setViewportView(outputExpressionField);

        inputExpressionField.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.default.foreground"));
        inputExpressionField.setForeground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
        inputExpressionField.setToolTipText("Enter the expression");
        inputExpressionField.setName(""); // NOI18N

        javax.swing.GroupLayout displayJPannelLayout = new javax.swing.GroupLayout(displayJPannel);
        displayJPannel.setLayout(displayJPannelLayout);
        displayJPannelLayout.setHorizontalGroup(
            displayJPannelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(displayJPannelLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE))
            .addComponent(inputExpressionField)
        );
        displayJPannelLayout.setVerticalGroup(
            displayJPannelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(displayJPannelLayout.createSequentialGroup()
                .addGroup(displayJPannelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
                .addComponent(inputExpressionField, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
        );

        opButtonsJPanel.setToolTipText("");
        opButtonsJPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        opButtonsJPanel.setPreferredSize(new java.awt.Dimension(30, 123));
        opButtonsJPanel.setLayout(new java.awt.GridLayout(5, 5));

        jButton18.setText("(");
        opButtonsJPanel.add(jButton18);

        jButton19.setText(")");
        opButtonsJPanel.add(jButton19);

        jButton17.setText("Mod");
        jButton17.setToolTipText("");
        opButtonsJPanel.add(jButton17);

        jButton20.setText("AC");
        opButtonsJPanel.add(jButton20);

        jButton1.setText("7");
        opButtonsJPanel.add(jButton1);

        jButton2.setText("8");
        opButtonsJPanel.add(jButton2);

        jButton3.setText("9");
        opButtonsJPanel.add(jButton3);

        jButton4.setText("+");
        opButtonsJPanel.add(jButton4);

        jButton5.setText("4");
        opButtonsJPanel.add(jButton5);

        jButton6.setText("5");
        opButtonsJPanel.add(jButton6);

        jButton7.setText("6");
        opButtonsJPanel.add(jButton7);

        jButton9.setText("-");
        opButtonsJPanel.add(jButton9);

        jButton11.setText("1");
        opButtonsJPanel.add(jButton11);

        jButton10.setText("2");
        opButtonsJPanel.add(jButton10);

        jButton8.setText("3");
        opButtonsJPanel.add(jButton8);

        jButton12.setText("*");
        opButtonsJPanel.add(jButton12);

        jButton14.setText(".");
        opButtonsJPanel.add(jButton14);

        jButton13.setText("0");
        opButtonsJPanel.add(jButton13);

        equalButton.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.default.foreground"));
        equalButton.setForeground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
        equalButton.setText("=");
        equalButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                equalButtonMouseClicked(evt);
            }
        });
        opButtonsJPanel.add(equalButton);

        jButton16.setText("/");
        opButtonsJPanel.add(jButton16);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(displayJPannel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(opButtonsJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(displayJPannel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(opButtonsJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void equalButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_equalButtonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_equalButtonMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel displayJPannel;
    private javax.swing.JButton equalButton;
    private javax.swing.JTextField inputExpressionField;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel opButtonsJPanel;
    private javax.swing.JTextArea outputExpressionField;
    // End of variables declaration//GEN-END:variables
}
