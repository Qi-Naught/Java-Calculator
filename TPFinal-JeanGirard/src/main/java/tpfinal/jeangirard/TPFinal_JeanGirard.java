/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinal.jeangirard;

import Command.CommandsManager;
import Controller.Controller;
import Model.Model;
import View.MainWindow;
import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatDarkLaf;
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
        CommandsManager cm = new CommandsManager();
        Model model = new Model();
        Controller controller = new Controller(cm, model);
        java.awt.EventQueue.invokeLater(() -> {
            new MainWindow(controller, model).setVisible(true);
        });
    }

}
