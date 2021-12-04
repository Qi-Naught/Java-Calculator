/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *
 * @author etudiant
 */
public class CommandsManager {
     private final Deque<ICommand> commandHistory;

    public CommandsManager() {
        commandHistory = new ArrayDeque<>();
    }

    public void ExecuterCommande(ICommand commande) {
        commande.Execute();
        commandHistory.push(commande);
    }

    public void AnnulerCommande() {
        if (!commandHistory.isEmpty()) {
            commandHistory.pop().Undo();
        }
    }
}
