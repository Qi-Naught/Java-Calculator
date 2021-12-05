/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Command.ICommand;
import Command.CommandsManager;
import Model.Model;
import java.util.List;

/**
 *
 * @author etudiant
 */
public class Controller implements IController {

    private CommandsManager cm;
    private Model model;

    public Controller(CommandsManager cm, Model model) {
        this.cm = cm;
        this.model = model;
    }

    @Override
    public void DoCommand(ICommand command) {
        cm.ExecuteCommand(command);
    }

    @Override
    public void UndoCommand() {
        cm.UndoCommand();
    }

    @Override
    public List<String> GetResults() {
        return model.results;
    }

    @Override
    public List<String> GetExpressions() {
        return model.expressions;
    }

}
