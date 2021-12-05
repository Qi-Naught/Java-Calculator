/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Command.ICommand;
import Command.CommandsManager;
import Command.ParseCommand;
import Model.IModel;
import java.util.List;

/**
 *
 * @author etudiant
 */
public class Controller implements IController {

    private CommandsManager cm;
    private IModel model;

    public Controller(CommandsManager cm, IModel model) {
        this.cm = cm;
        this.model = model;
    }

    @Override
    public void parseInput(String text) {
        DoCommand(new ParseCommand(text, model));
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
        return model.GetResults();
    }

    @Override
    public List<String> GetExpressions() {
        return model.GetExpressions();
    }

    @Override
    public IModel getModel() {
        return model;
    }

}
