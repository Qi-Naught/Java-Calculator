/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Parsers.ExpressionFormatter;
import java.util.Map;

/**
 *
 * @author etudiant
 */
public class AnalysisDialog extends javax.swing.JDialog {

    /**
     * Creates new form NewJDialog
     *
     * @param parent
     * @param modal
     * @param expression
     * @param constsAndVars
     */
    private final String expression;
    private final Map<String, String> variables;
    private final Map<String, String> constants;
    private int nbVars = 0;
    private int nbConsts = 0;
    private int nbNumbers = 0;
    private int nbOperators = 0;
    private String[] formattedExpr;

    public AnalysisDialog(java.awt.Frame parent, boolean modal, final String expression, final Map<String, String> constants, final Map<String, String> variables) {
        super(parent, modal);
        initComponents();
        this.expression = expression;
        this.constants = constants;
        this.variables = variables;
        analyseExpression();
        updateFields();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        countsLabel = new javax.swing.JLabel();
        countsLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        opCount = new javax.swing.JTextField();
        nbCount = new javax.swing.JTextField();
        varCount = new javax.swing.JTextField();
        constCount = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tokenList = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        countsLabel.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        countsLabel.setText("List of tokens : ");

        countsLabel1.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        countsLabel1.setText("Counts : ");

        jLabel2.setText("Operators");

        jLabel3.setText("Numbers");
        jLabel3.setToolTipText("");

        jLabel4.setText("Constants");

        jLabel5.setText("Variables");

        opCount.setEditable(false);

        nbCount.setEditable(false);

        varCount.setEditable(false);

        constCount.setEditable(false);

        tokenList.setBackground(new java.awt.Color(60, 63, 65));
        jScrollPane1.setViewportView(tokenList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(4, 4, 4))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(3, 3, 3))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(opCount)
                    .addComponent(nbCount)
                    .addComponent(countsLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(varCount)
                    .addComponent(constCount))
                .addGap(123, 123, 123)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(countsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(countsLabel1)
                    .addComponent(countsLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(opCount))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nbCount))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(varCount))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(constCount)))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField constCount;
    private javax.swing.JLabel countsLabel;
    private javax.swing.JLabel countsLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nbCount;
    private javax.swing.JTextField opCount;
    private javax.swing.JList<String> tokenList;
    private javax.swing.JTextField varCount;
    // End of variables declaration//GEN-END:variables

    private void analyseExpression() {
        formattedExpr = ExpressionFormatter.toParsableExpression(expression);

        for (String s : formattedExpr) {
            if (variables.containsKey(s)) {
                nbVars++;
            }
            else if (constants.containsKey(s)) {
                nbConsts++;
            }
            else if (isOperator(s.charAt(0))) {
                nbOperators++;
            }
            else {
                nbNumbers++;
            }
        }

    }

    private void updateFields() {
        constCount.setText(Integer.toString(nbConsts));
        varCount.setText(Integer.toString(nbVars));
        nbCount.setText(Integer.toString(nbNumbers));
        opCount.setText(Integer.toString(nbOperators));
        tokenList.setListData(formattedExpr);
    }

    public boolean isOperator(final char c) {
        return (c == '^' || c == '%' || c == '*' || c == '/' || c == '+' || c == '-' || c == '=');
    }
}
