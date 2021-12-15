/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import Controllers.IController;

/**
 *
 * @author etudiant
 */
public class DeleteHistoryCommand implements ICommand {

    private final IController controller;

    public DeleteHistoryCommand(IController controller) {
        this.controller = controller;
    }

    @Override
    public void execute() {
        controller.deleteHistory();
    }

    @Override
    public void undo() {
        //sorry Barb
    }
    
}
