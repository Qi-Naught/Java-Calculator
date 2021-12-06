/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Commands.AssignCommand;
import Commands.ICommand;
import Commands.CommandsManager;
import Commands.ParseCommand;
import Models.IModel;
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
    public void parseInput(String input) {
        doCommand(new ParseCommand(input, model));
    }

    @Override
    public void assignInput(String input) {
        doCommand(new AssignCommand(input, model));
    }

    @Override
    public void doCommand(ICommand command) {
        cm.ExecuteCommand(command);
    }

    @Override
    public void undoCommand() {
        cm.UndoCommand();
    }

    @Override
    public List<String> getResults() {
        return model.getResults();
    }

    @Override
    public List<String> getExpressions() {
        return model.getExpressions();
    }

    @Override
    public IModel getModel() {
        return model;
    }

    @Override
    public void deleteHistory() {
        while (canUndo()) {
            undoCommand();
        }
    }

    public boolean canUndo() {
        return !cm.commandHistory.isEmpty();
    }

}
