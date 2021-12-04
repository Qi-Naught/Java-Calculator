/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinal.jeangirard;

import View.MainWindow;
import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatDarkLaf;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author etudiant
 */
public class TPFinal_JeanGirard {

    public static void main(String[] args) {
        FlatDarkLaf.setup();
        try {
            UIManager.setLookAndFeel(new FlatDarculaLaf());
        }
        catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
        MainWindow mainWindow = new MainWindow();
        SwingUtilities.invokeLater(() -> mainWindow.setVisible(true));
    }

}