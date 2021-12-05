/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.IController;
import Observer.IObserver;
import Observer.ISubject;
import java.awt.event.MouseEvent;

/**
 *
 * @author etudiant
 */
public class MainWindow extends javax.swing.JFrame implements IObserver {

    private IController controller;
    private ISubject subject;

    /**
     * Creates new form MainWindow
     *
     * @param controller
     * @param model
     */
    public MainWindow(IController controller, ISubject sModel) {
        initComponents();
        this.controller = controller;
        this.subject = sModel;
        subject.Attach(this);
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
        varList = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        historyList = new javax.swing.JList<>();
        inputExpressionField = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        outputExpressionField = new javax.swing.JList<>();
        opButtonsJPanel = new javax.swing.JPanel();
        buttonLeftParenthesis = new javax.swing.JButton();
        buttonRightParenthesis = new javax.swing.JButton();
        buttonAllClear = new javax.swing.JButton();
        buttonUndo = new javax.swing.JButton();
        buttonRedo = new javax.swing.JButton();
        buttonSeven = new javax.swing.JButton();
        buttonEight = new javax.swing.JButton();
        buttonNine = new javax.swing.JButton();
        buttonDivide = new javax.swing.JButton();
        buttonAssign = new javax.swing.JButton();
        buttonFour = new javax.swing.JButton();
        buttonFive = new javax.swing.JButton();
        buttonSix = new javax.swing.JButton();
        buttonMultiply = new javax.swing.JButton();
        buttonExp = new javax.swing.JButton();
        buttonOne = new javax.swing.JButton();
        buttonTwo = new javax.swing.JButton();
        buttonThree = new javax.swing.JButton();
        buttonPlus = new javax.swing.JButton();
        buttonMod = new javax.swing.JButton();
        buttonDot = new javax.swing.JButton();
        buttonZero = new javax.swing.JButton();
        buttonEqual = new javax.swing.JButton();
        buttonMinus = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        varList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        varList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        varList.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        varList.setName("name1"); // NOI18N
        jScrollPane1.setViewportView(varList);

        historyList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        historyList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        historyList.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane2.setViewportView(historyList);

        inputExpressionField.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.default.foreground"));
        inputExpressionField.setForeground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
        inputExpressionField.setToolTipText("Enter the expression");
        inputExpressionField.setCaretColor(javax.swing.UIManager.getDefaults().getColor("Button.background"));
        inputExpressionField.setName(""); // NOI18N

        outputExpressionField.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        outputExpressionField.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane3.setViewportView(outputExpressionField);

        javax.swing.GroupLayout displayJPannelLayout = new javax.swing.GroupLayout(displayJPannel);
        displayJPannel.setLayout(displayJPannelLayout);
        displayJPannelLayout.setHorizontalGroup(
            displayJPannelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(displayJPannelLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(inputExpressionField)
        );
        displayJPannelLayout.setVerticalGroup(
            displayJPannelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(displayJPannelLayout.createSequentialGroup()
                .addGroup(displayJPannelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                    .addGroup(displayJPannelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(inputExpressionField))
        );

        opButtonsJPanel.setToolTipText("");
        opButtonsJPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        opButtonsJPanel.setPreferredSize(new java.awt.Dimension(30, 123));
        opButtonsJPanel.setLayout(new java.awt.GridLayout(5, 5));

        buttonLeftParenthesis.setText("(");
        buttonLeftParenthesis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonLeftParenthesisMouseClicked(evt);
            }
        });
        opButtonsJPanel.add(buttonLeftParenthesis);

        buttonRightParenthesis.setText(")");
        buttonRightParenthesis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonRightParenthesisMouseClicked(evt);
            }
        });
        opButtonsJPanel.add(buttonRightParenthesis);

        buttonAllClear.setText("AC");
        buttonAllClear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonAllClearMouseClicked(evt);
            }
        });
        opButtonsJPanel.add(buttonAllClear);

        buttonUndo.setFont(new java.awt.Font("Liberation Sans", 0, 36)); // NOI18N
        buttonUndo.setText("←");
        buttonUndo.setToolTipText("Undo");
        buttonUndo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonUndoMouseClicked(evt);
            }
        });
        opButtonsJPanel.add(buttonUndo);

        buttonRedo.setFont(new java.awt.Font("Liberation Sans", 0, 36)); // NOI18N
        buttonRedo.setText("→");
        buttonRedo.setToolTipText("Redo");
        opButtonsJPanel.add(buttonRedo);

        buttonSeven.setText("7");
        buttonSeven.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonSevenMouseClicked(evt);
            }
        });
        opButtonsJPanel.add(buttonSeven);

        buttonEight.setText("8");
        buttonEight.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonEightMouseClicked(evt);
            }
        });
        opButtonsJPanel.add(buttonEight);

        buttonNine.setText("9");
        buttonNine.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonNineMouseClicked(evt);
            }
        });
        opButtonsJPanel.add(buttonNine);

        buttonDivide.setText("/");
        buttonDivide.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonDivideMouseClicked(evt);
            }
        });
        opButtonsJPanel.add(buttonDivide);

        buttonAssign.setText("Assign");
        opButtonsJPanel.add(buttonAssign);

        buttonFour.setText("4");
        buttonFour.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonFourMouseClicked(evt);
            }
        });
        opButtonsJPanel.add(buttonFour);

        buttonFive.setText("5");
        buttonFive.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonFiveMouseClicked(evt);
            }
        });
        opButtonsJPanel.add(buttonFive);

        buttonSix.setText("6");
        buttonSix.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonSixMouseClicked(evt);
            }
        });
        opButtonsJPanel.add(buttonSix);

        buttonMultiply.setText("*");
        buttonMultiply.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonMultiplyMouseClicked(evt);
            }
        });
        opButtonsJPanel.add(buttonMultiply);

        buttonExp.setText("^");
        buttonExp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonExpMouseClicked(evt);
            }
        });
        opButtonsJPanel.add(buttonExp);

        buttonOne.setText("1");
        buttonOne.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonOneMouseClicked(evt);
            }
        });
        opButtonsJPanel.add(buttonOne);

        buttonTwo.setText("2");
        buttonTwo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonTwoMouseClicked(evt);
            }
        });
        opButtonsJPanel.add(buttonTwo);

        buttonThree.setText("3");
        buttonThree.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonThreeMouseClicked(evt);
            }
        });
        opButtonsJPanel.add(buttonThree);

        buttonPlus.setText("+");
        buttonPlus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonPlusMouseClicked(evt);
            }
        });
        opButtonsJPanel.add(buttonPlus);

        buttonMod.setText("Mod");
        buttonMod.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonModMouseClicked(evt);
            }
        });
        opButtonsJPanel.add(buttonMod);

        buttonDot.setText(".");
        buttonDot.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonDotMouseClicked(evt);
            }
        });
        opButtonsJPanel.add(buttonDot);

        buttonZero.setText("0");
        buttonZero.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonZeroMouseClicked(evt);
            }
        });
        opButtonsJPanel.add(buttonZero);

        buttonEqual.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.default.foreground"));
        buttonEqual.setForeground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
        buttonEqual.setText("=");
        buttonEqual.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonEqualMouseClicked(evt);
            }
        });
        opButtonsJPanel.add(buttonEqual);
        buttonEqual.getAccessibleContext().setAccessibleDescription("");

        buttonMinus.setText("-");
        buttonMinus.setToolTipText("");
        buttonMinus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonMinusMouseClicked(evt);
            }
        });
        opButtonsJPanel.add(buttonMinus);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(displayJPannel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(opButtonsJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(displayJPannel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(opButtonsJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonZeroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonZeroMouseClicked
        if (evt.getButton() == MouseEvent.BUTTON1) {
            inputExpressionField.setText(inputExpressionField.getText() + '0');
        }
    }//GEN-LAST:event_buttonZeroMouseClicked

    private void buttonOneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonOneMouseClicked
        if (evt.getButton() == MouseEvent.BUTTON1) {
            inputExpressionField.setText(inputExpressionField.getText() + '1');
        }

    }//GEN-LAST:event_buttonOneMouseClicked

    private void buttonTwoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonTwoMouseClicked
        if (evt.getButton() == MouseEvent.BUTTON1) {
            inputExpressionField.setText(inputExpressionField.getText() + '2');
        }
    }//GEN-LAST:event_buttonTwoMouseClicked

    private void buttonThreeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonThreeMouseClicked
        if (evt.getButton() == MouseEvent.BUTTON1) {
            inputExpressionField.setText(inputExpressionField.getText() + '3');
        }
    }//GEN-LAST:event_buttonThreeMouseClicked

    private void buttonFourMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonFourMouseClicked
        if (evt.getButton() == MouseEvent.BUTTON1) {
            inputExpressionField.setText(inputExpressionField.getText() + '4');
        }
    }//GEN-LAST:event_buttonFourMouseClicked

    private void buttonFiveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonFiveMouseClicked
        if (evt.getButton() == MouseEvent.BUTTON1) {
            inputExpressionField.setText(inputExpressionField.getText() + '5');
        }
    }//GEN-LAST:event_buttonFiveMouseClicked

    private void buttonSixMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonSixMouseClicked
        if (evt.getButton() == MouseEvent.BUTTON1) {
            inputExpressionField.setText(inputExpressionField.getText() + '6');
        }
    }//GEN-LAST:event_buttonSixMouseClicked

    private void buttonSevenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonSevenMouseClicked
        if (evt.getButton() == MouseEvent.BUTTON1) {
            inputExpressionField.setText(inputExpressionField.getText() + '7');
        }
    }//GEN-LAST:event_buttonSevenMouseClicked

    private void buttonEightMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonEightMouseClicked
        if (evt.getButton() == MouseEvent.BUTTON1) {
            inputExpressionField.setText(inputExpressionField.getText() + '8');
        }
    }//GEN-LAST:event_buttonEightMouseClicked

    private void buttonNineMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonNineMouseClicked
        if (evt.getButton() == MouseEvent.BUTTON1) {
            inputExpressionField.setText(inputExpressionField.getText() + '9');
        }
    }//GEN-LAST:event_buttonNineMouseClicked

    private void buttonDotMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonDotMouseClicked
        if (evt.getButton() == MouseEvent.BUTTON1) {
            inputExpressionField.setText(inputExpressionField.getText() + '.');
        }
    }//GEN-LAST:event_buttonDotMouseClicked

    private void buttonEqualMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonEqualMouseClicked
        if (evt.getButton() == MouseEvent.BUTTON1) {
            controller.parseInput(inputExpressionField.getText());
            inputExpressionField.setText("");
        }
    }//GEN-LAST:event_buttonEqualMouseClicked

    private void buttonMinusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonMinusMouseClicked
        if (evt.getButton() == MouseEvent.BUTTON1) {
            inputExpressionField.setText(inputExpressionField.getText() + '-');
        }
    }//GEN-LAST:event_buttonMinusMouseClicked

    private void buttonPlusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonPlusMouseClicked
        if (evt.getButton() == MouseEvent.BUTTON1) {
            inputExpressionField.setText(inputExpressionField.getText() + '+');
        }
    }//GEN-LAST:event_buttonPlusMouseClicked

    private void buttonMultiplyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonMultiplyMouseClicked
        if (evt.getButton() == MouseEvent.BUTTON1) {
            inputExpressionField.setText(inputExpressionField.getText() + '*');
        }
    }//GEN-LAST:event_buttonMultiplyMouseClicked

    private void buttonDivideMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonDivideMouseClicked
        if (evt.getButton() == MouseEvent.BUTTON1) {
            inputExpressionField.setText(inputExpressionField.getText() + '/');
        }
    }//GEN-LAST:event_buttonDivideMouseClicked

    private void buttonLeftParenthesisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonLeftParenthesisMouseClicked
        if (evt.getButton() == MouseEvent.BUTTON1) {
            inputExpressionField.setText(inputExpressionField.getText() + '(');
        }
    }//GEN-LAST:event_buttonLeftParenthesisMouseClicked

    private void buttonRightParenthesisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonRightParenthesisMouseClicked
        if (evt.getButton() == MouseEvent.BUTTON1) {
            inputExpressionField.setText(inputExpressionField.getText() + ')');
        }
    }//GEN-LAST:event_buttonRightParenthesisMouseClicked

    private void buttonAllClearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonAllClearMouseClicked
        if (evt.getButton() == MouseEvent.BUTTON1) {
            inputExpressionField.setText("");
        }
    }//GEN-LAST:event_buttonAllClearMouseClicked

    private void buttonExpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonExpMouseClicked
        if (evt.getButton() == MouseEvent.BUTTON1) {
            inputExpressionField.setText(inputExpressionField.getText() + '^');
        }
    }//GEN-LAST:event_buttonExpMouseClicked

    private void buttonModMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonModMouseClicked
        if (evt.getButton() == MouseEvent.BUTTON1) {
            inputExpressionField.setText(inputExpressionField.getText() + '%');
        }
    }//GEN-LAST:event_buttonModMouseClicked

    private void buttonUndoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonUndoMouseClicked
        if (evt.getButton() == MouseEvent.BUTTON1 && !"".equals(inputExpressionField.getText())) {
            inputExpressionField.setText(inputExpressionField.getText().substring(0, inputExpressionField.getText().length() - 1));
        }
    }//GEN-LAST:event_buttonUndoMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAllClear;
    private javax.swing.JButton buttonAssign;
    private javax.swing.JButton buttonDivide;
    private javax.swing.JButton buttonDot;
    private javax.swing.JButton buttonEight;
    private javax.swing.JButton buttonEqual;
    private javax.swing.JButton buttonExp;
    private javax.swing.JButton buttonFive;
    private javax.swing.JButton buttonFour;
    private javax.swing.JButton buttonLeftParenthesis;
    private javax.swing.JButton buttonMinus;
    private javax.swing.JButton buttonMod;
    private javax.swing.JButton buttonMultiply;
    private javax.swing.JButton buttonNine;
    private javax.swing.JButton buttonOne;
    private javax.swing.JButton buttonPlus;
    private javax.swing.JButton buttonRedo;
    private javax.swing.JButton buttonRightParenthesis;
    private javax.swing.JButton buttonSeven;
    private javax.swing.JButton buttonSix;
    private javax.swing.JButton buttonThree;
    private javax.swing.JButton buttonTwo;
    private javax.swing.JButton buttonUndo;
    private javax.swing.JButton buttonZero;
    private javax.swing.JPanel displayJPannel;
    private javax.swing.JList<String> historyList;
    private javax.swing.JTextField inputExpressionField;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel opButtonsJPanel;
    private javax.swing.JList<String> outputExpressionField;
    private javax.swing.JList<String> varList;
    // End of variables declaration//GEN-END:variables

    @Override
    public void Refresh() {
        historyList.setListData(controller.getModel().GetExpressions().toArray(new String[0]));
        outputExpressionField.setListData(controller.getModel().GetResults().toArray(new String[0]));
    }
}
