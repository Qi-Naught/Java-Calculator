/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinal.jeangirard;

import Commands.CommandsManager;
import Controllers.Controller;
import Models.IModel;
import Models.Model;
import Observer.ISubject;
import Views.MainWindow;
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
            UIManager.setLookAndFeel(new FlatDarkLaf());
        }
        catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
//        IConstsFile constsFile = new ConstsFile("defaultConsts.cst");
//        Map<String, String> consts = new HashMap<>();
//        consts.put("PI", "3.141592");
//        consts.put("PHI", "1.618033");
//        consts.put("C", "299792458");
//        consts.put("G", "6.674");
//        constsFile.addAll(consts);
        CommandsManager commandsManager = new CommandsManager();
        Model model = new Model();
        IModel iModel = model;
        ISubject sModel = model;
        Controller controller = new Controller(commandsManager, iModel);
        java.awt.EventQueue.invokeLater(() -> {
            new MainWindow(controller, sModel).setVisible(true);
        });
    }

}
